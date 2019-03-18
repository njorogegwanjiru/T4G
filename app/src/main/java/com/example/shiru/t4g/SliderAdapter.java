package com.example.shiru.t4g;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shiru.t4g.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //arrays
    public int[] slide_images = {
            R.drawable.cloud,
            R.drawable.friends,
            R.drawable.doctor
    };
    public String[] slide_headings = {
            "DISORDERS",
            "FRIENDS",
            "SPECIALISTS"
    };
    public String[] slide_descs = {
                "Many people suffer from varying mental disorders." +
                        "To determine yours, take the evaluation test",
                "Solutions are always found when there's a friend to share with."+
                        "Meet people with similar issues.",
                "Meet professional psychiatrists ready to help with your issues!"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public  Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public  void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout) object);

    }
}
