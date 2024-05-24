package com.merp.my.book.shor.app.ui;

import android.content.Intent;
import android.os.Bundle;

import com.merp.my.book.shor.app.databinding.ActivitySignUpBinding;
import com.merp.my.book.shor.app.model.User;

public class SignUpActivity extends BaseActivity {

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        onPressLogin();
        onPressSignUp();
    }

    // TODO if SignUp successfully then go to LoginScreen
    private void onPressSignUp() {
        binding.btnSignUp.setOnClickListener(view ->{
            String firstName = binding.txtFirstName.getText().toString();
            String lastName = binding.txtLastName.getText().toString();
            String email = binding.txtEmail.getText().toString();
            String password = binding.txtPassword.getText().toString();
            helper.InsertUser(new User(firstName,lastName,email,password));
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }

    private void onPressLogin() {
        binding.lblLogin.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}