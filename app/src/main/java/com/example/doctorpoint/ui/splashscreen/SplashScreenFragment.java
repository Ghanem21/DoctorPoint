package com.example.doctorpoint.ui.splashscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.doctorpoint.R;
import com.example.doctorpoint.databinding.FragmentSplashScreenBinding;


public class SplashScreenFragment extends Fragment {
    private FragmentSplashScreenBinding binding;
    private SplashScreenViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen,container,false);
        viewModel = new ViewModelProvider(this).get(SplashScreenViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getTimeOut().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean flag) {
                if(flag){
                    navigate();
                    viewModel.setTimeOut(false);
                }
            }
        });
    }

    private void navigate(){
        Navigation.findNavController(getView()).navigate(R.id.action_splashScreen_to_signInOrCreateAccount);
    }
}