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

public class TestAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public TestAdapter(Context context) {
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
            "Has an unpleasant event happened supposing a real danger to your physical integrity or the physical integrity of others?",
            "Have you been exposed to an unpleasant event that has caused you intense horror and fear?",
            "Do you have recurrent nightmares or disturbing dreams related to the unpleasant event?",
            "Do you regularly have involuntary and distressing memories related to the unpleasant event?",
            "Do you feel intense discomfort when you are exposed to thoughts, objects or situations that make you remember the traumatic event?",
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
