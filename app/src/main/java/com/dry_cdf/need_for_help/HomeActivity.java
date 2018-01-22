package com.dry_cdf.need_for_help;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import junit.framework.Test;

public class HomeActivity extends AppCompatActivity {
    Button human_B,animal_B;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        human_B = (Button)findViewById(R.id.button_humans);
        animal_B = (Button)findViewById(R.id.button_animals);
        human_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHuman();
            }
        });
        animal_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimal();
            }
        });
    }
    public void startHuman(){

        Intent intentHuman = new Intent(getApplicationContext(),HumanActivity.class);
        startActivity(intentHuman);
    }
    public void startAnimal(){

        Intent intentAnimal = new Intent(getApplicationContext(),AnimalActivity.class);
        startActivity(intentAnimal);
    }
}//only design left

