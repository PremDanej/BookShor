package com.merp.my.book.shor.app.ui;

import static com.merp.my.book.shor.app.utils.MyConstants.getByte;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

import com.merp.my.book.shor.app.R;
import com.merp.my.book.shor.app.databinding.ActivityLoginBinding;
import com.merp.my.book.shor.app.model.BookDetail;
import com.merp.my.book.shor.app.model.User;
import com.merp.my.book.shor.app.utils.MyConstants;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onInit();
        onPressLogin();
        onPressSignUp();

    }

    private void onInit() {
        if (preference.getInt("loginFirstTime", 0) == 0) {
            helper.InsertBooks(new BookDetail(MyConstants.NAME_1, MyConstants.AUTHOR_1, MyConstants.PRICE_1, MyConstants.DESC_1, MyConstants.CONTACT_1, MyConstants.getByte(getResources().getDrawable(R.drawable.book_night_school))));
            helper.InsertBooks(new BookDetail(MyConstants.NAME_2, MyConstants.AUTHOR_2, MyConstants.PRICE_2, MyConstants.DESC_2, MyConstants.CONTACT_2, MyConstants.getByte(getResources().getDrawable(R.drawable.book_insomania))));
            helper.InsertBooks(new BookDetail(MyConstants.NAME_3, MyConstants.AUTHOR_3, MyConstants.PRICE_3, MyConstants.DESC_3, MyConstants.CONTACT_3, MyConstants.getByte(getResources().getDrawable(R.drawable.book_harry_porter))));
            helper.InsertBooks(new BookDetail(MyConstants.NAME_4, MyConstants.AUTHOR_4, MyConstants.PRICE_4, MyConstants.DESC_4, MyConstants.CONTACT_4, MyConstants.getByte(getResources().getDrawable(R.drawable.book_kite_runner))));
            helper.InsertBooks(new BookDetail(MyConstants.NAME_5, MyConstants.AUTHOR_5, MyConstants.PRICE_5, MyConstants.DESC_5, MyConstants.CONTACT_5, MyConstants.getByte(getResources().getDrawable(R.drawable.book_money))));
            helper.InsertBooks(new BookDetail(MyConstants.NAME_6, MyConstants.AUTHOR_6, MyConstants.PRICE_6, MyConstants.DESC_6, MyConstants.CONTACT_6, MyConstants.getByte(getResources().getDrawable(R.drawable.book_yogi))));
            preference.setInt("loginFirstTime", 1);
        }
    }

    private void onPressSignUp() {
        binding.lblSignUp.setOnClickListener(view -> {
            startActivity(new Intent(this, SignUpActivity.class));
            finish();
        });
    }

    private void onPressLogin() {
        binding.btnLogin.setOnClickListener(view -> {
            String email = binding.txtEmail.getText().toString();
            String password = binding.txtPassword.getText().toString();
            User user = helper.LoginUser(email, password);
            if (user.getId() > 0) {
                preference.setString("email", email);
                preference.setString("password", password);
                preference.setString("firstName", user.getFirstName());
                preference.setString("lastName", user.getLastName());
                preference.setInt("isLogin", 1);
                startActivity(new Intent(this, OnBoardingActivity.class));
                finish();
            } else {
                Toast.makeText(this, "You are not Authorized", Toast.LENGTH_SHORT).show();
            }
        });
    }


}