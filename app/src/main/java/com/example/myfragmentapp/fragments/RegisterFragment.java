package com.example.myfragmentapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myfragmentapp.R;

import java.util.Objects;

public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editTextUsername = view.findViewById(R.id.editTextRegisterUsername);
        EditText editTextPassword = view.findViewById(R.id.editTextRegisterPassword);
        EditText editTextPhone = view.findViewById(R.id.editTextRegisterPhone);
        Button buttonSubmit = view.findViewById(R.id.buttonSubmitRegister);

        buttonSubmit.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();
            String phone = editTextPhone.getText().toString();

            if (username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save the user registration details
            saveUserDetails(username, password);

            Toast.makeText(getContext(), "Registration successful!", Toast.LENGTH_SHORT).show();

            // Navigate to the main fragment after successful registration
            Navigation.findNavController(v).navigate(R.id.action_registerFragment_to_mainFragment);
        });
    }

    private void saveUserDetails(String username, String password) {
        SharedPreferences sharedPref = requireActivity().getSharedPreferences("AppUserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        // Example of hashing a password, not secure but better than plain text
        String hashedPassword = hashPassword(password);
        editor.putString("user_" + username, hashedPassword); // Prefix to avoid key collisions
        editor.apply();
    }

    private String hashPassword(String password) {
        // Placeholder for a hashing function, consider using SHA-256 or better with a salt
        // In real applications, use proper cryptographic methods and store salts securely
        return password; // Do not use this in production!
    }
}
