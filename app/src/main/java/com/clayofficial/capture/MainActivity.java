package com.clayofficial.capture;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView register;
    private EditText email,pass;
    private ProgressDialog loader;
    private Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Casting
        register = (TextView)findViewById(R.id.reg_btn);
        email =(EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.pass);
        loginbtn=(Button)findViewById(R.id.signin_btn);

        //Progress Dialog
        loader=new ProgressDialog(this);
        loader.setMessage("Please Wait....");

        //Listeners
        loginbtn.setOnClickListener(this);
        register.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == register){
            Intent intent = new Intent(this,register.class);
            startActivity(intent);
        }
        if( v == loginbtn)
        {
           // Login();
        }
    }
}
