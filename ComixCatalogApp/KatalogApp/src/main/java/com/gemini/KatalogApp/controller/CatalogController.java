package com.gemini.KatalogApp.controller;

import com.gemini.KatalogApp.model.ComixCover;
import com.gemini.KatalogApp.repository.ComixCoverRepo;
import com.gemini.KatalogApp.service.FileHandlingService;
import com.gemini.KatalogApp.service.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class CatalogController {

    public static final String uploadingDir = "C:\\ewoKatalog\\temp\\";

    ComixCoverRepo comixCoverRepo;
    FileHandlingService fileHandlingService;
    GlobalExceptionHandler globalExceptionHandler;

    public CatalogController(){}

    @Autowired
    public CatalogController(ComixCoverRepo comixCoverRepo,
                             FileHandlingService fileHandlingService,
                             GlobalExceptionHandler globalExceptionHandler){
        this.comixCoverRepo = comixCoverRepo;
        this.fileHandlingService = fileHandlingService;
        this.globalExceptionHandler = globalExceptionHandler;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
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
    public String collectionPage(Model model) {
        model.addAttribute("list", comixCoverRepo.findAll());
        return "collection";
    }

    @RequestMapping(value = "/asc", method = RequestMethod.GET)
    public String collectionAsc(Model model) {
        model.addAttribute("list", comixCoverRepo.orderedByTitleAsc());
        return "collection";
    }

    @RequestMapping(value = "/desc", method = RequestMethod.GET)
    public String collectionDesc(Model model) {
        model.addAttribute("list", comixCoverRepo.orderedByTitleDesc());
        return "collection";
    }

    @RequestMapping(value = "/multi", method = RequestMethod.POST)
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles,
                                RedirectAttributes redirectAttributes) {

        for (int i = 0; i < uploadingFiles.length; i++) {
            if (uploadingFiles[i].isEmpty()) {
                redirectAttributes.addFlashAttribute("message", "Please select files to upload");
                return "redirect:/index";
            } else {
                try {
                    for (MultipartFile uploadedFile : uploadingFiles) {
                        comixCoverRepo.save(fileHandlingService.fileUpload
                                (uploadedFile, redirectAttributes.addFlashAttribute
                                        (uploadingFiles)));
                        fileHandlingService.deleteFolderContent(uploadedFile);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "redirect:/index";
            }
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "{id}/image")
    @ResponseBody
    public byte[] returnCoverFromDB(@PathVariable long id)  {
        byte[] image = comixCoverRepo.findById(id).get().getComicCover();
        return image;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getComixListByTitle(Model model,
                                      String search,
                                      RedirectAttributes redirectAttributes){
        if (comixCoverRepo.findAllByTitleIsContaining("%" + search + "%").size() > 0) {
            model.addAttribute("list", comixCoverRepo.findAllByTitleIsContaining("%" + search + "%"));
        }else {
            redirectAttributes.addFlashAttribute("message", "there is no such comix :(");
        }
        return "collection";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteComixById(@PathVariable long id) {
        comixCoverRepo.deleteById(id);
        return "redirect:/collection";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editComixByIdGet(@PathVariable long id, Model model) {
        model.addAttribute("edit", comixCoverRepo.findById(id));
        return "/editComix";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String editComixByIdPost(@ModelAttribute ComixCover comixCover, @PathVariable long id) {
        comixCover.setComicCover(comixCoverRepo.findById(id).get().getComicCover());
        comixCoverRepo.save(comixCover);
        return "redirect:/collection";
    }
}
