package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StartActivity extends Activity implements View.OnClickListener {
    private Button createCharacterBtn;
    private HashMap<Integer, String> characterBtnIds = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        createCharacterBtn = (Button) findViewById(R.id.create_character_btn);
        createCharacterBtn.setOnClickListener(this);


        addExistingCharacterBtn("Greg");
        addExistingCharacterBtn("Gregor");
        addExistingCharacterBtn("Gregoth");
    }

    public void onClick(View v) {
        if (v.getId() == R.id.create_character_btn) {
            Intent intent = new Intent(StartActivity.this, RaceSelectActivity.class);
            startActivity(intent);
        }

        // Change to existing button view
       if (characterBtnIds.get(v.getId()) != null) {
            Intent intent = new Intent(this, CharacterMainScreenActivity.class);
            intent.putExtra("characterId", characterBtnIds.get(v.getId()));
            startActivity(intent);
        }
    }

    /**
     * TODO: Get string to display on existing character button
     * @param characterId Character id to index database on
     */
    private String getExistingCharacterText(String characterId) {
        return characterId;
    }

    private int convertToDP(int dpSize) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dpSize,
                getResources().getDisplayMetrics());
    }

    /**
     * Add existing character button for each character in the "database"
     * @param characterId Character id to index database on
     */
    private void addExistingCharacterBtn(String characterId) {
        LinearLayout existingCharacterList = (LinearLayout) findViewById(R.id.existing_characters_list);
        Button characterBtn = new Button(this);

        // Set styles on the button
        Drawable bg = ResourcesCompat.getDrawable(this.getResources(), R.drawable.expandable_button_background, null);
        characterBtn.setBackground(bg);
        characterBtn.setGravity(Gravity.CENTER);
        int height = convertToDP(60);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                convertToDP(60));
        params.setMargins(
                convertToDP(0),
                convertToDP(3),
                convertToDP(0),
                convertToDP(3));
        characterBtn.setLayoutParams(params);
        characterBtn.setTextSize(20);

        // Set button id as an identifier for onclick events
        int characterBtnId = View.generateViewId();
        characterBtn.setId(characterBtnId);
        characterBtnIds.put(characterBtnId, characterId);

        // Use characterId to get a brief description string for the character's button
        characterBtn.setText(getExistingCharacterText(characterId));

        // Add the button to the LinearLayout view of existing characters
        existingCharacterList.addView(characterBtn);

        // Add event listeners
        characterBtn.setOnClickListener(this);
    }

    /**
     *  TODO: Keji
     */
    private void setExistingCharacterListIds() {
    }
}
