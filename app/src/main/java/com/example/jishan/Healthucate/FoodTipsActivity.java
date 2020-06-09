package com.example.jishan.progressbar;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.widget.Toast;

public class FoodTipsActivity extends AppCompatActivity {


    int imgArray[]= {R.drawable.guava,R.drawable.lemon,R.drawable.grape,R.drawable.papaya,R.drawable.orange,R.drawable.banana,R.drawable.apple,R.drawable.watermelon,R.drawable.avacado,

    R.drawable.spinach,R.drawable.cauliflower,R.drawable.cabbage,R.drawable.cucumber,R.drawable.tomato,R.drawable.bellpepper,R.drawable.carrot,R.drawable.sweetcorn,R.drawable.pumpkin,R.drawable.onion,
   R.drawable.almond,R.drawable.egg,R.drawable.meat,R.drawable.fish,R.drawable.milk,R.drawable.lentil

    };


    String[] foodName;
    String [] foodDescription;
    private GridView gridview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tips);

        gridview=findViewById(R.id.gridViewId);
        foodName=getResources().getStringArray(R.array.food_names);
        foodDescription=getResources().getStringArray(R.array.food_description);


        CustomAdapter adapter =new CustomAdapter(this,foodName,imgArray);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // String value=foodName[position];
               // Toast.makeText(FoodTipsActivity.this,value,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),DescriptionActivity.class);
                intent.putExtra("destext",foodDescription[position]);
                intent.putExtra("desimage",imgArray[position]);
                startActivity(intent);


            }
        });

    }
}
