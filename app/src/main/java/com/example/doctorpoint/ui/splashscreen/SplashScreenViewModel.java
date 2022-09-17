package com.example.doctorpoint.ui.splashscreen;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class SplashScreenViewModel extends ViewModel {
    private MutableLiveData<Boolean> timeOut = new MutableLiveData<Boolean>();
    public SplashScreenViewModel(){
        timeOut.postValue(false);
        runTimer();
    }
    public MutableLiveData<Boolean> getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Boolean timeOut) {
        this.timeOut.postValue(timeOut);
    }

    private void runTimer(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                timeOut.postValue(true);
            }
        },3000);

    }
}
