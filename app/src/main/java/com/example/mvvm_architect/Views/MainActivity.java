package com.example.mvvm_architect.Views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm_architect.R;
import com.example.mvvm_architect.model.User;
import com.example.mvvm_architect.viewModel.loginViewModel;

public class MainActivity extends AppCompatActivity {
private loginViewModel loginViewM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginViewM.getUser().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                User user = (User) o;
                if (user != null)
                    if (user.getEmail().length() > 0 || user.getPassword().length() > 0)
                Toast.makeText(getApplicationContext(), loginViewM.getToeastMsg(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}