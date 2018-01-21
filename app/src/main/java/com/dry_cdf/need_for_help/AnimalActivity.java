package com.dry_cdf.need_for_help;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnimalActivity extends AppCompatActivity {
    Button submitAnimals_B,clickCam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        submitAnimals_B = (Button) findViewById(R.id.button_submitAnimals);
        clickCam = (Button) findViewById(R.id.button_openCamforAnimal);
        submitAnimals_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFinalAnimal();
            }
        });
        clickCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickPic();
            }
        });
    }
    public void clickPic(){
        
    }
    public void startFinalAnimal(){
        Intent intentfinal = new Intent(getApplicationContext(),FinalActivity.class);
        startActivity(intentfinal);
    }
}
