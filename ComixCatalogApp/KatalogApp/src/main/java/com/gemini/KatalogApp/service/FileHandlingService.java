package com.gemini.KatalogApp.service;

import com.gemini.KatalogApp.controller.CatalogController;
import com.gemini.KatalogApp.model.ComixCover;
import com.gemini.KatalogApp.repository.ComixCoverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileHandlingService {

    @Autowired
    ComixCoverRepo comixCoverRepo;
    @Autowired
    ZipCompressor zipCompressor;
    @Autowired
    RarCompressor rarCompressor;

    private static String toSaveCover = CatalogController.uploadingDir;
    private static String fileFrom = "C:\\Comics\\";

    /**
     * Receive a compressed file and returns it's title and it's first .jpg file inside a ComixCover Entity
     *
     * @param fileInput is a compressed file
     * @param redirectAttributes
     * @return a ComixCover entity
     * @throws IOException
     */
    public ComixCover fileUpload(MultipartFile fileInput, RedirectAttributes redirectAttributes) throws IOException {

        ComixCover cover = new ComixCover();
        byte[] bytes = new byte[0];
        try {
            bytes = fileInput.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path = Paths.get(toSaveCover + fileInput.getOriginalFilename());
        Files.write(path, bytes);

        redirectAttributes.addFlashAttribute("message", "Uploading process successful");
        cover.setTitle(fileInput.getOriginalFilename());
        //calling the readBytesFromFile method
        cover.setCover(readBytesFromFile(fileInput));
        return cover;
    }

    public byte[] readBytesFromFile(MultipartFile fileInput) throws IOException {

        FileInputStream fileInputStream = null;
        Path pathFrom = Paths.get(fileFrom + fileInput.getOriginalFilename());
        File file = null;
        byte[] bytesArray = null;
        try {
            if (fileInput.getOriginalFilename().contains(".cbz")) {
                file = zipCompressor.unzip(pathFrom.toString(), toSaveCover);
            }else if (fileInput.getOriginalFilename().contains(".cbr")){
                file = rarCompressor.extractFiles(pathFrom, Paths.get(toSaveCover), toSaveCover);
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
            System.out.println("Directory is empty");
        }
        return cover;
    }

    public void deleteFolderContent(MultipartFile fileInput) {
        String getFolderName = fileInput.getOriginalFilename();
        int indexOfLast = getFolderName.lastIndexOf(".");
        String newString = getFolderName;
        if (indexOfLast >= 0) newString = getFolderName.substring(0, indexOfLast);
        System.out.println(newString);

        File file = new File(toSaveCover);
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

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File fileToConvert = new File( multipart.getOriginalFilename());
        multipart.transferTo(fileToConvert);
        return fileToConvert;
    }
}

