package com.example.shiru.t4g.Disorders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shiru.t4g.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class BdAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public BdAdapter(Context context) {
        this.context = context;
    }

    //arrays

    public int[] slide_images = {
            R.drawable.ribbon,
            R.drawable.ribbon,
            R.drawable.ribbon,
            R.drawable.ribbon,
            R.drawable.ribbon,
            R.drawable.ribbon,
            R.drawable.ribbon
    };
    public String[] slide_headings = {
            "NOTE",
            "QUESTION 1",
            "QUESTION 2",
            "QUESTION 3",
            "QUESTION 4",
            "QUESTION 5",
            "Congratulations."
    };
    public String[] slide_descs = {
            "This test is not intended to replace consultation with a specialist or mental health professional if you believe you may be suffering from a mental health condition. You could share your results with professionals",
            "In the span of the past one week, have you experienced a feeling of great self confidence and self appraisal while other times these feelings strongly decreased?",
            "Do you experience a decrease in your need to sleep and despite this you do not feel tired?",
            "In the past week did you experience significant increase in your thinking speed even to the point of chsnging topics constantly and without reason?",
            "Over the past week did you lose intrest in almost every activity or did your capacity to enjoy them decrease?",
            "Over the past week did you have any recurrent feelings of uselessness or guilt?",
            "You have successfully completed the T4G evaluation test. Click the button below to see your results. Remember you can always retake the test to keep evaluating yourself"
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

        View view = layoutInflater.inflate(R.layout.tests_layout, container, false);

        CircleImageView slideImageView =  view.findViewById(R.id.slide_image);
        TextView slideHeading =  view.findViewById(R.id.slide_heading);
        TextView slideDescription =  view.findViewById(R.id.slide_desc);

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
