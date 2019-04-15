package com.example.calc;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class calc extends AppCompatActivity implements View.OnClickListener {

    EditText et_1;
    EditText et_2;

    Button btn_plus;
    Button btn_minus;
    Button btn_ymnoj;
    Button btn_delenie;
    Button btn_info;


    TextView tv_znak;
    TextView tv_result;

    String oper="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);



        et_1=findViewById(R.id.et_1);
        et_2=findViewById(R.id.et_2);

        btn_minus=findViewById(R.id.btn_minus);
        btn_plus=findViewById(R.id.btn_plus);
        btn_ymnoj=findViewById(R.id.btn_ymnoj);
        btn_delenie=findViewById(R.id.btn_delenie);
        btn_info=findViewById(R.id.btn_info);

        tv_result=findViewById(R.id.tv_result);
        tv_znak=findViewById(R.id.tv_znak);

        btn_info.setText("Information");

        btn_delenie.setOnClickListener(this);
        btn_ymnoj.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_info.setOnClickListener(this);
    }



    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        float num1;
        float num2;
        float result=0;

        switch (v.getId()){
            case R.id.btn_info:
                AlertDialog.Builder builder=new AlertDialog.Builder(calc.this);
                builder.setTitle("Information")
                        .setCancelable(false)
                        .setMessage("You must first enter the numbers, and then the sign. After that, a solution will appear." +
                                "If you change the sign, the cutting will also change.")
                        .setNegativeButton("Лучше сам решу",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
        }

        if((TextUtils.isEmpty(et_1.getText().toString())) |
                (TextUtils.isEmpty(et_2.getText().toString())))
        { return; }


        num1=Float.parseFloat(et_1.getText().toString());
        num2=Float.parseFloat(et_2.getText().toString());

        switch (v.getId()){
            case R.id.btn_plus:
                oper="+";
                result=num1+num2;
                break;
            case R.id.btn_minus:
                oper="-";
                result=num1-num2;
                break;
            case R.id.btn_ymnoj:
                oper="*";
                result=num1*num2;
                break;

            case R.id.btn_delenie:
                oper="/";
                result=num1/num2;
                break;


            default:
                break;
        }

        tv_znak.setText(oper);
        if ((oper.equals("/")) & (num2==0)){
            tv_result.setText("Division by 0 is prohibited!");
        }
        else
            tv_result.setText(num1+" "+oper+" "+num2+" = "+result);
    }



}