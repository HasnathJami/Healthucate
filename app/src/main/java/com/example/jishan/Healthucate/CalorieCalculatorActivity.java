package com.example.jishan.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CalorieCalculatorActivity extends AppCompatActivity {

    String[] BI,BA,LI,LA,DI,DA,S;
    private Spinner BIS,BAS,LIS,LAS,DIS,DAS,SS;
    private Button Calculate;
    private TextView Result;

    private double Calorie(String selected){
        if(selected.equals("None"))
            return 0;
        if(selected.equals("White Bread"))
            return 2.65;
        if(selected.equals("Brown Bread"))
            return 2.93;
        if(selected.equals("Cereals"))
            return 3.79;
        if(selected.equals("Fruit Salad"))
            return 0.5;

        if(selected.equals("Cooked Rice"))
            return 1.3;
        if(selected.equals("Fried Rice"))
            return 1.63;

        if(selected.equals("Pasta"))
            return 1.31;
        if(selected.equals("Potato"))
            return 0.77;
        if(selected.equals("Chicken"))
            return 2.39;

        if(selected.equals("Pack of Potato Crackers"))
            return 118;
        if(selected.equals("Pack of Digestive Biscuits"))
            return 707;

        if(selected.equals("50gm"))
            return 50;
        if(selected.equals("250gm"))
            return 250;
        if(selected.equals("500gm"))
            return 500;

        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);

        BI=getResources().getStringArray(R.array.breakfast_items);
        BA=getResources().getStringArray(R.array.breakfast_amount);
        LI=getResources().getStringArray(R.array.lunch_items);
        LA=getResources().getStringArray(R.array.lunch_amount);
        DI=getResources().getStringArray(R.array.dinner_items);
        DA=getResources().getStringArray(R.array.dinner_amount);
        S=getResources().getStringArray(R.array.snacks);

        BIS=findViewById(R.id.breakfast_item);
        BAS=findViewById(R.id.breakfast_amount);
        LIS=findViewById(R.id.lunch_item);
        LAS=findViewById(R.id.lunch_amount);
        DIS=findViewById(R.id.dinner_item);
        DAS=findViewById(R.id.dinner_amount);
        SS=findViewById(R.id.snacks_item);

        Calculate=findViewById(R.id.calculate);

        Result=findViewById(R.id.result);

        ArrayAdapter<String> BIAdapter=new ArrayAdapter<String>(this,R.layout.view_setup,R.id.array_string_view,BI);
        ArrayAdapter<String> BAAdapter=new ArrayAdapter<String>(this,R.layout.view_setup,R.id.array_string_view,BA);
        ArrayAdapter<String> LIAdapter=new ArrayAdapter<String>(this,R.layout.view_setup,R.id.array_string_view,LI);
        ArrayAdapter<String> LAAdapter=new ArrayAdapter<String>(this,R.layout.view_setup,R.id.array_string_view,LA);
        ArrayAdapter<String> DIAdapter=new ArrayAdapter<String>(this,R.layout.view_setup,R.id.array_string_view,DI);
        ArrayAdapter<String> DAAdapter=new ArrayAdapter<String>(this,R.layout.view_setup,R.id.array_string_view,DA);
        ArrayAdapter<String> SAdapter=new ArrayAdapter<String>(this,R.layout.view_setup,R.id.array_string_view,S);

        BIS.setAdapter(BIAdapter);
        BAS.setAdapter(BAAdapter);
        LIS.setAdapter(LIAdapter);
        LAS.setAdapter(LAAdapter);
        DIS.setAdapter(DIAdapter);
        DAS.setAdapter(DAAdapter);
        SS.setAdapter(SAdapter);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double Selected_BI_Calorie=Calorie(BIS.getSelectedItem().toString());
                double Selected_BI_Amount=Calorie(BAS.getSelectedItem().toString());
                double Breakfast_Calorie=Selected_BI_Calorie*Selected_BI_Amount;

                double Selected_LI_Calorie=Calorie(LIS.getSelectedItem().toString());
                double Selected_LI_Amount=Calorie(LAS.getSelectedItem().toString());
                double Lunch_Calorie=Selected_LI_Calorie*Selected_LI_Amount;

                double Selected_DI_Calorie=Calorie(DIS.getSelectedItem().toString());
                double Selected_DI_Amount=Calorie(DAS.getSelectedItem().toString());
                double Dinner_Calorie=Selected_DI_Calorie*Selected_DI_Amount;

                double Snack_Calorie=Calorie(SS.getSelectedItem().toString());

                double Total_Calorie=Breakfast_Calorie+Lunch_Calorie+Dinner_Calorie+Snack_Calorie;

                String Total_Calorie_String=": "+(new Double(Total_Calorie)).toString()+" Calories";


                Result.setText(Total_Calorie_String);
            }
        });
    }
}
