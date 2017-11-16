package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class StartActivity extends Activity implements View.OnClickListener {
    private Button createCharacterBtn;
    private Button[] existingCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        createCharacterBtn = (Button) findViewById(R.id.create_character_btn);
        createCharacterBtn.setOnClickListener(this);


        ImageView arcIcon = new ImageView(this);
        arcIcon.setImageResource(R.drawable.ic_add_circle_outline_black_24dp);


        FloatingActionButton arcBubble = new FloatingActionButton.Builder(this).setBackgroundDrawable(R.drawable.red_circle_selector).build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        ImageView itemIcon1 = new ImageView(this);
        itemIcon1.setImageResource(R.drawable.ic_add_circle_outline_black_24dp);
        SubActionButton button1 = itemBuilder.setContentView(itemIcon1).build();


        ImageView itemIcon2 = new ImageView(this);
        itemIcon2.setImageResource(R.drawable.ic_add_circle_outline_black_24dp);
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();


        ImageView itemIcon3 = new ImageView(this);
        itemIcon3.setImageResource(R.drawable.ic_add_circle_outline_black_24dp);
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();

        FloatingActionMenu arcMenu = new FloatingActionMenu.Builder(this).addSubActionView(button1).addSubActionView(button2).addSubActionView(button3).attachTo(arcBubble).build();




    }

    public void onClick(View v) {
        if (v.getId() == R.id.create_character_btn) {
            Intent intent = new Intent(StartActivity.this, RaceSelectActivity.class);
            startActivity(intent);
        }
    }
}
