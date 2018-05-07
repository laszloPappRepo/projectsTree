package laszlopapp.realEstate.service;

public class CoordinateHelper {

    public static Double decimalDegreeExchanger(int degree, int minute, double second, String compassPoint){
        double decimalDegree = degree + minute / 60 + second / 3600;

        if (compassPoint.equals("S") || (compassPoint.equals("W"))){
            decimalDegree *= -1;
        }
        return decimalDegree;
    }

}
