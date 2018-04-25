package laszlopapp.realEstate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    double calculatedCoordinate;
    int squareMeter;
    int calculatedPrice;

    public Calculation() {
    }

    public Calculation(Long id, double calculatedCoordinate, int squareMeter, int calculatedPrice) {
        this.id = id;
        this.calculatedCoordinate = calculatedCoordinate;
        this.squareMeter = squareMeter;
        this.calculatedPrice = calculatedPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCalculatedCoordinate() {
        return calculatedCoordinate;
    }

    public void setCalculatedCoordinate(double calculatedCoordinate) {
        this.calculatedCoordinate = calculatedCoordinate;
    }

    public int getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(int squareMeter) {
        this.squareMeter = squareMeter;
    }

    public int getCalculatedPrice() {
        return calculatedPrice;
    }

    public void setCalculatedPrice(int calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }
}
