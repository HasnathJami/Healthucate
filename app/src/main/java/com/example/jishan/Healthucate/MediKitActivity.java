package com.example.jishan.progressbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MediKitActivity extends AppCompatActivity {


    int imgArray[]= {R.drawable.fever,R.drawable.tuberculosis,R.drawable.dengue,R.drawable.headache,R.drawable.influenza,R.drawable.diabetes

    };


    String[] diseaseName;
    String [] diseaseDescription;
    private GridView gridview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medi_kit);

        gridview=findViewById(R.id.gridViewId);
        diseaseName=getResources().getStringArray(R.array.disease_names);
        diseaseDescription=getResources().getStringArray(R.array.disease_description);


        CustomAdapter adapter =new CustomAdapter(this,diseaseName,imgArray);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(getApplicationContext(),DescriptionActivity.class);
                intent.putExtra("destext",diseaseDescription[position]);
                intent.putExtra("desimage",imgArray[position]);
                startActivity(intent);


            }
        });

    }
}
