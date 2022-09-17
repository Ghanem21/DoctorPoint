package com.example.doctorpoint.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.doctorpoint.R;
import com.example.doctorpoint.databinding.FragmentSignInOrCreateAccountBinding;


public class SignInOrCreateAccountFragment extends Fragment {
    private FragmentSignInOrCreateAccountBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in_or_create_account, container, false);
        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate();
            }
        });
        binding.createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.action_signInOrCreateAccount_to_signUpFragment);
            }
        });
        return binding.getRoot();
    }
    private void navigate(){
        Navigation.findNavController(getView()).navigate(R.id.action_signInOrCreateAccount_to_signInFragment);
    }
}