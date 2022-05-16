package com.example.assignment1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "usersdb";
    private static final String TABLE_Users = "patientTable";
    private static final String KEY_ID = "id";
    private static final String KEY_P_USERNAME = "P_Username";
    private static final String KEY_P_PASSWORD = "P_Password";
    private static final String KEY_P_FNAME = "P_FName";
    private static final String KEY_P_SURNAME = "P_Surname";
    private static final String KEY_P_ADDRESS = "P_Address";
    private static final String KEY_P_AGE = "P_Age";
    private static final String KEY_P_DOB = "P_DOB";
    private static final String KEY_P_GENDER = "P_Gender";
    private static final int KEY_P_PHONENUMBER = 0;
    private static final String KEY_P_ECONTACT = "P_EContact";
    private static final int KEY_P_ENUMBER = 5772167;


    int count;

    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION );
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
