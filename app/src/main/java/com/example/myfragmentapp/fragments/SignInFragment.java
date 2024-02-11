package com.example.myfragmentapp.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.navigation.Navigation;
import com.example.myfragmentapp.R;

public class SignInFragment extends Fragment {

    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        EditText editTextUsername = view.findViewById(R.id.editTextUsername);
        EditText editTextPassword = view.findViewById(R.id.editTextPassword);
        Button buttonLogin = view.findViewById(R.id.buttonLogin);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(v -> {
            //Navigate to the main fragment
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_mainFragment);
        });

        buttonRegister.setOnClickListener(v -> {
            // Navigate to the Register Fragment
            Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_registerFragment);
        });

        return view;
    }
}
