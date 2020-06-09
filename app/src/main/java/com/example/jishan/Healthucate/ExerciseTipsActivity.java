package com.example.jishan.progressbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ExerciseTipsActivity extends AppCompatActivity {


    int imgArray[]= {R.drawable.running,R.drawable.pushup,R.drawable.ropeskipping,R.drawable.cycling,R.drawable.swimming,R.drawable.pullup,R.drawable.stretching,
            R.drawable.squat,R.drawable.walking,R.drawable.climbing,R.drawable.weightlifting

    };


    String[] exerciseName;
    String [] exerciseDescription;
    private GridView gridview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_tips);

        gridview=findViewById(R.id.gridViewId);
        exerciseName=getResources().getStringArray(R.array.excercise_names);
        exerciseDescription=getResources().getStringArray(R.array.excercise_description);


        CustomAdapter adapter =new CustomAdapter(this,exerciseName,imgArray);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // String value=foodName[position];
                // Toast.makeText(FoodTipsActivity.this,value,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),DescriptionActivity.class);
                intent.putExtra("destext",exerciseDescription[position]);
                intent.putExtra("desimage",imgArray[position]);
                startActivity(intent);


            }
        });

    }
}
