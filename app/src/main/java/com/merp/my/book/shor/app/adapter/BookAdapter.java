package com.merp.my.book.shor.app.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.merp.my.book.shor.app.databinding.ItemViewBookBinding;
import com.merp.my.book.shor.app.listener.BookItemClickListener;
import com.merp.my.book.shor.app.model.BookDetail;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private List<BookDetail> list;
    private BookItemClickListener listener;

    public BookAdapter(List<BookDetail> list, BookItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemViewBookBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BookDetail item = list.get(position);
        byte[] image = item.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        holder.binding.txtName.setText(item.getBookName());
        String price = item.getPrice() + "/-";
        holder.binding.txtPrice.setText(price);
        holder.binding.bookImg.setImageBitmap(bitmap);
        holder.binding.getRoot().setOnClickListener(v -> listener.onBookItemClick(item));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ItemViewBookBinding binding;

        public MyViewHolder(@NonNull ItemViewBookBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
