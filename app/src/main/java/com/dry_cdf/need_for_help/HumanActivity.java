package com.dry_cdf.need_for_help;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HumanActivity extends AppCompatActivity {
    Button submitHumans_B;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_human);
        submitHumans_B = (Button) findViewById(R.id.button_submitAnimals);
        submitHumans_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFinalHuman();
            }
        });
    }
    public void startFinalHuman(){

        Intent intentfinal2 = new Intent(getApplicationContext(),FinalHumanActivity.class);
        startActivity(intentfinal2);
    }
}
