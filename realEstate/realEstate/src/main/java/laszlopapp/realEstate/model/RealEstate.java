package laszlopapp.realEstate.model;
import laszlopapp.realEstate.service.CoordinateHelper;

import javax.persistence.*;

@Entity
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int averageSquareMeterPrice;

    private int latitudeDegree;
    private int latitudeMinute;
    private double latitudeSecond;
    private String latitudeCompassPoint;

    private int longitudeDegree;
    private int longitudeMinute;
    private double longitudeSecond;
    private String longitudeCompassPoint;

    public RealEstate() {
    }

    public RealEstate(int averageSquareMeterPrice, int latitudeDegree, int latitudeMinute, double latitudeSecond,
                      String latitudeCompassPoint, int longitudeDegree, int longitudeMinute, double longitudeSecond,
                      String longitudeCompassPoint) {
        this.averageSquareMeterPrice = averageSquareMeterPrice;
        this.latitudeDegree = latitudeDegree;
        this.latitudeMinute = latitudeMinute;
        this.latitudeSecond = latitudeSecond;
        this.latitudeCompassPoint = latitudeCompassPoint;
        this.longitudeDegree = longitudeDegree;
        this.longitudeMinute = longitudeMinute;
        this.longitudeSecond = longitudeSecond;
        this.longitudeCompassPoint = longitudeCompassPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAverageSquareMeterPrice() {
        return averageSquareMeterPrice;
    }

    public void setAverageSquareMeterPrice(int averageSquareMeterPrice) {
        this.averageSquareMeterPrice = averageSquareMeterPrice;
    }

    public int getLatitudeDegree() {
        return latitudeDegree;
    }

    public void setLatitudeDegree(int latitudeDegree) {
        this.latitudeDegree = latitudeDegree;
    }

    public int getLatitudeMinute() {
        return latitudeMinute;
    }

    public void setLatitudeMinute(int latitudeMinute) {
        this.latitudeMinute = latitudeMinute;
    }

    public double getLatitudeSecond() {
        return latitudeSecond;
    }

    public void setLatitudeSecond(double latitudeSecond) {
        this.latitudeSecond = latitudeSecond;
    }

    public String getLatitudeCompassPoint() {
        return latitudeCompassPoint;
    }

    public void setLatitudeCompassPoint(String latitudeCompassPoint) {
        this.latitudeCompassPoint = latitudeCompassPoint;
    }

    public int getLongitudeDegree() {
        return longitudeDegree;
    }

    public void setLongitudeDegree(int longitudeDegree) {
        this.longitudeDegree = longitudeDegree;
    }

    public int getLongitudeMinute() {
        return longitudeMinute;
    }

    public void setLongitudeMinute(int longitudeMinute) {
        this.longitudeMinute = longitudeMinute;
    }

    public double getLongitudeSecond() {
        return longitudeSecond;
    }

    public void setLongitudeSecond(double longitudeSecond) {
        this.longitudeSecond = longitudeSecond;
    }

    public String getLongitudeCompassPoint() {
        return longitudeCompassPoint;
    }

    public void setLongitudeCompassPoint(String longitudeCompassPoint) {
        this.longitudeCompassPoint = longitudeCompassPoint;
    }

    public Double getDoubleFromLatitude(){
        return CoordinateHelper.decimalDegreeExchanger(this.latitudeDegree,
                this.latitudeMinute, this.latitudeSecond, this.latitudeCompassPoint);
    }

    public Double getDoubleFromLongitude(){
        return CoordinateHelper.decimalDegreeExchanger(this.longitudeDegree,
                this.longitudeMinute, this.longitudeSecond, this.longitudeCompassPoint);
    }
}
