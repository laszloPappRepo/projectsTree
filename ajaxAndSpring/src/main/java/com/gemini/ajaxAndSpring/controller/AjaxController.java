package com.gemini.ajaxAndSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AjaxController {

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public String indexPage(){
        return "springAjax";
    }
}
