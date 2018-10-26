package henryjade.theosimodel;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater layoutInflater;

    //Creating string and int arrays to hold the content and images associated with the viewpager on the homepage. Reference: https://www.youtube.com/watch?v=byLKoPgB7yA
    private String[] customHeadings = {
           "START LEARNING TODAY",
           "COMING SOON",
           "COMING SOON"
   };

    private String[] customDescriptions = {
            "See our lesson modules",
            "Flashcard function",
            "RSS Feed"
    };

    public int[] customImages = {
            R.drawable.study,
            R.drawable.flashcard,
            R.drawable.rss
    };


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
       // return images.length;
        return customHeadings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout,null);
        TextView customHeading = view.findViewById(R.id.customHeading);
        customHeading.setText(customHeadings[position]);

        TextView customDescription = view.findViewById(R.id.customDescription);
        ImageView customImage = view.findViewById(R.id.customImage);

        customImage.setImageResource(customImages[position]);
        customHeading.setText(customHeadings[position]);
        customDescription.setText(customDescriptions[position]);



        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
