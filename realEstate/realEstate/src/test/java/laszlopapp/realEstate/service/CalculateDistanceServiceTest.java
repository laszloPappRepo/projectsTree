package laszlopapp.realEstate.service;
import laszlopapp.realEstate.model.CalculationResultLog;
import laszlopapp.realEstate.model.RealEstate;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CalculateDistanceServiceTest {

    List<RealEstate> realEstates = new ArrayList<>();

    RealEstate realEstate1 = new RealEstate(250, 47, 47,
            40.498, "N", 20, 22,
            11.219, "E");
    RealEstate realEstate2 = new RealEstate(260, 47, 47,
            40.498, "S", 20, 22,
            11.219, "E");

    CalculationResultLog calculationResultLog = new CalculationResultLog(47, 46, 23.643,
            "E", 17, 21, 23.234, "W",
            230.4, 234561);

    private CalculateDistanceService calculateDistanceService = new CalculateDistanceService();

    @Test
    public void closestPointsMatchSuccess() {

        CalculationResultLog result = new CalculationResultLog(47, 46, 23.643,
                "E", 17, 21, 23.234, "W",
                230.4, 57600.0);
        realEstates.add(realEstate1);
        realEstates.add(realEstate2);

        double latitudeInput = calculationResultLog.getDoubleFromLatitude();
        double longitudeInput = calculationResultLog.getDoubleFromLongitude();

        RealEstate closestRealEstate = realEstates.get(0);
        double smallestDistance = calculateDistanceService.distanceCalculator(closestRealEstate, latitudeInput, longitudeInput);

        for (int i = 1; i < realEstates.size(); i++) {
            RealEstate currentRealEstate = realEstates.get(i);
            double distance = calculateDistanceService.distanceCalculator(currentRealEstate, latitudeInput, longitudeInput);
            if (distance < smallestDistance){
                smallestDistance = distance;
                closestRealEstate = currentRealEstate;
            }else if (distance == smallestDistance){
                if (currentRealEstate.getAverageSquareMeterPrice() < closestRealEstate.getAverageSquareMeterPrice()){
                    closestRealEstate = currentRealEstate;
                }
            }
        }
        double calculatedPrice = closestRealEstate.getAverageSquareMeterPrice() * calculationResultLog.getGivenSquareMeter();
        calculationResultLog.setCalculatedPrice(calculatedPrice);
        Assert.assertEquals(calculationResultLog, result);
    }
}