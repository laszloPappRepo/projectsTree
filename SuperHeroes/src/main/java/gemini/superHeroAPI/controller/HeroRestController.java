package gemini.superHeroAPI.controller;

import gemini.superHeroAPI.modell.HeroResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroRestController {

    @RequestMapping(value = "http://superheroapi.com/api/{id}", method = RequestMethod.GET)
    public HeroResponse getHeroByID(@PathVariable Long id){
        return new HeroResponse(id);
    }
}
