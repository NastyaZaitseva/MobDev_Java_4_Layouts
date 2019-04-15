package com.example.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public  class Counter extends AppCompatActivity implements View.OnClickListener {
    TextView mainTextView;
    Button btn1;
    Button btn_minus;
    Button btn_null;
    int count = 0;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        btn1 = findViewById(R.id.btn);
        btn1.setOnClickListener(this);

        btn_minus =findViewById(R.id.btn_minus);
        btn_minus.setOnClickListener(this);

        btn_null =findViewById(R.id.btn_null);
        btn_null.setOnClickListener(this);

        mainTextView = findViewById(R.id.main_textview);

        imageButton=findViewById(R.id.imageButton);

           imageButton.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     imageButton.setImageResource(R.drawable.robot2);}});
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                mainTextView.setText(String.valueOf(++count));
                break;

            case R.id.btn_minus:  if (count>0){
                mainTextView.setText(String.valueOf(--count));
                break;}

            case R.id.btn_null:  mainTextView.setText(String.valueOf(count=0));
                break; } }
    }

