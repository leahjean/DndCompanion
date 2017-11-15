package edu.illinois.cs465.ddc;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Page adapter handles the portrait carousel for all races and classes on the
 * character creation menus
 *  Heavily based off tutorial at https://www.youtube.com/watch?v=GqcFEvBCnIk
 */

public class PortraitViewPageAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images;

    /**
     * Initialize the view page adapter for use with the ViewPagers displaying class and race
     * portraits in character select
     * @param image_prefix Pull all images from the drawable folder with the specified prefix
     */
    public PortraitViewPageAdapter(Context context, String image_prefix) {
        this.context = context;
        initImageFilenames(image_prefix);
    }

    /**
     * Initialize the image names
     * @param filename_prefix
     */
    private void initImageFilenames(String filename_prefix) {
        // Get all filenames that start with the prefix
        Field[] drawables = R.drawable.class.getFields();
        List<String> imageFilenames = new ArrayList<String>();
        for (Field f : drawables) {
            String filename = f.getName();
            if (filename.startsWith(filename_prefix)) {
                imageFilenames.add(filename);
            }
        }

        // Get all drawable ids for the given files
        List<Integer> drawableIds = new ArrayList<>();
        context = this.context;
                for (String filename : imageFilenames) {
            int drawableId = context.getResources().getIdentifier(filename, "drawable", context.getPackageName());
            drawableIds.add(drawableId);
        }

        images = drawableIds.toArray(new Integer[drawableIds.size()]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.race_class_portrait, null);
        ImageView raceClassPortrait = (ImageView) view.findViewById(R.id.race_class_portrait);
        raceClassPortrait.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
