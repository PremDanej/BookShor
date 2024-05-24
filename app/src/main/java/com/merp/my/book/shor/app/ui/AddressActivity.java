package com.merp.my.book.shor.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.merp.my.book.shor.app.R;
import com.merp.my.book.shor.app.databinding.ActivityAddressBinding;
import com.merp.my.book.shor.app.databinding.ActivityBookBuyBinding;

public class AddressActivity extends AppCompatActivity {

    private ActivityAddressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgBack.setOnClickListener(vi -> onBackPressed());

        binding.btnBuy.setOnClickListener(v ->{
            Toast.makeText(this, "Order Success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomeActivity.class));
            finishAffinity();
        });
    }
}