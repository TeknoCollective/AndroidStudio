package com.example.s101.a872108_cw2;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewMeetings extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meetings);


        Button buttonMap = findViewById(R.id.button);


        buttonMap.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:

                Intent intent = new Intent (this, ViewLocations.class);
                startActivity(intent);

                Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();

                break;
        }

    }
}