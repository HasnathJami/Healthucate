package com.example.jishan.progressbar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    MyDataBaseHelper myDataBaseHelper;
    private EditText nameEditText,ageEditText,genderEditText,idEditText;
    private Button addButton,showButton,updateButton,deleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        myDataBaseHelper=new MyDataBaseHelper(this);
        SQLiteDatabase sqLiteDatabase=myDataBaseHelper.getWritableDatabase();


        nameEditText=findViewById(R.id.nameEditTexId);
        ageEditText=findViewById(R.id.ageEditTextId);
        genderEditText=findViewById(R.id.genderEditTextId);

         idEditText=findViewById(R.id.idEditTextId);
        addButton=findViewById(R.id.saveButtonId);
       showButton=findViewById(R.id.showButtonId);
       updateButton=findViewById(R.id.updateButtonId);
       deleteButton=findViewById(R.id.deleteButtonId);


        addButton.setOnClickListener(this);
       showButton.setOnClickListener(this);
       updateButton.setOnClickListener(this);
      deleteButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String name=nameEditText.getText().toString();
        String age=ageEditText.getText().toString();
        String gender=genderEditText.getText().toString();
        String id=idEditText.getText().toString();

        if(v.getId()==R.id.saveButtonId)
        {
              long rowId=myDataBaseHelper.insertData(name,age,gender);
              if(rowId==-1)
              {

                  Toast.makeText(getApplicationContext(), "Row is not suc inserted:", Toast.LENGTH_LONG).show();

              }

              else{
                  Toast.makeText(getApplicationContext(), "Row "+rowId+" is suc inserted:", Toast.LENGTH_LONG).show();
              }
        }


        if(v.getId()==R.id.showButtonId)
        {
            Cursor cursor=myDataBaseHelper.displayAllData();

            if(cursor.getCount()==0)
            {
                return;
            }

            StringBuffer stringBuffer=new StringBuffer();
            while(cursor.moveToNext())
            {
                stringBuffer.append("--------------------------------------------------------------------------------------------------------------------------------------------\n\n\nSchedule:"+cursor.getString(0)+"\n\n");
                stringBuffer.append("Time:"+cursor.getString(1)+"\n\n");
                stringBuffer.append("Workout Plan:"+cursor.getString(2)+"\n\n");
                stringBuffer.append("Food Plan:"+cursor.getString(3)+"\n\n\n\n");
            }

            showData("ROUTINE:",stringBuffer.toString());



        }


        if(v.getId()==R.id.updateButtonId)
        {
           Boolean isUpdated= myDataBaseHelper.updataData(id,name,age,gender);

           if(isUpdated==true)
           {
               Toast.makeText(getApplicationContext(), "Data is updated", Toast.LENGTH_LONG).show();
           }

           else{
               Toast.makeText(getApplicationContext(), "Data is not  updated", Toast.LENGTH_LONG).show();
           }


        }




        if(v.getId()==R.id.deleteButtonId)
        {
           int value=  myDataBaseHelper.deleteData(id);

           if(value>0)
           {
               Toast.makeText(getApplicationContext(), "Data is  deleted", Toast.LENGTH_LONG).show();
           }

           else{



               Toast.makeText(getApplicationContext(), "Data is not  deleted", Toast.LENGTH_LONG).show();
           }

           }
        }












    public void showData(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }


}
