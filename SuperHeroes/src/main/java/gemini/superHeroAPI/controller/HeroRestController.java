package gemini.superHeroAPI.controller;

import gemini.superHeroAPI.model.HeroResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroRestController {

    private String accessToken = "1798381083516711";

    @RequestMapping(value = "http://superheroapi.com/api/{accessToken}/{id}", method = RequestMethod.GET)
    public Model getHeroByID(Model model, @PathVariable Long id){
        return model.addAttribute("list", new HeroResponse());
    }
}
