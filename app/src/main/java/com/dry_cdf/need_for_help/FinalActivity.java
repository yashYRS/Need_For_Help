package com.dry_cdf.need_for_help;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FinalActivity extends AppCompatActivity {
    Button mDialButton,mMailButton;
    Uri photoUri ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Intent t = getIntent();
        photoUri = t.getData();
        mDialButton = (Button) findViewById(R.id.button_Dialer);
        mMailButton = (Button) findViewById(R.id.button_Email);
        final EditText PhoneNoET = (EditText) findViewById(R.id.editText_selectedNo);
        final EditText EmailIdET = (EditText) findViewById(R.id.editText_selectedEmail);
        mDialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = PhoneNoET.getText().toString();
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(FinalActivity.this, "Select a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }
    public void sendMail(){
        Intent emailSelectIntent = new Intent(Intent.ACTION_SENDTO);
        emailSelectIntent.setData(Uri.parse("mailto:"));

        final Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"address@mail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        emailIntent.setSelector( emailSelectIntent );
        Uri attachment = photoUri;
        emailIntent.putExtra(Intent.EXTRA_STREAM, attachment);

        if( emailIntent.resolveActivity(getPackageManager()) != null )
            startActivity(emailIntent);
    }
}
