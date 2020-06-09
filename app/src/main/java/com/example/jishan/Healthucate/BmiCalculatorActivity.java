package com.example.jishan.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiCalculatorActivity extends AppCompatActivity {

    private EditText Weight,HeightFeet,HeightInch;
    private Button BMICalculateButton;
    private TextView BMIResult;


    private void CalculateBMI()
    {
        try
        {
            String WeightString=Weight.getText().toString();
            String HeightFeetString=HeightFeet.getText().toString();
            String HeightInchString=HeightInch.getText().toString();
            float WeightFloat=Float.parseFloat(WeightString);
            float HeightFeetFloat=Float.parseFloat(HeightFeetString);
            float HeightInchFloat=Float.parseFloat(HeightInchString);
            float TotalHeight= (float) ((HeightFeetFloat*12+HeightInchFloat)*0.0254);
            float BMI=WeightFloat/(TotalHeight*TotalHeight);
            if(BMI<18.5)
                BMIResult.setText(Float.toString(BMI)+" (UnderWeight)");
            if(18.5<=BMI && BMI<=24.9)
                BMIResult.setText(Float.toString(BMI)+" (Healthy)");
            if(25.0<=BMI && BMI<=29.9)
                BMIResult.setText(Float.toString(BMI)+" (OverWeight)");
            if(BMI>29.9)
                BMIResult.setText(Float.toString(BMI)+" (Obese)");
        }

        catch (Exception e)
        {
            BMIResult.setText("Invalid Input");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        Weight=findViewById(R.id.WeightInput);
        HeightFeet=findViewById(R.id.HeightInputFt);
        HeightInch=findViewById(R.id.HeightInputInch);
        BMICalculateButton=findViewById(R.id.Calculate);
        BMIResult=findViewById(R.id.BMIOutput);

        BMICalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateBMI();
            }
        });
    }
}