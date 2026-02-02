package com.example.tut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FromInchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_inch);

    }
    Convert123 convert = new Convert123();

    public String get_values(){
        //Gets inch and feet from the boxes
        String inch = ((EditText)findViewById(R.id.enter_inches)).getText().toString();
        inch = convert.check_string(inch);
        String feet = ((EditText)findViewById(R.id.enter_feet)).getText().toString();
        feet = convert.check_string(feet);

        //Truns the feet and inches to centimetres
        String cm_of_inch = convert.inch_to_cm(inch); //Takes string of inch returns resulting cm in string
        String cm_of_feet = convert.feet_to_cm(feet); //Takes string of feet returns resulting cm in string
        //Adds the cm of inch and feet
        String result = convert.add_two_strings(cm_of_feet, cm_of_inch);
        result = convert.cm_round(result);

        return result;
    }

    public void show_results(View v) {

        String end_cm = get_values();
        String end_m = convert.cm_to_m(end_cm);
        String end_km = convert.cm_to_km(end_cm);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(20);

        ((TextView)findViewById(R.id.result_in_cm)).setText(end_cm);
        ((TextView)findViewById(R.id.result_in_m)).setText(end_m);
        ((TextView)findViewById(R.id.result_in_km)).setText(end_km);
    }
}