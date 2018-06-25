package gemini.superHeroAPI.controller;

import gemini.superHeroAPI.Service.SuperHeroApiService;
import gemini.superHeroAPI.model.HeroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HeroRestController {

    @Autowired
    private SuperHeroApiService superHeroApiService;

    @GetMapping("/{id}")
    public ModelAndView getByID(@RequestParam("id") Long id) throws Exception {
        ModelAndView mav = new ModelAndView("/index");
        HeroResponse heroResponseByID;
        heroResponseByID = superHeroApiService.getHeroResponseFromSuperHeroAPIByID(id);
        mav.addObject("list", heroResponseByID);
        return mav;
    }

    @GetMapping("search/{name}")
    public Object getByName(@RequestParam("name") String name) throws Exception{
        HeroResponse heroResponseByName;
        heroResponseByName = superHeroApiService.getHeroResponseFromSuperHeroAPIByName(name);
        return heroResponseByName;
    }
}
