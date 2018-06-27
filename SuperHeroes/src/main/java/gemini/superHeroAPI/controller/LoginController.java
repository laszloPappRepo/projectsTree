package gemini.superHeroAPI.controller;

import gemini.superHeroAPI.Service.LoginValidationService;
import gemini.superHeroAPI.model.Account;
import gemini.superHeroAPI.model.NotFoundException;
import gemini.superHeroAPI.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginValidationService loginValidationService;

    @Autowired
    private AccountRepository accountRepository;

    private NotFoundException notFoundException;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String validator(Model model,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password){
        if (loginValidationService.accountValidator(username, password)){
            return "redirect:index";
        }else {
            model.addAttribute("error", new NotFoundException("The username: " + username
                    + " and/or the password: " + password + " does not exist."));
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newUserPage(Model model) {
        model.addAttribute("addUser", new Account());
        return "newUser";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute Account account) {
        if (account.getPassword().equals(account.getConfirmPassword())) {
            accountRepository.save(account);
        }else{
            return "newUser";
        }
        return "redirect:/";
    }
}
