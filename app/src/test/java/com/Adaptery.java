package com;

import android.widget.ListAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.app.R;

public class Adaptery extends BaseAdapter
{
    private Context mContext;
    public Adaptery(Context c)
    {
        mContext=c;
    }
    @Override
    public int getCount()
    {
        return mThumbIds.length;
    }
    public  Object getItem(int position)
    {
        return null;
    }
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView==null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(85,85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }
        else
        {
            imageView=(ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    //array of images
    public Integer[] mThumbIds={
            R.drawable.book
    };


}

