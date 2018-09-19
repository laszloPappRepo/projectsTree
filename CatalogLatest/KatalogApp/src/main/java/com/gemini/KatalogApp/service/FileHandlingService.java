package com.gemini.KatalogApp.service;

import com.gemini.KatalogApp.model.ComixCover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Service
public class FileHandlingService {

    @Autowired
    ZipCompressor zipCompressor;
    @Autowired
    RarCompressor rarCompressor;

    public static String tempRepo = "C:\\ewoKatalog\\temp\\";
    public static String toCopy = "C:\\ewoKatalog\\temp\\tocopy\\";

    /**
     * Receive a compressed file and returns it's title and it's first .jpg file inside a ComixCover Entity
     * @param fileInput is a compressed file
     * @return a ComixCover entity
     * @throws IOException
     */
    public ComixCover fileUpload(MultipartFile fileInput) throws IOException {
        ComixCover cover = new ComixCover();
        byte[] bytes = new byte[0];

        new File(toCopy).mkdirs();
        File targetFile = new File(toCopy, fileInput.getOriginalFilename());
        fileInput.transferTo(targetFile);

        try {
            int byteRead, bytesBuffered = 0;
            while((byteRead = fileInput.getInputStream().read(bytes)) > 0) {
                bytes = fileInput.getBytes();
                bytesBuffered += byteRead;
                if (bytesBuffered > 1024 * 1024){ //flush after 1MB
                    bytesBuffered = 0;
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                out.flush();
            }
        }
        Path path = Paths.get(tempRepo + fileInput.getOriginalFilename());
        Files.write(path, bytes);
        cover.setTitle(fileInput.getOriginalFilename());
        //calling the readBytesFromFile method
        cover.setComicCover(readBytesFromFile(fileInput));
        return cover;
    }

    public byte[] readBytesFromFile(MultipartFile fileInput) {
        FileInputStream fileInputStream = null;
        Path pathFrom = Paths.get(toCopy + fileInput.getOriginalFilename());
        File file = null;
        byte[] bytesArray = null;

        try {
            if (fileInput.getOriginalFilename().contains(".cbz")) {
                file = zipCompressor.unzip(pathFrom.toString(), tempRepo);
            }else if (fileInput.getOriginalFilename().contains(".cbr")){
                file = rarCompressor.extractFiles(pathFrom, Paths.get(tempRepo), tempRepo);
            }
            bytesArray = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytesArray;
    }

    /**
     * @param destDirectory
     * @return
     */
    public File getCover(String destDirectory) {
        List<File> pages = new ArrayList<>();
        File cover = null;
        File dir = new File(destDirectory);
        File[] directoryListing = dir.listFiles();
        //if the destination directory not empty
        if (directoryListing != null) {
            //iterating trough destination directory
            for (File child : directoryListing) {
                //if the destination directory's content is a folder
                if (child.isDirectory()) {
                    File[] content = child.listFiles();
                    for (int i = 0; i < content.length; i++) {
                        if (content[i].getName().contains(".jpg")) {
                            pages.add(content[i]);
                        }
                    }
                    //the destination directory isn't a folder
                } else {
                    if (child.getName().contains(".jpg"))
                        pages.add(child);
                }
            }
            cover = pages.get(0);
            //the destination directory is empty
        } else {
            out.println("Directory is empty");
        }
        return cover;
    }

    public void deleteFolderContent(MultipartFile fileInput) {
        String getFolderName = fileInput.getOriginalFilename();
        int indexOfLast = getFolderName.lastIndexOf(".");
        String newString = getFolderName;
        if (indexOfLast >= 0) newString = getFolderName.substring(0, indexOfLast);
        out.println(newString);

        File file = new File(tempRepo);
        String[] myFiles;
        myFiles = file.list();
        for (int i = 0; i < myFiles.length; i++) {
            File myFile = new File(file, myFiles[i]);
            myFile.delete();
            if (myFile.isDirectory()) {
                deleteDirectory(myFile);
            }
        }
    }

    public static boolean deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDirectory(children[i]);
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}

