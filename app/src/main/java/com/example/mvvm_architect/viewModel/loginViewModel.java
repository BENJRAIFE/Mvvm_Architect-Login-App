package com.example.mvvm_architect.viewModel;

import android.util.Base64;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_architect.model.User;

public class loginViewModel extends ViewModel {
    private MutableLiveData<String> Email=new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();
    private MutableLiveData<User> userMutableLiveData;

    private String messageError="password or email invalid";
    private String messageSuccesProcess="Login succesful";
    private String toeastMsg=null;
    //getters setters
    public String getToeastMsg() {
        return toeastMsg;
    }
    public void setToeastMsg(String toeastMsg) {
        this.toeastMsg = toeastMsg;
    }
    public LiveData<User> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }

        return userMutableLiveData;
    }
    public void verify() {
        User loginUser = new User(Email.getValue(), Password.getValue());
        Email.postValue(Email.getValue());
        Password.postValue(Password.getValue());
        if (loginUser.isEmailValid() && loginUser.isPasswordLengthGreaterThan5()) {
            setToeastMsg(messageSuccesProcess);
            getToeastMsg();
        } else {
            setToeastMsg(messageError);
           getToeastMsg();
        }
        userMutableLiveData.setValue(loginUser);
    }

}
