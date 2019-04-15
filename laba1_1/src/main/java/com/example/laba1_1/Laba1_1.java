package com.example.laba1_1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Laba1_1 extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    TextView mainTextView;
    Button mainbutton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laba1_1);

        mainTextView = findViewById(R.id.main_textview);
        mainTextView.setText("Welcome!");

        mainbutton = findViewById(R.id.main_button);
        mainbutton.setOnClickListener(this);


        mainEditText = findViewById(R.id.main_edittext);

        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);

        mainListView.setAdapter(mArrayAdapter);

        mainListView.setOnItemClickListener(this);
        mainListView.setOnItemLongClickListener(this);

    }


    @Override
    public void onClick(View v) {

        mainTextView.setText("You have added a name: " + mainEditText.getText().toString());
        name =mainEditText.getText().toString();
        if (mNameList.contains(name.toString()) != true)
        {
            mNameList.add(mainEditText.getText().toString());
            Log.e("q", name);
            Log.e("qqw", mNameList.get(0).toString());
            Collections.sort(mNameList);
        } else {}
        mArrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText("You have chosen a name: " + mNameList.get(position).toString());
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder builder=new AlertDialog.Builder(Laba1_1.this);
        builder.setTitle("ATTENTION!")
                .setMessage("Do you want to delete the name?")
                .setCancelable(false)
                .setPositiveButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })

                .setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                mNameList.remove(mNameList.get(position).toString());
                                mArrayAdapter.notifyDataSetChanged();
                            }
                        }


                );
        AlertDialog alert = builder.create();
        alert.show();

        return true;
    }
}