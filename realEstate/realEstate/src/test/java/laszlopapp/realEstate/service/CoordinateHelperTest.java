package laszlopapp.realEstate.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CoordinateHelperTest {

    private double delta = 99.9999;
    private int degree = 47;
    private int minute = 910;
    private double second = 19.12;
    private String compassPoint = "S";

    @Test
    public void decimalDegreeExchangerSuccessIfCompassPointSouthOrWest() {
        double decimalDegree = degree + minute / 60 + second / 3600;

        if (compassPoint.equals("S") || (compassPoint.equals("W"))){
            decimalDegree *= -1;
        }
        assertEquals(-62.00531111111111, decimalDegree, delta);
    }

    @Test
    public void decimalDegreeExchangerSuccessIfCompassPointNorthOrEast() {
        double decimalDegree = degree + minute / 60 + second / 3600;

        if (compassPoint.equals("S") || (compassPoint.equals("W"))){
            decimalDegree *= -1;
        }
        assertEquals(62.00531111111111, decimalDegree, delta);
    }

    @Test
    public void decimalDegreeExchangerFailureIfCompassPointNorthOrEast() {
        double decimalDegree = degree + minute / 60 + second / 3600;

        if (compassPoint.equals("S") || (compassPoint.equals("W"))){
            decimalDegree *= -1;
        }
        assertNotEquals(-62.00531111111111, decimalDegree, delta);
    }
}