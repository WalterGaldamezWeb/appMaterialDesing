package com.waltergaldamezweb.appmaterialdesing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextPersonName;
    EditText editTextTextPersonName2;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);

        editTextTextPersonName.setFocusable(false);
        editTextTextPersonName.setEnabled(false);
        editTextTextPersonName.setCursorVisible(false);
        editTextTextPersonName.setKeyListener(null);

        editTextTextPersonName2.setFocusable(false);
        editTextTextPersonName2.setEnabled(false);
        editTextTextPersonName2.setCursorVisible(false);
        editTextTextPersonName2.setKeyListener(null);

        setToolBar();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RecyclerViewMascota.class);
                startActivity(intent);
            }
        });


    }
    public void setToolBar(){
        Toolbar appBar = findViewById(R.id.appBar);
        setSupportActionBar(appBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}