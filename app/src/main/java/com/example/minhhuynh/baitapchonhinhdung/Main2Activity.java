package com.example.minhhuynh.baitapchonhinhdung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Main2Activity extends AppCompatActivity {

    int sodong = 6;
    int socot  = 3;
    TableLayout tableLayout;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tableLayout = findViewById(R.id.tableLayout);
        count = 0;

        for (int i = 0; i < sodong; i++){
            TableRow tableRow = new TableRow(this);
            for (int j = 0; j < socot; j++){
                ImageView imageView = new ImageView(this);
                final int image = getResources().getIdentifier(MainActivity.manghinh.get(count++), "drawable", getPackageName());
                imageView.setImageResource(image);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("hinhchon", image);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
