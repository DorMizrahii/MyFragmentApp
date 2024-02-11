package com.example.myfragmentapp.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myfragmentapp.R;
import com.example.myfragmentapp.fragments.MainFragment;
import com.example.myfragmentapp.fragments.SignInFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (userIsLoggedIn()) {
            showMainFragment();
        } else {
            showSignInFragment();
        }
    }

    private boolean userIsLoggedIn() {
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        return prefs.getBoolean("isLoggedIn", false);
    }

    private void showSignInFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SignInFragment())
                .commit();
    }

    private void showMainFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new MainFragment())
                .commit();
    }
}
