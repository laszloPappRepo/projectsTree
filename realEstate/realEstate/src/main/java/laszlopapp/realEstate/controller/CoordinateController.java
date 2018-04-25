package laszlopapp.realEstate.controller;
import laszlopapp.realEstate.model.ErrorMessage;
import laszlopapp.realEstate.model.RealEstate;
import laszlopapp.realEstate.repository.CoordinateRepository;
import laszlopapp.realEstate.service.CalculateDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.ListUtils;

import java.util.Collections;

@Controller
public class CoordinateController {

    @Autowired
    CoordinateRepository coordinateRepository;

    @Autowired
    CalculateDistanceService calculateDistanceService;

    RealEstate realEstate;

    @RequestMapping({"/"})
    public String listOfRealEstates(Model model){
        if (ListUtils.size(Collections.singletonList(coordinateRepository.findAll())) != 0) {
            model.addAttribute("list", coordinateRepository.findAll());
        }else {
            return String.valueOf(new ErrorMessage("The database is empty"));
        }
        return "index";
    }

    @RequestMapping(value = "/getCoordinates", method = RequestMethod.GET)
    public String getCoordinates(@PathVariable double latitude, @PathVariable double longitude){
        calculateDistanceService.distance(latitude, longitude,
                realEstate.getLatitude(), realEstate.getLongitude());
        return "index";
    }
}
