package com.dry_cdf.need_for_help;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button b_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b_signin = (Button) findViewById(R.id.button_signin);
        b_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHome();
            }
        });
    }
    public void startHome(){

        Intent intenthome = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intenthome);
    }
}
