package com.waltergaldamezweb.appmaterialdesing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_activity);
        setToolBar();
        final Button send = (Button) this.findViewById(R.id.button1);

        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.i("SendMailActivity", "Send Button Clicked.");

                /*String fromEmail = ((TextView) findViewById(R.id.editText1))
                        .getText().toString();*/
                String fromEmail = "Coloca tu email smtp";
                /*String fromPassword = ((TextView) findViewById(R.id.editText2))
                        .getText().toString();*/
                String fromPassword = "Coloca tu contraseña email smtp";
                /*String toEmails = ((TextView) findViewById(R.id.editText3))
                        .getText().toString();*/
                String toEmails = "Coloca el Email donde recibiras los mensajes";

                String email = ((TextView) findViewById(R.id.editTextEmail))
                        .getText().toString();
                List<String> toEmailList = Arrays.asList(toEmails
                        .split("\\s*,\\s*"));
                List<String> emailList = Arrays.asList(email
                        .split("\\s*,\\s*"));
                Log.i("SendMailActivity", "To List: " + toEmailList);
                String emailSubject = ((TextView) findViewById(R.id.editText4))
                        .getText().toString();
                String emailBody = ((TextView) findViewById(R.id.editText5))
                        .getText().toString();
                new SendMailTask(Contacto.this).execute(fromEmail,
                        fromPassword, toEmailList, emailSubject, emailBody+emailList);
            }
        });
    }

    public void setToolBar(){
        Toolbar appBar = findViewById(R.id.appBar);
        setSupportActionBar(appBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}