package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import static android.R.attr.screenSize;

/**
 * Arc Bubble implementation. Call createArcBubble in onCreate() to add arc bubble to any screen.
 */


public class ArcBubbleUtil {

    // Empty private constructor to prevent instantiation of the utility class
    private ArcBubbleUtil() {}

    public static void createArcBubble(final Activity currActivity){
        ImageView arcIcon = new ImageView(currActivity);
        arcIcon.setImageResource(R.drawable.menu_icon);


        int w = Resources.getSystem().getDisplayMetrics().widthPixels;
        //int h = Resources.getSystem().getDisplayMetrics().heightPixels;

//250, 250
        FrameLayout.LayoutParams redCircleSize = new FrameLayout.LayoutParams((int)(0.2*w),(int)(0.2*w));

        final FloatingActionButton arcBubble = new FloatingActionButton.Builder(currActivity).setBackgroundDrawable(R.drawable.red_circle_selector).setContentView(arcIcon).build();
        arcBubble.setLayoutParams(redCircleSize);
        arcBubble.setPosition(FloatingActionButton.POSITION_BOTTOM_RIGHT,redCircleSize);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(currActivity);
        itemBuilder.setBackgroundDrawable(currActivity.getResources().getDrawable(R.drawable.blue_circle_selector));
        FrameLayout.LayoutParams blueCircleSize = new FrameLayout.LayoutParams((int)0.15*w, (int)0.15*w);
        itemBuilder.setLayoutParams(blueCircleSize);

        ImageView itemIcon1 = new ImageView(currActivity);
        itemIcon1.setImageResource(R.drawable.ic_character);
        SubActionButton button1 = itemBuilder.setContentView(itemIcon1).build();
        button1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                arcBubble.performClick();
                Intent it = new Intent(currActivity, CharacterMainScreenActivity.class);
                currActivity.startActivity(it);
            }
        });

        ImageView itemIcon2 = new ImageView(currActivity);
        itemIcon2.setImageResource(R.drawable.ic_inventory);
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();

        button2.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                arcBubble.performClick();
                Intent it = new Intent(currActivity, InventoryActivity.class);
                currActivity.startActivity(it);
            }
        });

        ImageView itemIcon3 = new ImageView(currActivity);
        itemIcon3.setImageResource(R.drawable.ic_note);
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();

        button3.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                arcBubble.performClick();
                Intent it = new Intent(currActivity, NoteListActivity.class);
                currActivity.startActivity(it);
            }
        });

        ImageView itemIcon4 = new ImageView(currActivity);
        itemIcon4.setImageResource(R.drawable.ic_combat);
        SubActionButton button4 = itemBuilder.setContentView(itemIcon4).build();

        button4.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                arcBubble.performClick();
                Intent it = new Intent(currActivity, CombatTabActivity.class);
                currActivity.startActivity(it);
            }
        });

        FloatingActionMenu arcMenu = new FloatingActionMenu.Builder(currActivity).addSubActionView(button1).addSubActionView(button2)
                .addSubActionView(button3).addSubActionView(button4).attachTo(arcBubble).setRadius(500).build();

    }
}
