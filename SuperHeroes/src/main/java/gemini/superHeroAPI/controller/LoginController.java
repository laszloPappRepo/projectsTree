package gemini.superHeroAPI.controller;

import gemini.superHeroAPI.Service.LoginValidationService;
import gemini.superHeroAPI.modell.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private LoginValidationService loginValidationService;
    private NotFoundException notFoundException;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String validator(Model model,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password){
        if (loginValidationService.accountValidator(username, password) == true){
            return "redirect:/index";
        }
        return String.valueOf(model.addAttribute("error", notFoundException.toString(username, password)));
    }
}
