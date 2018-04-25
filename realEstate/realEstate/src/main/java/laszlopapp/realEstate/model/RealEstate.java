package laszlopapp.realEstate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    int averageSquareMeterPrice;
    double longitude;
    double latitude;

    public RealEstate() {
    }

    public RealEstate(Long id, int averageSquareMeterPrice, double longitude, double latitude) {
        this.id = id;
        this.averageSquareMeterPrice = averageSquareMeterPrice;
        this.longitude = longitude;
        this.latitude = latitude;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
