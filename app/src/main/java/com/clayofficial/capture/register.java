package com.clayofficial.capture;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class register extends AppCompatActivity implements View.OnClickListener {
    private TextView haveacc;
    private EditText mail,name,password,cpassword;
    private CheckBox terms;
    private Button reg_btn;
    private ProgressDialog loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Casting
        haveacc = (TextView)findViewById(R.id.haveaccount);
        mail=(EditText)findViewById(R.id.email);
        name=(EditText)findViewById(R.id.fullname);
        password=(EditText)findViewById(R.id.password);
        cpassword=(EditText)findViewById(R.id.cpassword);
        reg_btn=(Button)findViewById(R.id.register_btn);
        terms=(CheckBox)findViewById(R.id.terms);

        //Progress Dialog
        loader=new ProgressDialog(this);
        loader.setMessage("Registering User.....");

        //Listener
        haveacc.setOnClickListener(this);
        reg_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == haveacc){
            finish();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        if(v==reg_btn)
        {
          //  register();
        }
    }
}
