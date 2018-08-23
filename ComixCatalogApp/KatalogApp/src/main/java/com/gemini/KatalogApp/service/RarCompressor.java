package com.gemini.KatalogApp.service;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;


@Component
public class RarCompressor {

    @Autowired
    FileHandlingService fileHandlingService;

     public File extractFiles(Path archivePath, Path destinationPath, String toSaveCover) throws IOException {

         Optional<Archive> archiveOptional = getArchive(archivePath);
         if (archiveOptional.isPresent()) {
             archiveOptional.get().getFileHeaders().forEach((currFileHeader) -> extractHeader(destinationPath,
                     archiveOptional,
                     currFileHeader));
             archiveOptional.get().close();
         }
         return fileHandlingService.getCover(toSaveCover);
     }

     private Optional<Archive> getArchive(Path filePath) throws IOException {
         try {
             return Optional.ofNullable(new Archive(filePath.toFile()));
         } catch (RarException ex) {
             throw new IOException();
         }
     }

     private void extractHeader(Path destinationPath, Optional<Archive> archiveOptional, FileHeader fileHeaderToExtract) {
         try{
             if (fileHeaderToExtract.isDirectory()) {
                 Files.createDirectories(destinationPath.resolve(fileHeaderToExtract.getFileNameString()));
             } else {
                 extractFile(destinationPath, archiveOptional, fileHeaderToExtract);
             }
         }catch (IOException ex){
             throw new UncheckedIOException(ex);
         }
     }

     private void extractFile(Path destinationPath, Optional<Archive> archiveOptional,
                              FileHeader currFileHeader) throws IOException {
         try {
             File fileToExtract = createFile(destinationPath, currFileHeader);
             OutputStream outputStream = new FileOutputStream(fileToExtract);
             archiveOptional.get().extractFile(currFileHeader, outputStream);
             outputStream.close();
         } catch (RarException ex) {
             throw new IOException();
         }
     }

     private File createFile(Path destinationPath, FileHeader fileHeader) throws IOException {
         Path path = destinationPath.resolve(fileHeader.getFileNameString());
         Files.createDirectories(path.getParent());
         Files.createFile(path);
         return path.toFile();
     }
/*
    public File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File toConvertingFile = new File(file.getOriginalFilename());
        toConvertingFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(toConvertingFile);
        fos.write(file.getBytes());
        fos.close();
        return toConvertingFile;
    }
    */
}
