package com.riya.luckkynoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LucknoActivity extends AppCompatActivity {
    TextView txtview, lucknotxt;
    Button shareno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luckno);

        txtview = findViewById(R.id.lucknotxt);
        shareno = findViewById(R.id.shareno);
        txtview = findViewById(R.id.textView2);
        lucknotxt = findViewById(R.id.lucknotxt);

        Intent i = getIntent();
        String username = i.getStringExtra("name");

        //randon no generater
        int random_num = generateRandomNumber();
        lucknotxt.setText(""+random_num);

        shareno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedat(username,random_num);
            }
        });

    }


    public  int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNogenerate = random.nextInt(upper_limit);
        return  randomNogenerate;
    }


    public  void sharedat(String username,int randomNum){

      //impilcit intent
      Intent i = new Intent(Intent.ACTION_SEND);
      i.setType("text/plain");

      String no = String.valueOf(randomNum);

      i.putExtra(Intent.EXTRA_SUBJECT,username + "got Lucky today");
      i.putExtra(Intent.EXTRA_TEXT, "His Lucky No is" +no);

      startActivity(Intent.createChooser(i,"Choose a Platform"));
    }
}