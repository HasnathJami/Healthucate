package com.example.jishan.progressbar;

import android.content.Context;
import android.content.Intent;
import android.service.autofill.UserData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jishan.progressbar.DataUser;

public class LoginSignUpActivityForDietPlan extends AppCompatActivity implements View.OnClickListener {

    EditText name,username,email,password;
    TextView redirectText;
    Button signUpButton;

    DataUser dataUser;

    UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_log_out_activiy);

        name=findViewById(R.id.name_field);
        username=findViewById(R.id.username_field);
        email=findViewById(R.id.email_field);
        password=findViewById(R.id.password_field);
        redirectText=findViewById(R.id.redirect_text);
        signUpButton=findViewById(R.id.signup_button);
        String text=redirectText.getText().toString();

        signUpButton.setOnClickListener(this);

        dataUser =new DataUser();
        userDatabase=new UserDatabase(this);

        //String text="Already have an account? Click here.";

        try{
            SpannableString spannableString=new SpannableString(text);

            ClickableSpan clickableSpan=new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    //Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginSignUpActivityForDietPlan.this,LoginFromDietPlan.class);//Must add the class to manifest
                    startActivity(intent);
                }
            };

            spannableString.setSpan(clickableSpan,25,36,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//if actual start is 3, put 4. same for end
            redirectText.setText(spannableString);
            redirectText.setMovementMethod(LinkMovementMethod.getInstance());
        }
        catch (Exception e){
            Toast.makeText(this,"Error: "+e,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        String nameData=name.getText().toString();
        String usernameData=username.getText().toString();
        String emailData=email.getText().toString();
        String passData=password.getText().toString();

        dataUser.setName(nameData);
        dataUser.setUsername(usernameData);
        dataUser.setEmail(emailData);
        dataUser.setPassword(passData);

        if(v.getId()==R.id.signup_button){
            long inputId=userDatabase.insertInDatabase(dataUser);
            if(inputId!=-1)
                Toast.makeText(this,"Data inserted in entry: "+inputId,Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this,"Failed to insert data",Toast.LENGTH_LONG).show();
        }
    }
}
