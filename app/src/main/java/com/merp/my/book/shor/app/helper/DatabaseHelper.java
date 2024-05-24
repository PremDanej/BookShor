package com.merp.my.book.shor.app.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.merp.my.book.shor.app.model.BookDetail;
import com.merp.my.book.shor.app.model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

//    ================= Database =================

    private static final String TAG = "===========> DB ";
    private static final String DATABASE = "BookShorDb";
    private static final String USER_TABLE = "User";
    private static final String BOOK_TABLE = "BookDetail";

//    =================== User Fields =====================

    private static final String USER_ID = "userId";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";

//    =================== Book Fields =====================

    private static final String BOOK_ID = "bookId";
    private static final String BOOK_NAME = "bookName";
    private static final String AUTHOR_NAME = "authorName";
    private static final String BOOK_PRICE = "price";
    private static final String BOOK_DESC = "description";
    private static final String BOOK_CONTACT = "contact";
    private static final String BOOK_IMAGE = "image";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        ============== User Table Create Query =============

        db.execSQL("CREATE TABLE IF NOT EXISTS " + USER_TABLE + "(" +
                USER_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                FIRST_NAME + " TEXT NOT NULL," +
                LAST_NAME + " TEXT NOT NULL," +
                EMAIL + " TEXT NOT NULL," +
                PASSWORD + " TEXT NOT NULL)");

//        ============== Book Table Create Query =============

        db.execSQL("CREATE TABLE IF NOT EXISTS " + BOOK_TABLE + "(" +
                BOOK_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                BOOK_NAME + " TEXT NOT NULL," +
                AUTHOR_NAME + " TEXT NOT NULL," +
                BOOK_PRICE + " TEXT NOT NULL," +
                BOOK_DESC + " TEXT NOT NULL," +
                BOOK_CONTACT + " TEXT NOT NULL," +
                BOOK_IMAGE + " BLOB NOT NULL)");

        Log.d(TAG, "All Tables Created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BOOK_TABLE);
    }


    //    ==================== CRUD OPERATION ====================

    public void InsertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FIRST_NAME, user.getFirstName());
        cv.put(LAST_NAME, user.getLastName());
        cv.put(EMAIL, user.getEmail());
        cv.put(PASSWORD, user.getPassword());

        db.insert(USER_TABLE, null, cv);
    }


    @SuppressLint("Range")
    public User LoginUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE " + EMAIL + " = ? AND " + PASSWORD + " = ?", new String[]{email, password});
        User user = new User();
        if (cr.getCount() > 0) {
            cr.moveToFirst();
            user.setId(cr.getInt(cr.getColumnIndex(USER_ID)));
            user.setFirstName(cr.getString(cr.getColumnIndex(FIRST_NAME)));
            user.setLastName(cr.getString(cr.getColumnIndex(LAST_NAME)));
            user.setEmail(cr.getString(cr.getColumnIndex(EMAIL)));
            user.setPassword(cr.getString(cr.getColumnIndex(PASSWORD)));
        } else {
            user.setId(0);
        }
        cr.close();
        db.close();
        return user;
    }

    public void InsertBooks(BookDetail book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(BOOK_NAME, book.getBookName());
        cv.put(AUTHOR_NAME, book.getAuthorName());
        cv.put(BOOK_PRICE, book.getPrice());
        cv.put(BOOK_DESC, book.getDescription());
        cv.put(BOOK_CONTACT, book.getContact());
        cv.put(BOOK_IMAGE, book.getImage());
        db.insert(BOOK_TABLE, null, cv);
    }

    @SuppressLint("Range")
    public List<BookDetail> GetAllBooks() {
        SQLiteDatabase db = this.getWritableDatabase();
        List<BookDetail> bookList = new ArrayList<>();
        Cursor cr = db.rawQuery("SELECT * FROM " + BOOK_TABLE, null);

        if (cr.moveToFirst()) {
            do {
                BookDetail book = new BookDetail();
                book.setBookId(cr.getInt(cr.getColumnIndex(BOOK_ID)));
                book.setBookName(cr.getString(cr.getColumnIndex(BOOK_NAME)));
                book.setAuthorName(cr.getString(cr.getColumnIndex(AUTHOR_NAME)));
                book.setPrice(cr.getString(cr.getColumnIndex(BOOK_PRICE)));
                book.setDescription(cr.getString(cr.getColumnIndex(BOOK_DESC)));
                book.setContact(cr.getString(cr.getColumnIndex(BOOK_CONTACT)));
                book.setImage(cr.getBlob(cr.getColumnIndex(BOOK_IMAGE)));
                bookList.add(book);
            } while (cr.moveToNext());
        }
        db.close();
        cr.close();
        return bookList;
    }

    @SuppressLint("Range")
    public BookDetail getBookById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM " + BOOK_TABLE + " WHERE " + BOOK_ID + " = ? ", new String[]{String.valueOf(id)});
        BookDetail user = new BookDetail();
        if (cr.getCount() > 0) {
            cr.moveToFirst();
            user.setBookId(cr.getInt(cr.getColumnIndex(BOOK_ID)));
            user.setBookName(cr.getString(cr.getColumnIndex(BOOK_NAME)));
            user.setAuthorName(cr.getString(cr.getColumnIndex(AUTHOR_NAME)));
            user.setPrice(cr.getString(cr.getColumnIndex(BOOK_PRICE)));
            user.setDescription(cr.getString(cr.getColumnIndex(BOOK_DESC)));
            user.setContact(cr.getString(cr.getColumnIndex(BOOK_CONTACT)));
            user.setImage(cr.getBlob(cr.getColumnIndex(BOOK_IMAGE)));
        } else {
            user.setBookId(0);
        }
        cr.close();
        db.close();
        return user;
    }

}
