package henryjade.theosimodel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    //Creating string and int arrays to hold the content and images associated with the viewpager in the onboarding process.
    //Reference: https://www.youtube.com/watch?v=byLKoPgB7yA

    public SliderAdapter(Context context) {

        this.context = context;
    }

    public int[] slide_images = {
            R.drawable.lesson_3,
            R.drawable.quiz_3,
            R.drawable.rank_3
    };

    public String[] slide_headings = {
            "LESSON",
            "QUIZ",
            "SCORES"
    };

    public String[] slide_descs = {
            "Learn about the OSI model through a series of modules covering each of the 7 layers",
            "Each module has a quiz. This is to consolidate your learning and test your knowledge",
            "Track your performance through scores"
    };



    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slideHeading);
        TextView slideDescription = view.findViewById(R.id.slideDescription);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout)object);



    }

}
