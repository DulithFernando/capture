package com.clayofficial.capture;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class profile extends AppCompatActivity implements View.OnClickListener {
    private TextView name, email, id, loc;
    private ImageView camera, logout;
    private Button getLocation, checkmem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Casting
        id = (TextView) findViewById(R.id.userid);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        loc = (TextView) findViewById(R.id.location);
        camera = (ImageView) findViewById(R.id.camera);
        logout = (ImageView) findViewById(R.id.logout);
        checkmem = (Button) findViewById(R.id.check);
        getLocation = (Button) findViewById(R.id.get_loc);

        //Listener
        camera.setOnClickListener(this);
        logout.setOnClickListener(this);
        checkmem.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == logout) {
            Shared.getInstance(this).logOut();
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        if (v == checkmem) {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivity(gallery);
        }
    }
}
