package com.example.doctorpoint.ui.signIn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.doctorpoint.R;
import com.example.doctorpoint.databinding.FragmentSignInBinding;


public class SignInFragment extends Fragment {
    FragmentSignInBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_in,container,false);
        binding.createAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).navigate(R.id.action_signInFragment_to_signUpFragment);
            }
        });
        return binding.getRoot();
    }
}