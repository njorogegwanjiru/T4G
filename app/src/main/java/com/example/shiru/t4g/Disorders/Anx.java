package com.example.shiru.t4g.Disorders;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shiru.t4g.R;

public class Anx extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    //array to store dots
    private TextView[] mDots;
    private AnxAdapter anx;
    private TextView  results,yes,no;
    private int mCurrentPage;
    private TextView nextqn;
    public static String resultvalue;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anx);

        mSlideViewPager = (ViewPager) findViewById(R.id.testViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.testdots);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        nextqn = findViewById(R.id.btn_next_qn);
        results = findViewById(R.id.resultstv);

        anx = new AnxAdapter(this);
        mSlideViewPager.setAdapter(anx);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //button onclick listeners
        nextqn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });

    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[7];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            // mDotLayout.addView(mDots[i]);

        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorBlue));
        }
    }

    final ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        Boolean first = true;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (first && positionOffset == 0 && positionOffsetPixels == 0) {
                onPageSelected(0);
                first = false;
            }

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if (i == 0) {
                nextqn.setVisibility(View.VISIBLE);
                nextqn.setText("Start");

                nextqn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                    }
                });

            } else if (i == 1) {
                nextqn.setVisibility(View.INVISIBLE);
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("y");
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("n");
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                    }
                });


            } else if (i == 2) {
                nextqn.setVisibility(View.INVISIBLE);
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("y");
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("n");
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                    }
                });

            } else if (i == 3) {
                nextqn.setVisibility(View.INVISIBLE);
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("y");
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("n");
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                    }
                });

            } else if (i == 4) {
                nextqn.setVisibility(View.INVISIBLE);
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("y");
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("n");
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                    }
                });

            } else if (i == 5) {
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
                nextqn.setVisibility(View.INVISIBLE);
                nextqn.setText("Finish");
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("y");
                        yes.setEnabled(false);
                        no.setEnabled(false);
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        results.append("n");
                        no.setEnabled(false);
                        yes.setEnabled(false);
                        mSlideViewPager.setCurrentItem(mCurrentPage + 1);

                    }
                });
            }else if (i == mDots.length - 1){
                yes.setVisibility(View.INVISIBLE);
                no.setVisibility(View.INVISIBLE);
                nextqn.setVisibility(View.VISIBLE);
                nextqn.setEnabled(true);
                nextqn.setText("See Results");
                nextqn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Anx.this, AnxActivity.class);
                        startActivity(intent);
                    }
                });

            }

            resultvalue = results.getText().toString();

        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}