package gemini.superHeroAPI.controller;
import gemini.superHeroAPI.Service.SuperHeroApiService;
import gemini.superHeroAPI.model.HeroResponse;
import gemini.superHeroAPI.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HeroController {

    @Autowired
    private SuperHeroApiService superHeroApiService;

    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private AppearanceRepository appearanceRepository;
    @Autowired
    private BiographyRepository biographyRepository;
    @Autowired
    private ConnectionsRepository connectionRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private PowerstatRepository powerstatRepository;
    @Autowired
    private WorkRepository workRepository;

    private HeroResponse heroResponseByID;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }

    @RequestMapping(value = "/{id}/saveHero", method = RequestMethod.GET)
    public String saveHeroGet(@PathVariable long id, Model model) throws Exception {
        model.addAttribute("saveHero", superHeroApiService.getHeroResponseFromSuperHeroAPIByID(id));
        return "/saveHero";
    }

    @RequestMapping(value = "/{id}/saveHero", method = RequestMethod.POST)
    public String saveHeroSave(@PathVariable long id, @ModelAttribute HeroResponse hero) throws Exception {
        hero = superHeroApiService.getHeroResponseFromSuperHeroAPIByID(id);
        hero.getAppearance().setId(id);
        appearanceRepository.save(hero.getAppearance());
        hero.getBiography().setId(id);
        biographyRepository.save(hero.getBiography());
        hero.getConnections().setId(id);
        connectionRepository.save(hero.getConnections());
        hero.getImage().setId(id);
        imageRepository.save(hero.getImage());
        hero.getPowerstats().setId(id);
        powerstatRepository.save(hero.getPowerstats());
        hero.getWork().setId(id);
        workRepository.save(hero.getWork());
        hero.setId(id);
        heroRepository.save(hero);
        return "/index";
    }

    @RequestMapping(value = "/league", method = RequestMethod.GET)
    public String leaguePage(Model model){
        model.addAttribute("list", heroRepository.findAll());
        return "league";
    }
}

