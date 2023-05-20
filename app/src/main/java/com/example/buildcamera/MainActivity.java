package com.example.buildcamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.provider.MediaStore;
import android.graphics.Bitmap;
public class MainActivity extends AppCompatActivity {

    Button open;
    ImageView img;

    private static final int CAMERA_REQ = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open = findViewById(R.id.open);
        img = findViewById(R.id.imgView);

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,CAMERA_REQ);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (resultCode == RESULT_OK){
            if (requestCode == CAMERA_REQ){

                Bitmap bitmap = (Bitmap) (data.getExtras().get("data"));
                img.setImageBitmap(bitmap);
            }
        }

    }
}