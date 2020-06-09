package com.example.jishan.progressbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

     TextView destext;
     ImageView desimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        destext=findViewById(R.id.desTextViewId);
        desimage=findViewById(R.id.desImageViewId);
        Intent intent=getIntent();
        destext.setText(intent.getStringExtra("destext"));
        desimage.setImageResource(intent.getIntExtra("desimage",0));
    }
}
