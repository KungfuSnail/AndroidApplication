package com.example.tut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FromCmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_cm);
    }

    Convert123 convert123 = new Convert123();

    public String get_values() {
        //Gets all the three values and turns them into centimetre and returns
        //that value in string form

        String cm = ((EditText) findViewById(R.id.enter_centimetre)).getText().toString();
        String metre = ((EditText) findViewById(R.id.enter_metre)).getText().toString();
        String kilometre = ((EditText) findViewById(R.id.enter_kilometre)).getText().toString();

        //Makes sure the strings aren't empty
        cm = convert123.check_string(cm);
        metre = convert123.check_string(metre);
        kilometre = convert123.check_string(kilometre);

        //Adds the metre to cm
        String metre_now_cm = convert123.metre_to_cm(metre);
        cm = convert123.add_two_strings(cm, metre_now_cm);

        //Adds the kilometre to cm
        String kilometre_now_cm = convert123.kilometre_to_cm(kilometre);
        cm = convert123.add_two_strings(cm, kilometre_now_cm);

        return cm;
    }

    public void show_results(View btn) {

        String centiM = get_values();
        String final_feet = convert123.cm_to_feet(centiM);
        String final_inch = convert123.cm_to_inch(centiM);
        String[] values = convert123.cm_to_feet_and_inch(centiM);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(20);

        ((TextView) findViewById(R.id.feet_result)).setText(final_feet);
        ((TextView) findViewById(R.id.inches_result)).setText(final_inch);
        ((TextView) findViewById(R.id.feet_inch_result_feet)).setText(values[0] + "ft ");
        ((TextView) findViewById(R.id.feet_inch_result_inch)).setText(values[1] + "in");

    }
}

