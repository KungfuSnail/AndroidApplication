package com.example.tut;

import androidx.core.app.RemoteInput;

import java.math.BigDecimal;
import java.math.RoundingMode;




public class Convert123 {

    int ROUND_TO_X_DECIMALS = 6;

    public static String inch_to_cm(String inch) {
        Double inch_double = Double.parseDouble(inch);
        inch_double = inch_double * 2.54;
        return Double.toString(inch_double);
    }

    public static String feet_to_cm(String feet){
        Double feet_double = Double.parseDouble(feet);
        feet_double = feet_double * 30.48;
        return Double.toString(feet_double);
    }

    public String cm_round(String cm){
        Double cm_double = Double.parseDouble(cm);
        cm_double = round(cm_double, ROUND_TO_X_DECIMALS);
        String cm_string = Double.toString(cm_double);
        return cm_string;
    }

    public String cm_to_m(String cm){
        Double cm_double = Double.parseDouble(cm);
        Double meter_double = cm_double * 0.01;
        meter_double = round(meter_double, ROUND_TO_X_DECIMALS);
        String meter = Double.toString(meter_double);
        return meter;
    }

    public String cm_to_km(String cm){
        Double cm_double = Double.parseDouble(cm);
        Double kilometer_double = cm_double * 0.00001;
        kilometer_double = round(kilometer_double, ROUND_TO_X_DECIMALS);
        String kilometer = Double.toString(kilometer_double);
        return kilometer;
    }

    public String cm_to_feet(String cm){
        Double cm_double = Double.parseDouble(cm);
        Double feet_double = cm_double * 0.0328084;
        feet_double = round(feet_double, ROUND_TO_X_DECIMALS);
        return Double.toString(feet_double);
    }

    public String cm_to_inch(String cm){
        Double cm_double = Double.parseDouble(cm);
        Double inch_double = cm_double * 0.3937007874;
        inch_double = round(inch_double, ROUND_TO_X_DECIMALS);
        return Double.toString(inch_double);
    }

    public String[] cm_to_feet_and_inch(String cm){
        Double cm_double = Double.parseDouble(cm);
        //Turns cm to inch
        Double inch_double = cm_double * 0.3937007874;
        //Turns the inches to feel
        Double feet_double = inch_double / 12;
        //Gets the left over value that didn't add up to a foot and turns it into final int
        inch_double = (feet_double % 1) * 12;
        //Gets rid of the decimals of feet because they are inches now
        feet_double = feet_double - feet_double % 1;
        //Turns them both into strings
        //Turns the feet into int first to get rid of .0
        int feet_int = (int)Math.round(feet_double);
        String feet_string = Integer.toString(feet_int);

        String inch_string = Double.toString(round(inch_double, ROUND_TO_X_DECIMALS));
        //Returns
        String[] result = {feet_string, inch_string};
        return result;
    }


    public static String add_two_strings(String first, String second){
        Double first_double = Double.parseDouble(first);
        Double second_double = Double.parseDouble(second);
        return Double.toString(first_double + second_double);
    }

    public static String metre_to_cm(String metre){
        Double metre_double = Double.parseDouble(metre);
        metre_double = metre_double * 100;
        return Double.toString(metre_double);
    }

    public static String kilometre_to_cm(String kilometre){
        Double kilometre_double = Double.parseDouble(kilometre);
        kilometre_double = kilometre_double * 100000;
        return Double.toString(kilometre_double);
    }

    public static String check_string(String value){
        if(value.equals("")){
            return "0";
        }
        return value;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
