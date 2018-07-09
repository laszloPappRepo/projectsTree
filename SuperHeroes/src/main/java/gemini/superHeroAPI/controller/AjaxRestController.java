package gemini.superHeroAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hero")
public class AjaxRestController {

  /*  @RequestMapping(value = "/springAjax", method = RequestMethod.GET)
    public HeroResponse arenaPage(){
        HeroResponse heroResponse = null;
        try {
            heroResponse = new HeroResponse("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return heroResponse;
    } */
}
