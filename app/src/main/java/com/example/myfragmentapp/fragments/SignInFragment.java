package com.example.myfragmentapp.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.myfragmentapp.R;
import com.example.myfragmentapp.activities.Users; // Ensure this is the correct path

public class SignInFragment extends Fragment {

    private Users userStorage;

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userStorage.putUser("dor","123");

        EditText editTextUsername = view.findViewById(R.id.editTextUsername);
        EditText editTextPassword = view.findViewById(R.id.editTextPassword);
        Button buttonLogin = view.findViewById(R.id.buttonLogin);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);

        NavController navController = Navigation.findNavController(view);

        // Assume User is a singleton or use some method to access the user data
        userStorage = new Users(); // Or however you plan to access/create this instance

        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            if (validateUser(username, password)) {
                //Navigate to the main fragment if user validation is successful
                navController.navigate(R.id.action_signInFragment_to_mainFragment);
            } else {
                // Show error message
                editTextUsername.setError("Invalid username or password");
                editTextPassword.setError("Invalid username or password");
            }
        });

        buttonRegister.setOnClickListener(v -> {
            // Navigate to the Register Fragment
            navController.navigate(R.id.action_signInFragment_to_registerFragment);
        });
    }

    public Boolean validateUser(String userName, String password) {
        // Check if the user exists and the password is correct
        return userStorage.userExists(userName) && userStorage.verifyUser(userName, password);
    }
}
