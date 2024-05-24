package com.merp.my.book.shor.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.merp.my.book.shor.app.R;
import com.merp.my.book.shor.app.databinding.ActivityBookBuyBinding;
import com.merp.my.book.shor.app.databinding.ActivityHomeBinding;
import com.merp.my.book.shor.app.model.BookDetail;

public class BookBuyActivity extends BaseActivity {

    private ActivityBookBuyBinding binding;
    BookDetail bookDetail = new BookDetail();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookBuyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bookDetail =  helper.getBookById(preference.getInt("bookId",0));

        onInit();

        binding.imgBack.setOnClickListener(vi -> onBackPressed());
        binding.btnBuy.setOnClickListener(v ->{
            startActivity(new Intent(this, AddressActivity.class));
        });
    }

    private void onInit() {
        binding.txtName.setText(bookDetail.getBookName());
        binding.txtBookName.setText(bookDetail.getBookName());
        binding.txtAuthorName.setText(bookDetail.getAuthorName());
        binding.txtDescription.setText(bookDetail.getDescription());
        binding.txtContact.setText(bookDetail.getContact());
        binding.txtPrice.setText(bookDetail.getPrice());
        byte[] image = bookDetail.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        binding.bookImg.setImageBitmap(bitmap);
    }
}