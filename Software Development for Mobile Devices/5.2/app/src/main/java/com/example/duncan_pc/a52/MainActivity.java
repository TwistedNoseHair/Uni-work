package com.example.duncan_pc.a52;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import com.example.mack_.task52.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private MyParcelable[] items = {
            new MyParcelable(0,"name", "URL", "Keywords", "Date", "True", "Email", "1"),
            new MyParcelable(1,"name", "URL", "Keywords", "Date", "True", "Email", "2"),
            new MyParcelable(2,"name", "URL", "Keywords", "Date", "True", "Email", "3"),
            new MyParcelable(3, "name", "URL", "Keywords", "Date", "True", "Email", "4"),
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onClickChocolate(View view){
        createIntent(items[0]);
    }
    public void onClickChocolatePudding(View view){
        createIntent(items[1]);
    }
    public void onClickStickyDate(View view){
        createIntent(items[2]);
    }
    public void onClickTrifle(View view){
        createIntent(items[3]);
    }



    private void createIntent(MyParcelable data){
        Intent imageDetailIntent = new Intent(this, image_display.class);

        ArrayList<MyParcelable> ArrayData = new ArrayList<>();
        ArrayData.add(data);

        imageDetailIntent.putParcelableArrayListExtra("IMAGE_DATA", ArrayData);

        // Start Activity
        startActivityForResult(imageDetailIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                ArrayList<MyParcelable> food = data.getParcelableArrayListExtra("IMAGE_DATA");
                items[food.get(0).id] = food.get(0);
            }
        }
    }

}

