package com.example.s101.a872108_cw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMeeting extends AppCompatActivity implements OnClickListener {

    String time;
    EditText userInput;
    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meeting);


        userInput = (EditText) findViewById(R.id.editText);

        dbHandler = new DBHandler(this, null, null, 1);

        printDatabase();

        Button saveButton = findViewById(R.id.button);
        Button clearButton = findViewById(R.id.button5);

        clearButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);


    }

    //Print the database
    public void printDatabase() {

        String dbString = dbHandler.databaseToString();
        userInput.setHint(dbString);
        Toast.makeText(this, dbString, Toast.LENGTH_SHORT).show();
        userInput.setText(dbString);
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {


            case R.id.button:

                Meetings product = new Meetings(userInput.getText().toString());
                dbHandler.addMeeting(product);
                printDatabase();

                break;

            case R.id.button5:

                String dbString = dbHandler.databaseToString();
                dbHandler.deleteMeeting(dbString);
                userInput.setHint(dbString);
                printDatabase();

                break;

        }
    }
}
