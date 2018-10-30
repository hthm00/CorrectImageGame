package com.example.minhhuynh.baitapchonhinhdung;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    String[] hinhanhdongvat;
    static ArrayList<String> manghinh;
    String tenhinhgoc = "";
    ImageView imgHinhgoc, imageViewHinhChon;
    int requestCodeFromUser;
    int hinh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestCodeFromUser = 123;


        hinhanhdongvat = getResources().getStringArray(R.array.hinhitem);
        imgHinhgoc = findViewById(R.id.imageviewHinhgoc);
        imageViewHinhChon = findViewById(R.id.imageviewHinhchon);

        int image = getResources().getIdentifier("bo", "drawable",getPackageName());
        imgHinhgoc.setImageResource(image);

        manghinh = new ArrayList<>(Arrays.asList(hinhanhdongvat));
        Collections.shuffle(manghinh);
        tenhinhgoc = manghinh.get(0);

        hinh = getResources().getIdentifier(tenhinhgoc,"drawable",getPackageName());
        imgHinhgoc.setImageResource(hinh);

        imageViewHinhChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, requestCodeFromUser);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == requestCodeFromUser && data != null) {
            int hinhchon = data.getIntExtra("hinhchon", 0);
            if (hinhchon == hinh) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
