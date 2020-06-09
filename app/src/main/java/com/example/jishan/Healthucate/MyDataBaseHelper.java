package com.example.jishan.progressbar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="dietplan.db";
    private static final String TABLE_NAME="dietplan_details";
    private static final String ID="_id";
    private static final String DATE="date";
    private static final String TIME="time";
    private static final String PLAN="dietplan";

    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"(" +ID+" INTEGER PRIMARY KEY ,"+DATE+" VARCHAR(255),"+TIME+" INTEGER,"+PLAN+" VARCHAR(15)); ";
    private static final String  DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;

    private static final String Select_ALL= "SELECT * FROM " +TABLE_NAME;
    private Context context;



    private static final int VERSION_NUMBER=3;

    public MyDataBaseHelper(Context context) {

        super(context,DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Toast.makeText(context, "Oncreate is called:", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context, "Exception:"+e, Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {



        try {
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
            Toast.makeText(context, "Onupgrade is called:", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context, "Exception:"+e, Toast.LENGTH_LONG).show();
        }


    }


    public long insertData(String date,String time,String dietplan)
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DATE,date);
        contentValues.put(TIME,time);
        contentValues.put(PLAN,dietplan);
        long rowNumber=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowNumber;
    }


    public Cursor displayAllData()
    {

      SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
     Cursor cursor= sqLiteDatabase.rawQuery(Select_ALL,null);

     return cursor;

    }

    public boolean updataData(String id,String date,String time,String dietplan)
    {
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(DATE,date);
        contentValues.put(TIME,time);
        contentValues.put(PLAN,dietplan);

        sqLiteDatabase.update(TABLE_NAME,contentValues,ID+"=?",new String[]{id});
        return true;
    }

   public int deleteData(String id)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME ,ID+"= ?",new String[]{id});

    }


}

