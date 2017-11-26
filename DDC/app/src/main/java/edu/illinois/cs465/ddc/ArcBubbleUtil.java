package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

/**
 * Arc Bubble implementation. Call createArcBubble in onCreate() to add arc bubble to any screen.
 */

public class ArcBubbleUtil {
    // Empty private constructor to prevent instantiation of the utility class
    private ArcBubbleUtil() {}

    public static void createArcBubble(Activity currActivity){
        ImageView arcIcon = new ImageView(currActivity);
        arcIcon.setImageResource(R.drawable.menu_icon);


        FloatingActionButton arcBubble = new FloatingActionButton.Builder(currActivity).setBackgroundDrawable(R.drawable.red_circle_selector).setContentView(arcIcon).build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(currActivity);
        itemBuilder.setBackgroundDrawable(currActivity.getResources().getDrawable(R.drawable.blue_circle_selector));
        FrameLayout.LayoutParams blueCircleSize = new FrameLayout.LayoutParams(150, 150);
        itemBuilder.setLayoutParams(blueCircleSize);
        ImageView itemIcon1 = new ImageView(currActivity);
        itemIcon1.setImageResource(R.drawable.ic_add_circle_outline_white_24dp);
        SubActionButton button1 = itemBuilder.setContentView(itemIcon1).build();


        ImageView itemIcon2 = new ImageView(currActivity);
        itemIcon2.setImageResource(R.drawable.ic_add_circle_outline_white_24dp);
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();


        ImageView itemIcon3 = new ImageView(currActivity);
        itemIcon3.setImageResource(R.drawable.ic_add_circle_outline_white_24dp);
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();

        ImageView itemIcon4 = new ImageView(currActivity);
        itemIcon4.setImageResource(R.drawable.ic_add_circle_outline_white_24dp);
        SubActionButton button4 = itemBuilder.setContentView(itemIcon4).build();

        FloatingActionMenu arcMenu = new FloatingActionMenu.Builder(currActivity).addSubActionView(button1).addSubActionView(button2)
                .addSubActionView(button3).addSubActionView(button4).attachTo(arcBubble).setRadius(500).build();
    }
}
