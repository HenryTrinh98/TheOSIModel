package henryjade.theosimodel;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Onboarding extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;

    private Button nextButton;
    private Button previousbutton;

    private int mCurrentPage;

    @Override

    //Demonstrating the onboarding process via a series of slides set up through viewpager, buttons and dot indicators. Reference: https://www.youtube.com/watch?v=byLKoPgB7yA

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        mSlideViewPager = findViewById(R.id.slideviewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        nextButton = findViewById(R.id.nextButton);
        previousbutton = findViewById(R.id.prevButton);

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                if (mCurrentPage==mDots.length-1) {
                    Intent intent = new Intent(Onboarding.this,HomePage.class);
                    startActivity(intent);
                } else {
                    mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                }

            }
        });

        previousbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);

            }
        });

    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorGrey));
            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length >0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            mCurrentPage = i;

            if (i ==0) {
                nextButton.setEnabled(true);
                previousbutton.setEnabled(false);
                previousbutton.setVisibility(View.INVISIBLE);

                nextButton.setText("Next");
                previousbutton.setText("");
            } else if (i==mDots.length -1) {
                nextButton.setEnabled(true);
                previousbutton.setEnabled(true);
                previousbutton.setVisibility(View.VISIBLE);

                nextButton.setText("Finish");
                previousbutton.setText("Back");
            } else {
                nextButton.setEnabled(true);
                previousbutton.setEnabled(true);
                previousbutton.setVisibility(View.VISIBLE);

                nextButton.setText("Next");
                previousbutton.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
