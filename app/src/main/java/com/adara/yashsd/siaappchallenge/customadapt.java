package com.adara.yashsd.siaappchallenge;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


//to add anything else other than strings in the custom view simply extend ArrayAdapter<OBJECT_NAME>
public class customadapt extends ArrayAdapter {

    private Activity context;
    private String[] arr1;
    private String[] arr2;
    private String[] arr3;
    private String[] arr4;


    public customadapt(Activity context, String[] arr1, String[] arr2,String[] arr3, String[] arr4)
    {
        super(context,R.layout.customlayout,arr1);
        this.context = context;
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.arr3 = arr3;
        this.arr4 = arr4;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inf = context.getLayoutInflater();
        View rowview = inf.inflate(R.layout.customlayout,null,true);

        TextView tv1 = (TextView)rowview.findViewById(R.id.tv1);
        TextView tv2 = (TextView)rowview.findViewById(R.id.tv2);
        TextView tv3 = (TextView)rowview.findViewById(R.id.tv3);
        TextView tv4 = (TextView)rowview.findViewById(R.id.tv4);

        tv1.setText(arr1[position]);
        tv2.setText(arr2[position]);
        tv3.setText(arr3[position]);
        tv4.setText(arr4[position]);

        return rowview;
    }
}
