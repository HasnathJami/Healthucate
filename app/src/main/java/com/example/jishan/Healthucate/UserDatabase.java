package com.example.jishan.progressbar;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class UserDatabase extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "userdata.db";
    private static String TABLE_NAME = "user_Info";
    private static int TABLE_VERSION = 1;
    private static String COL_1 = "_id";
    private static String COL_2 = "Name";
    private static String COL_3 = "Username";
    private static String COL_4 = "Email";
    private static String COL_5 = "Password";
    private static String CREATE_TABLE_COMMAND = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " VARCHAR(255)," + COL_3 + " VARCHAR(255)," + COL_4 + " VARCHAR(255)," + COL_5 + " VARCHAR(255)";
    private static String DROP_TABLE_COMMAND = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private Context context;

    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null, TABLE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_COMMAND + ");");
            Toast.makeText(context, "Table created", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context, "Failed to create table due to:" + e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_COMMAND + " ;");
        onCreate(db);
        Toast.makeText(context, "onUpgrade method is called", Toast.LENGTH_LONG).show();
    }

    public long insertInDatabase(DataUser userData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, userData.getName());
        contentValues.put(COL_3, userData.getUsername());
        contentValues.put(COL_4, userData.getEmail());
        contentValues.put(COL_5, userData.getPassword());

        return db.insert(TABLE_NAME, null, contentValues);
    }

    public Boolean check(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        Boolean res = false;

        if (cursor.getCount() == 0)
            Toast.makeText(context, "No data found", Toast.LENGTH_LONG).show();
        else {
            while (cursor.moveToNext()) {
                String cursorUsername = cursor.getString(2);//indexing is 0 based in table
                String cursorPassword = cursor.getString(4);

                if (cursorUsername.equals(username) && cursorPassword.equals(password)) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
}
