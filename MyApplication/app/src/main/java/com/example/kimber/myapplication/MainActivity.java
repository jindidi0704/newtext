package com.example.kimber.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_ID = "id";
    private static final String KEY_AGE = "age";

    private static final String PREFERENCES_NAME = "mcu";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        // define shared preferences
        final SharedPreferences sharedPreferences =  getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        final int [] a = {1};
        a[0]=0;
        final EditText editName = (EditText) findViewById(R.id.editName);
        // get name data
        String name = sharedPreferences.getString("KEY_NAME" + a , "default value");
            editName.setText(name);



        Button buttonSend = (Button) findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // click event
                // shared preferences support type String int boolean float long String Set
                // saved name data
                sharedPreferences
                        .edit()
                                //key, value
                        .putString("KEY_NAME"+a, editName.getText().toString())
                        .apply();
            }
        });
    }
}