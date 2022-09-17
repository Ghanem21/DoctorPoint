package com.example.doctorpoint.ui.signup

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctorpoint.database.User
import com.example.doctorpoint.database.UserDB

class SignUpViewModel(private val database : UserDB, application:Application):AndroidViewModel(application) {

    val email = MutableLiveData<String>()

    val name = MutableLiveData<String>()

    val phone = MutableLiveData<String>()

    val password = MutableLiveData<String>()


    private val _navigateToSignIn = MutableLiveData<Boolean>()
    val navigateToSignIn: LiveData<Boolean> = _navigateToSignIn

    init {
        email.value = ""
        name.value = ""
        phone.value = ""
        password.value = ""

        _navigateToSignIn.value = false
    }


    fun doneNavigate() {
        _navigateToSignIn.value = false
    }

    fun navigateToSignIn() {
        _navigateToSignIn.value = true
    }

    private val _toast = MutableLiveData<Boolean>()
    val toast: LiveData<Boolean> = _toast

    fun doneToast() {
        _toast.value = false
    }

    fun insertUser(){
        val user = User(email.value,name.value,phone.value,password.value)
        val flag = database.insertUser(user)
        if(flag) {
            navigateToSignIn()
            _toast.value = true
        }
        else {
            doneNavigate()
            doneToast()
        }
    }


}