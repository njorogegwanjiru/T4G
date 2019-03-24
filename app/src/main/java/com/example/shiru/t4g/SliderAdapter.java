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
import android.graphics.Color;
import com.example.shiru.t4g.R;

import de.hdodenhof.circleimageview.CircleImageView;

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
            "Mental Disorders",
            "Friends",
            "Specialists"
    };
    public String[] slide_descs = {
                "Mental disorders vary over a wide range of mental health conditions that affect mood, thinking and overall behaviour.They comprise a broad range of problems with different symptoms, some more severe than others.",
                "Friendships are valuable as we may talk to friends in confidence about things we would not discuss with other people. Find friends you can talk to and listen to, to help cope with or recover from various disorders.",
                "A psychiatrist is a physician devoted to the diagnosis, prevention, study and treatment of mental disorders. Meet and talk to psychologists to help improve your mental health. "
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

        CircleImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDescription =  view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);
        slideDescription.setTextColor(Color.BLACK);

        container.addView(view);

        return view;
    }

    @Override
    public  void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout) object);

    }
}
