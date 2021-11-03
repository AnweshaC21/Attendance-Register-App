package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Adaptery extends BaseAdapter
    {
        private Context mContext;
        private LayoutInflater inflater;
        public Adaptery(Context c)
        {
            mContext=c;
        }
        @Override
        public int getCount()
        {
            return word.length;
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

            if(inflater ==null) {
                inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }if(convertView==null) {
                convertView = inflater.inflate(R.layout.row_item,null);
            }
               ImageView imageView= convertView.findViewById(R.id.image_view);
            TextView textView= convertView.findViewById(R.id.text_view);

            imageView.setImageResource(mThumbIds[position]);
            textView.setText(word[position]);
            return convertView;

        }
        //array of images
        public String[] word={"sub1","sub2","sub3","sub4","sub5","sub6","sub7","sub8","sub9","sub10"};
        public Integer[] mThumbIds={
                R.drawable.book_111,R.drawable.book_111,R.drawable.book_111,R.drawable.book_111,
                R.drawable.book_111,R.drawable.book_111,R.drawable.book_111,R.drawable.book_111,
                R.drawable.book_111,R.drawable.book_111};


    }

