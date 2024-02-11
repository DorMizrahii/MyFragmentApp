package com.example.myfragmentapp.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfragmentapp.R;

public class RegisterFragment extends Fragment {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextPhone;
    private Button buttonSubmit;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        editTextUsername = view.findViewById(R.id.editTextRegisterUsername);
        editTextPassword = view.findViewById(R.id.editTextRegisterPassword);
        editTextPhone = view.findViewById(R.id.editTextRegisterPhone);
        buttonSubmit = view.findViewById(R.id.buttonSubmitRegister);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Registration successful!", Toast.LENGTH_SHORT).show();

                 Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_mainFragment);
            }
        });

        return view;
    }
}
