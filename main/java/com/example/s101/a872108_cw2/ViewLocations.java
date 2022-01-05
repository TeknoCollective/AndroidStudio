package com.example.s101.a872108_cw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

public class ViewLocations extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_locations);


        Button button9 = findViewById(R.id.button9);


        button9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button9:

                Intent intent = new Intent (this, ViewMeetings.class);
                startActivity(intent);

                Toast.makeText(this, "Button 9 clicked", Toast.LENGTH_SHORT).show();

                break;

    }
}
}
