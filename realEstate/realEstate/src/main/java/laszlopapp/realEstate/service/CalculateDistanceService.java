package laszlopapp.realEstate.service;
import laszlopapp.realEstate.model.CalculationResultLog;
import laszlopapp.realEstate.model.RealEstate;
import laszlopapp.realEstate.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("calculateDistanceService")
public class CalculateDistanceService {

    @Autowired
    @Resource(name = "realEstateRepository")
    private RealEstateRepository realEstateRepository;

    private double earthRadius = 6371000; //meter

    public double distanceCalculator(RealEstate realEstateFrom, double latitudeFromUser, double longitudeFromUser){
      double latitudeFromUserInRadian = Math.toRadians(latitudeFromUser);
      double latitudeFromInRadian = Math.toRadians((realEstateFrom.getDoubleFromLatitude()));
      double latitudeDifference = Math.toRadians(realEstateFrom.getDoubleFromLatitude() - latitudeFromUser);
      double longitudeDifference = Math.toRadians(realEstateFrom.getDoubleFromLongitude() - longitudeFromUser);

      double sinLatDiff = Math.sin(latitudeDifference / 2);
      double sinLongDiff = Math.sin(longitudeDifference / 2);

      double haversineA = Math.pow(sinLatDiff, 2) + Math.cos(latitudeFromUserInRadian) * Math.cos(latitudeFromInRadian)
                            * Math.pow(sinLongDiff, 2);

      double haversineC = 2 * Math.atan2(Math.sqrt(haversineA), Math.sqrt(1 - haversineA));

      return haversineC * earthRadius;
    }

    public CalculationResultLog closestPoints(CalculationResultLog calculationResultLog){

        double latitudeInput = calculationResultLog.getDoubleFromLatitude();
        double longitudeInput = calculationResultLog.getDoubleFromLongitude();

        RealEstate closestRealEstate = realEstateRepository.listAll().get(0);
        double smallestDistance = distanceCalculator(closestRealEstate, latitudeInput, longitudeInput);

        for (int i = 1; i < realEstateRepository.listAll().size(); i++) {
            RealEstate currentRealEstate = realEstateRepository.listAll().get(i);
            double distance = distanceCalculator(currentRealEstate, latitudeInput, longitudeInput);
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
        return calculationResultLog;
    }
}
