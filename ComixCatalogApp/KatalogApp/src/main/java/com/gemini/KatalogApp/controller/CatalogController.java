package com.gemini.KatalogApp.controller;


import com.gemini.KatalogApp.repository.ComixCoverRepo;
import com.gemini.KatalogApp.service.FileHandlingService;
import com.gemini.KatalogApp.service.GlobalExceptionHandler;
import com.gemini.KatalogApp.service.ImageHandlingService;
import com.github.junrar.exception.RarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class CatalogController {
    ComixCoverRepo comixCoverRepo;
    FileHandlingService fileHandlingService;
    GlobalExceptionHandler globalExceptionHandler;
    ImageHandlingService imageHandlingService;

    public CatalogController(){}

    @Autowired
    public CatalogController(ComixCoverRepo comixCoverRepo,
                             FileHandlingService fileHandlingService,
                             GlobalExceptionHandler globalExceptionHandler,
                             ImageHandlingService imageHandlingService){
        this.comixCoverRepo = comixCoverRepo;
        this.fileHandlingService = fileHandlingService;
        this.globalExceptionHandler = globalExceptionHandler;
        this.imageHandlingService = imageHandlingService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }

    @RequestMapping("/DCNextWeek")
    public String getDcNextWeek(){
        return "redirect:https://getcomics.info/tag/dc-week/";
    }

    @RequestMapping("/MarvelNextWeek")
    public String getMarvelNextWeek(){
        return "redirect:https://getcomics.info/tag/marvel-now/";
    }

    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public String collectionPage(Model model) throws Exception {
        model.addAttribute("list", imageHandlingService.createCollectionEntityListFromDB());
        return "collection";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException, RarException, de.innosystec.unrar.exception.RarException {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute
                    ("message", "Please select a file to upload");
            return "redirect:/";
        } else {
            try {
              comixCoverRepo.save(fileHandlingService.fileUpload(file, redirectAttributes));
            } catch (IOException e) {e.printStackTrace();}
            fileHandlingService.deleteFolderContent(file);
            return "redirect:/";
        }
    }
}
