package com.example.jishan.progressbar;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toogle;

    private CardView healthTips,exerciseTips,foodTips,medicineKit;
    private CardView bmiCalculator,nearbyHospitals,routine,aboutUs;
    private CardView calorieCalculator,settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_activity);
        drawerLayout = findViewById(R.id.drawerId);

        toogle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        healthTips = findViewById(R.id.HealthTips);
        healthTips.setOnClickListener(this);

        exerciseTips=findViewById(R.id.ExerciseTips);
        exerciseTips.setOnClickListener(this);

        foodTips=findViewById(R.id.FoodTips);
        foodTips.setOnClickListener(this);


        medicineKit=findViewById(R.id.MedKit);
        medicineKit.setOnClickListener(this);

        calorieCalculator=findViewById(R.id.calorieCalc);
        calorieCalculator.setOnClickListener(this);


        bmiCalculator=findViewById(R.id.BMI);
        bmiCalculator.setOnClickListener(this);

        nearbyHospitals=findViewById(R.id.Hospital);
        nearbyHospitals.setOnClickListener(this);

        routine=findViewById(R.id.Routine);
        routine.setOnClickListener(this);

        settings=findViewById(R.id.Settings);
        settings.setOnClickListener(this);

       aboutUs=findViewById(R.id.About);
       aboutUs.setOnClickListener(this);




    }

            public void onClick(View v) {

                if(v.getId()==R.id.HealthTips)
                {
                    Intent intent=new Intent(HomePageActivity.this,HealthTipsActivity.class);
                    startActivity(intent);
                }

                if(v.getId()==R.id.ExerciseTips)
                {
                    Intent intent=new Intent(HomePageActivity.this,ExerciseTipsActivity.class);
                    startActivity(intent);
                }

                if(v.getId()==R.id.FoodTips)
                {
                    Intent intent=new Intent(HomePageActivity.this,FoodTipsActivity.class);
                    startActivity(intent);
                }

                if(v.getId()==R.id.MedKit)
                {
                    Intent intent=new Intent(HomePageActivity.this,MediKitActivity.class);
                    startActivity(intent);
                }

                if(v.getId()==R.id.calorieCalc)
                {
                    Intent intent=new Intent(HomePageActivity.this,CalorieCalculatorActivity.class);
                    startActivity(intent);
                }


                if(v.getId()==R.id.BMI)
                {
                    Intent intent=new Intent(HomePageActivity.this,BmiCalculatorActivity.class);
                    startActivity(intent);
                }

                if(v.getId()==R.id.Hospital)
                {
                   // Intent intent=new Intent(HomePageActivity.this,NearByHospitalsActivity.class);
                   // startActivity(intent);
                    //Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:24.896837,91.902739"));
                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps/search/hospitals/@23.8213522,90.3747209,14z"));
                    startActivity(intent);
                }

                if(v.getId()==R.id.Routine)
                {
                    Intent intent=new Intent(HomePageActivity.this,LoginSignupActivity.class);
                    startActivity(intent);
                }

                if(v.getId()==R.id.Settings)
                {
                    Intent intent=new Intent(HomePageActivity.this,LoginSignUpActivityForDietPlan.class);
                    startActivity(intent);
                }

                if(v.getId()==R.id.About)
                {
                    //Intent intent=new Intent(HomePageActivity.this,AboutUsActivity.class);
                    //startActivity(intent);
                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps/search/gym/@23.8213522,90.3747209,14z"));
                    startActivity(intent);
                }

            }










    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mnuitemon_actionbar,menu);
        return super.onCreateOptionsMenu(menu);
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toogle.onOptionsItemSelected(item))
        {
            return  true;
        }
        return super.onOptionsItemSelected(item);








    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }



}
