package com.merp.my.book.shor.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {
    private static SharedPreferences preferences = null;
    private static SharedPreferences.Editor editor;

    public MySharedPreference(Context context) {
        if (preferences == null) {
            preferences = context.getSharedPreferences("BookPreference", Context.MODE_PRIVATE);
            editor = preferences.edit();
        }
    }

    public void setInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    public void setString(String key, String value){
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

}
