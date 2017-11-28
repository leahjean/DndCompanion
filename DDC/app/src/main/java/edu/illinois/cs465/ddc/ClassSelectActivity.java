package edu.illinois.cs465.ddc;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

/**
 * Activity handles page for selecting a class
 */
public class ClassSelectActivity extends Activity implements View.OnClickListener {
    ImageButton nextClassBtn, backClassBtn;
    Button backPageBtn, nextPageBtn;
    WrapContentHeightViewPager portraitViewPager;
    TextView classNameView;
    private static final Map<String, String> tooltipTexts = initTooltipTexts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.race_class_select);

        initButtons();
        initPortraitViewPager();
        initClassNameView();
        classNameView = (TextView) findViewById(R.id.race_class_name);
    }

    // Initialize button variables and button event listeners for each button on the page
    private void initButtons() {
        backClassBtn = (ImageButton) findViewById(R.id.race_class_back_btn);
        backClassBtn.setOnClickListener(this);

        nextClassBtn = (ImageButton) findViewById(R.id.race_class_next_btn);
        nextClassBtn.setOnClickListener(this);

        backPageBtn= (Button) findViewById(R.id.race_class_back_page_btn);
        backPageBtn.setOnClickListener(this);

        nextPageBtn= (Button) findViewById(R.id.race_class_next_page_btn);
        nextPageBtn.setOnClickListener(this);
    }

    private static Map<String, String> initTooltipTexts() {
        Map<String, String> tooltipTexts = new HashMap<>();
        tooltipTexts.put("Barbarian", "A fierce warrior of primitive background who can enter a battle rage");
        tooltipTexts.put("Bard", "An inspiring magician whose power echoes the music of creation");
        tooltipTexts.put("Cleric", "A priestly champion who wields divine magic in service of a higher power");
        tooltipTexts.put("Druid", "A priest of the Old Faith, wielding the powers of nature and adopting animal forms");
        tooltipTexts.put("Fighter", "A master of martial combat, skilled with a variety of weapons and armor");
        tooltipTexts.put("Monk", "A master of martial arts, harnessing the power of the body in pursuit of physical and spiritual perfection");
        tooltipTexts.put("Paladin", "A holy warrior bound to a sacred oath");
        tooltipTexts.put("Ranger", "A warrior who combats threats on the edges of civilization");
        tooltipTexts.put("Rogue", "A scoundrel who uses stealth and trickery to overcome obstacles and enemies");
        tooltipTexts.put("Sorcerer", "A spellcaster who draws on inherent magic from a gift or bloodline");
        tooltipTexts.put("Warlock", "A wielder of magic that is derived from a bargain with an extraplanar entity");
        tooltipTexts.put("Wizard", "A scholarly magic-user capable of manipulating the structures of reality");
        return Collections.unmodifiableMap(tooltipTexts);
    }

    // Initialize view pager to allow for carousel of races and add page change listener
    private void initPortraitViewPager() {
        portraitViewPager = (WrapContentHeightViewPager) findViewById(R.id.race_class_portrait_view_pager);
        PortraitViewPageAdapter pageAdapter = new PortraitViewPageAdapter(this, "class");
        portraitViewPager.setAdapter(pageAdapter);

        portraitViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void onPageSelected(int position) {
                classNameView.setText(getCurrentClass());
            }
        });
    }

    // Initialize text view displaying the current race
    private void initClassNameView() {
        classNameView = (TextView) findViewById(R.id.race_class_name);
        classNameView.setText(getCurrentClass());

        classNameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SimpleTooltip.Builder(getApplicationContext())
                        .anchorView(view)
                        .text(tooltipTexts.get(getCurrentClass()))
                        .gravity(Gravity.TOP)
                        .build()
                        .show();
            }
        });
    }

    // Get the current race name from the ViewPagerAdapter's list of filenames
    private String getCurrentClass() {
        PortraitViewPageAdapter portraitAdapter = (PortraitViewPageAdapter) portraitViewPager.getAdapter();
        List<String> filenames = portraitAdapter.getImageFilenames();

        int currPosition = portraitViewPager.getCurrentItem();
        String rawFilename = filenames.get(currPosition)
                .replace("class_", "")
                .replace("_", " ");
        return rawFilename.substring(0, 1).toUpperCase() + rawFilename.substring(1);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.race_class_back_btn: {
                CharacterCreateUtil.raceClassScrollPrevPortrait(portraitViewPager);
                break;
            }
            case R.id.race_class_next_btn: {
                CharacterCreateUtil.raceClassScrollNextPortrait(portraitViewPager);
                break;
            }
            case R.id.race_class_back_page_btn:
                this.finish();
                break;
            case R.id.race_class_next_page_btn:
                Bundle prevBundle = getIntent().getExtras();
                Intent intent = new Intent(this, StatsEditActivity.class);
                intent.putExtra("Selected Class", getCurrentClass());
                intent.putExtra("Selected Race", prevBundle.getString("Selected Race"));
                startActivity(intent);
        }
    }
}
