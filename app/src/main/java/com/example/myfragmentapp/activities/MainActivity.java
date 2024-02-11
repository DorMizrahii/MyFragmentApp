package com.example.myfragmentapp.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myfragmentapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure you have an activity_main.xml layout file
    }
}
