package vistula.oo.l11_ozen_58407_mid2;

public class ConverterToolsOO {

    public static double CtoF(double calcius){
        return calcius * 1.8 + 32;
    }

    public static double CtoK(double calcius){
        return  calcius + 273.15;
    }

    public static double FtoC(double fahrenheit){
        return (fahrenheit-32)/1.8;
    }

    public static double FtoK(double fahrenheit){
        return (fahrenheit+459.67)*5/9;
    }

    public static double KtoC(double kelvin){
        return kelvin-273.15;
    }
    public static double KtoF(double kelvin){
        return kelvin * 1.8 - 459.67;
    }

}
