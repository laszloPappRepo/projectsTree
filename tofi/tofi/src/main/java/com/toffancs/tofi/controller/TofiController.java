package com.toffancs.tofi.controller;

import com.toffancs.tofi.model.Tofi;
import com.toffancs.tofi.repository.TofinterfaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TofiController {

    @Autowired
    TofinterfaceRepo tofinterfaceRepo;
/*
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }
*/
    @RequestMapping({"/index"})
    public String listOfTofi(Model model){
            model.addAttribute("list", tofinterfaceRepo.findAll());
        return "index";
    }

    @RequestMapping(value = "/newTofi", method = RequestMethod.GET)
    public String addNewTofi(Model model) {
        model.addAttribute("newTofi", new Tofi());
        return "newTofi";
    }

    @RequestMapping(value = "/newTofi", method = RequestMethod.POST)
    public String addNewTofi(@ModelAttribute Tofi tofi) {
        tofinterfaceRepo.save(tofi);
        return "redirect:/index";
    }
}
