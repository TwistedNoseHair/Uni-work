package com.example.duncan_pc.a52;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mack_.task52.R;

import java.util.ArrayList;

public class image_display extends Activity {

    private MyParcelable data;
    private EditText Keywords;
    private EditText Date;
    private EditText Email;
    private EditText Rating;
    private EditText Share;
    private EditText URL;
    private EditText Names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);
        initialiseUI();
    }

    void initialiseUI(){
        Intent intent = getIntent();
        ArrayList<MyParcelable> intentArray = intent.getParcelableArrayListExtra("IMAGE_DATA");
        data = intentArray.get(0);

        Date = findViewById(R.id.Date);
        Email = findViewById(R.id.Email);
        Keywords = findViewById(R.id.Keywords);
        Names = findViewById(R.id.Name);
        Rating = findViewById(R.id.Rating);
        Share = findViewById(R.id.Share);
        URL = findViewById(R.id.URL);

        Names.setText(data.Name);
        Date.setText(data.Date);
        Email.setText(data.Email);
        Keywords.setText(data.Keywords);
        Rating.setText(data.Rating);
        Share.setText(data.Share);
        URL.setText(data.URL);
    }

    public void finishActivity(View view)
    {

            data.Name = Names.getText().toString();
            data.URL = URL.getText().toString();
            data.Keywords = Keywords.getText().toString();
            data.Date = Date.getText().toString();
            data.Share = Share.getText().toString();
            data.Email = Email.getText().toString();
            data.Rating = Rating.getText().toString();
        if(data.Email.trim().length() > 0) {
            if(Integer.parseInt(data.Rating) >= 1 && Integer.parseInt(data.Rating) <= 5) {
                Intent intent = new Intent();
                ArrayList<MyParcelable> Parcabledata = new ArrayList<>();
                Parcabledata.add(data);
                intent.putParcelableArrayListExtra("IMAGE_DATA", Parcabledata);

                setResult(RESULT_OK, intent);
                finish();
            }else{
                Toast.makeText(this, "Enter a Rating between 1 and 5", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "You did not enter a Email", Toast.LENGTH_SHORT).show();
        }
    }


}
