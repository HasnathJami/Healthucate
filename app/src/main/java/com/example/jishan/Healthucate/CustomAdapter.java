package com.example.jishan.progressbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomAdapter extends BaseAdapter {

    Context context;
    int[] imgArray;
    String[] foodName;
    private LayoutInflater inflater;

    CustomAdapter(Context context,String[] foodName,int[] imgArray)
    {

        this.context=context;
        this.foodName=foodName;
        this.imgArray=imgArray;

    }


    @Override
    public int getCount() {

        return foodName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {

             inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             convertView=inflater.inflate(R.layout.image_title_sitting_view,parent,false);


        }

        ImageView imageView= convertView.findViewById(R.id.imageViewId);
        TextView textView= convertView.findViewById(R.id.textViewId);

        imageView.setImageResource(imgArray[position]);
        textView.setText(foodName[position]);

        return convertView;
    }
}
