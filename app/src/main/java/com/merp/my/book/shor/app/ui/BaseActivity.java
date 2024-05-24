package com.merp.my.book.shor.app.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.merp.my.book.shor.app.helper.DatabaseHelper;
import com.merp.my.book.shor.app.utils.MySharedPreference;

public class BaseActivity extends AppCompatActivity {
    public MySharedPreference preference;
    public DatabaseHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preference = new MySharedPreference(this);
        helper = new DatabaseHelper(this);
    }
}
