package com.dry_cdf.need_for_help;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnimalActivity extends AppCompatActivity {
    Button submitAnimals_B,clickCam;
    String currentPhotopath;
    Uri temp;
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
    private File createFileforImage() throws IOException{
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String image_File_name = "JPEG_" + timestamp + "_";
        File storeDirectory =  getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image_taken = File.createTempFile(image_File_name,".jpg",storeDirectory);
        currentPhotopath = image_taken.getAbsolutePath();
        return image_taken;
    }
    public void clickPic(){
        Intent takePicture =  new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicture.resolveActivity(getPackageManager()) != null ) {
            File file_for_photo = null;
            try{
                file_for_photo = createFileforImage();
            }
            catch(IOException ex){
            }
            if(file_for_photo!= null){
                Uri photoUri = FileProvider.getUriForFile(this,"com.example.android.fileprovider",file_for_photo);
                temp = photoUri;
                takePicture.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                startActivityForResult(takePicture, 1);
            }

        }// storing the picture left..
    }
    public void startFinalAnimal(){
        Intent intentfinal = new Intent(getApplicationContext(),FinalActivity.class);
        intentfinal.setData(temp);
        startActivity(intentfinal);
    }
}
