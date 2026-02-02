package com.example.tut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.linkText);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public void cmToInch(View btn) {
        Intent intent = new Intent(this, FromInchActivity.class);
        //((TextView)findViewById(R.id.)
        startActivity(intent);
    }

    public void inchToCm(View btn2) {
        Intent intent = new Intent(this, FromCmActivity.class);
        startActivity(intent);
    }

    /*public void settings(View btn3){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }*/
}