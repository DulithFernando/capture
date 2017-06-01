package com.clayofficial.capture;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
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

    }
}
