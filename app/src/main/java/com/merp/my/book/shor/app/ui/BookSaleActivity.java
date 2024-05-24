package com.merp.my.book.shor.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.merp.my.book.shor.app.R;
import com.merp.my.book.shor.app.databinding.ActivityBookSaleBinding;
import com.merp.my.book.shor.app.databinding.ActivityOnBoardingBinding;
import com.merp.my.book.shor.app.model.BookDetail;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookSaleActivity extends BaseActivity {

    private ActivityBookSaleBinding binding;
    private static int PICK_IMAGE = 123;
    private static final String TAG = "=================> ";
    private String bookName, bookAuthorName, bookPrice, bookDescription, bookContactDetails;
    Uri imagePath;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null) {
            imagePath = data.getData();
            Log.d(TAG, "IMAGE PATH -> " + imagePath.getPath());
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                binding.bookImg.setImageBitmap(bitmap);
            } catch (IOException e) {
                Log.e(TAG, "IMAGE PATH ERR -> " + e.getMessage());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookSaleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSale.setOnClickListener(v -> onBookSale());
        binding.bookImg.setOnClickListener(v -> onPickImage());

    }

    private void onPickImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image"), PICK_IMAGE);
    }

    private void onBookSale() {
        bookName = binding.txtBookName.getText().toString();
        bookAuthorName = binding.txtAuthorName.getText().toString();
        bookPrice = binding.txtPrice.getText().toString();
        bookDescription = binding.txtDescription.getText().toString();
        bookContactDetails = binding.txtContact.getText().toString();
        helper.InsertBooks(new BookDetail(bookName, bookAuthorName, bookPrice, bookDescription, bookContactDetails, imageViewToByte(binding.bookImg)));
        Toast.makeText(this, "Post Uploaded", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    private byte[] imageViewToByte(ImageView avatar) {
        Bitmap bitmap = ((BitmapDrawable) avatar.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
        return stream.toByteArray();
    }
}