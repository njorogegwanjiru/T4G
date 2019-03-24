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

public class PsyAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public PsyAdapter(Context context) {
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
            "I would not mind cheating on my partner if I knew they would never find out...",
            "I am very persuasive and good at getting others to do what I want...",
            "I tend to tell lies to take advantage of people and situations and I enjoy manipulating other peoples feelings...",
            "I think most people are mostly foolish and I believe I am superior to most of these people ",
            "I feel bad when my words or actions hurt other people",
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
