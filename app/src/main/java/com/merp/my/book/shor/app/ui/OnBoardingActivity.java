package com.merp.my.book.shor.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.merp.my.book.shor.app.R;
import com.merp.my.book.shor.app.databinding.ActivityLoginBinding;
import com.merp.my.book.shor.app.databinding.ActivityOnBoardingBinding;

public class OnBoardingActivity extends BaseActivity {

    private ActivityOnBoardingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onInit();

        binding.btnBuy.setOnClickListener(view -> goToNextActivity(HomeActivity.class));
        binding.btnSkip.setOnClickListener(view -> goToNextActivity(HomeActivity.class));
        binding.btnSale.setOnClickListener(view -> goToNextActivity(BookSaleActivity.class));

    }

    private void goToNextActivity(Class activityClass) {
        startActivity(new Intent(this, activityClass));
        finish();
    }

    private void onInit() {
        String fullName = preference.getString("firstName", "") + " " + preference.getString("lastName", "");
        binding.lblName.setText(fullName);
    }
}