package com.example.shiru.t4g;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home_first extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    FirebaseUser firebaseUser;

    //array to store dots
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private Button mNextBtn, mBackBtn;
    private int mCurrentPage;

    @Override
    protected void onStart() {
        super.onStart();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseUser!=null){
            Intent intent = new Intent(home_first.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_first);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        mBackBtn = (Button) findViewById(R.id.prevBtn);
        mNextBtn = (Button) findViewById(R.id.nextBtn);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //button onclick listeners
        mNextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });


    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);

        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorBlue));
        }
    }
    public void register(){
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;


            if (i == 0) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("");
                mBackBtn.setText("");

            } else if (i == mDots.length-1) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Get Started");
                mBackBtn.setText("");
                mNextBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        register();
                    }
                });
            }else{
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("");
                mBackBtn.setText("");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
