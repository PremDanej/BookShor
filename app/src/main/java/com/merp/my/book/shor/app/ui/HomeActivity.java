package com.merp.my.book.shor.app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.merp.my.book.shor.app.R;
import com.merp.my.book.shor.app.adapter.BookAdapter;
import com.merp.my.book.shor.app.databinding.ActivityBookSaleBinding;
import com.merp.my.book.shor.app.databinding.ActivityHomeBinding;
import com.merp.my.book.shor.app.listener.BookItemClickListener;
import com.merp.my.book.shor.app.model.BookDetail;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements BookItemClickListener {

    private ActivityHomeBinding binding;
    private List<BookDetail> bookDetailList = new ArrayList<>();
    private BookAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bookDetailList.addAll(helper.GetAllBooks());

        onInit();

    }

    private void onInit() {
        adapter = new BookAdapter(bookDetailList, this);
        binding.bookRcv.setLayoutManager(new GridLayoutManager(this,2));
        binding.bookRcv.setAdapter(adapter);
    }

    @Override
    public void onBookItemClick(BookDetail book) {
        preference.setInt("bookId", book.getBookId());
        startActivity(new Intent(this, BookBuyActivity.class));
    }
}