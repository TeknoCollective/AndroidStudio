package com.example.s101.a872108_cw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.button2:

                Intent intent = new Intent (this, CreateMeeting.class);
                startActivity(intent);

                Toast.makeText(this, "Button 2 clicked", Toast.LENGTH_SHORT).show();

                break;

            case R.id.button3:

                Intent intent1 = new Intent (this, ViewMeetings.class);
                startActivity(intent1);

                Toast.makeText(this, "Button 3 clicked", Toast.LENGTH_SHORT).show();

                break;

            case R.id.button4:

                Intent intent2 = new Intent (this, ViewLocations.class);
                startActivity(intent2);

                Toast.makeText(this, "Button 4 clicked", Toast.LENGTH_SHORT).show();

                break;

    }
}
}