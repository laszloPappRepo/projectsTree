package gemini.superHeroAPI.controller;

import gemini.superHeroAPI.Service.SuperHeroApiService;
import gemini.superHeroAPI.model.HeroResponse;
import gemini.superHeroAPI.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HeroRestController {

    @Autowired
    private SuperHeroApiService superHeroApiService;

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping("/{id}")
    public ModelAndView getByID(@RequestParam("id") Long id) throws Exception {
        ModelAndView mav = new ModelAndView("/details");
        HeroResponse heroResponseByID = superHeroApiService.getHeroResponseFromSuperHeroAPIByID(id);
        mav.addObject("list", heroResponseByID);
        return mav;
    }

    @GetMapping("search/{name}")
    public ModelAndView getByName(@RequestParam("name") String name) throws Exception{
        ModelAndView mav = new ModelAndView("/details");
        HeroResponse heroResponseByName;
        heroResponseByName = superHeroApiService.getHeroResponseFromSuperHeroAPIByName(name);
        mav.addObject("list", heroResponseByName);
        return mav;
    }
}
