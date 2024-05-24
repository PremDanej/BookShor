package com.merp.my.book.shor.app.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.merp.my.book.shor.app.R;
import com.merp.my.book.shor.app.model.BookDetail;

import java.io.ByteArrayOutputStream;

public class MyConstants {
    public static final String NAME_1 = "Night School";
    public static final String NAME_2 = "Insomnia";
    public static final String NAME_3 = "Harry Potter And The Chamber Of Secrets";
    public static final String NAME_4 = "The Kite Runner";
    public static final String NAME_5 = "The Psychology Of Money";
    public static final String NAME_6 = "AUTOBIOGRAPHY OF A YOGI";

    public static final String AUTHOR_1 = "Lee Child";
    public static final String AUTHOR_2 = "Stephen King";
    public static final String AUTHOR_3 = "J.K. Rowling";
    public static final String AUTHOR_4 = "Khaled Hosseini";
    public static final String AUTHOR_5 = "Morgan Housel";
    public static final String AUTHOR_6 = "Paramahansa Yogananda";

    public static final String DESC_1 = "It’s just a voice plucked from the air: ‘The American wants a hundred million dollars’.For what? Who from? It’s 1996, and the Soviets are long gone. But now there’s a new enemy. In an apartment in Hamburg, a group of smartly-dressed young Saudis are planning something big.In the morning they gave Reacher a medal, and in the afternoon they sent him back to school.Jack Reacher is fresh off a secret mission.";
    public static final String DESC_2 = "Ralphs insomnia gets worse when Ed Deepneau gets out of control. Ed is obsessed with the notion that Derry is becoming the new Armageddon and that time is ticking away for the residents. An evil of imaginable proportions has began and Ralph has one chance to beat it.";
    public static final String DESC_3 = "There Is A Plot, Harry Potter. A Plot To Make Most Terrible Things Happen At Hogwarts School Of Witchcraft And Wizardry This Year. Harry Potters Summer Has Included The Worst Birthday Ever, Doomy Warnings From A House-elf Called Dobby, And Rescue From The Dursleys By His Friend Ron Weasley In A Magical Flying Car Back At Hogwarts School Of Witchcraft And Wizardry For Hi There Is A Plot, Harry Potter.";
    public static final String DESC_4 = "The Kite Runner Of Khaled Hosseinis Deeply Moving Fiction Debut Is An Illiterate Afghan Boy With An Uncanny Instinct For Predicting Exactly Where A Downed Kite Will Land. Growing Up In The City Of Kabul In The Early 1970s, Hassan Was Narrator Amirs Closest Friend ";
    public static final String DESC_5 = "Timeless Lessons On Wealth, Greed, And Happiness Doing Well With Money Isn’t Necessarily About What You Know. It’s About How You Behave. And Behavior Is Hard To Teach, Even To Really Smart People. How To Manage Money, Invest It, And Make Business Decisions Are Typically Considered To Involve A Lot Of Mathematical Calculations, Where Data And Formulae Tell Us Exactly What To Do.";
    public static final String DESC_6 = "Autobiography of a Yogi is one of the famous Spiritual Book of the Twentieth Century which is written by Paramahansa Yogananda. In this book he explained memorable findings of the world of saints and yogis and also explained science and miracles, death and resurgence.";

    public static final String PRICE_1 = "299";
    public static final String PRICE_2 = "180";
    public static final String PRICE_3 = "479";
    public static final String PRICE_4 = "210";
    public static final String PRICE_5 = "299";
    public static final String PRICE_6 = "279";

    public static final String CONTACT_1 = "7745299631";
    public static final String CONTACT_2 = "9952368510";
    public static final String CONTACT_3 = "4496635520";
    public static final String CONTACT_4 = "9873369870";
    public static final String CONTACT_5 = "4590135270";
    public static final String CONTACT_6 = "8896320772";


    public static byte[] getByte(Drawable d){
        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        return stream.toByteArray();
    }
}
