package methods;

public class Converter {

    public double converterCtoF(double celsius) {
        double fahrenheit = (celsius * (double) 9 / 5) + 32;
        return fahrenheit;
    }

    public double convertFtoC(double fahrenheit ) {
        double celsius = (fahrenheit - 32) * (double) 5 / 9;
        return celsius;
    }

    public double convertKgToLbs (double kilos) {
        double lbs = kilos * 2.20462;
        return lbs;
    }

    public double convertMileToKm (double miles) {
        double km = 1.60934 * miles;
        return km;
    }
}
