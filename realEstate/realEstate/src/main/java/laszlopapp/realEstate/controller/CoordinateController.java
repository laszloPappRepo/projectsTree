package laszlopapp.realEstate.controller;

import laszlopapp.realEstate.model.CalculationResultLog;
import laszlopapp.realEstate.repository.CalculatedDataRepository;
import laszlopapp.realEstate.repository.RealEstateRepository;
import laszlopapp.realEstate.service.CalculateDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class CoordinateController {

    @Autowired
    @Resource(name = "realEstateRepository")
    private RealEstateRepository realEstateRepository;

    @Autowired
    private CalculatedDataRepository calculatedDataRepository;

    @Autowired
    @Resource(name = "calculateDistanceService")
    private CalculateDistanceService calculateDistanceService;

    @RequestMapping({"/"})
    public String pageOfRealEstates(){
        return "index";
    }

    @RequestMapping(value = "/calculatePrice", method = RequestMethod.POST)
    public String getCoordinates(Model model,
                                 @RequestParam("givenSquareMeter") double givenSquareMeter,
                                 @RequestParam("latitudeDegree") int latitudeDegree,
                                 @RequestParam("latitudeMinute") int latitudeMinute,
                                 @RequestParam("latitudeSecond") double latitudeSecond,
                                 @RequestParam("latitudeCompassPoint") String latitudeCompassPoint,
                                 @RequestParam("longitudeDegree") int longitudeDegree,
                                 @RequestParam("longitudeMinute") int longitudeMinute,
                                 @RequestParam("longitudeSecond") double longitudeSecond,
                                 @RequestParam("longitudeCompassPoint") String longitudeCompassPoint)
    {
            CalculationResultLog calcData = new CalculationResultLog(latitudeDegree, latitudeMinute, latitudeSecond, latitudeCompassPoint, longitudeDegree,
                    longitudeMinute, longitudeSecond, longitudeCompassPoint, givenSquareMeter, 0);
            calcData = calculateDistanceService.closestPoints(calcData);
            model.addAttribute("calculationResultLog", calcData);
            calculatedDataRepository.save(calcData);
        return "index";
    }
}
