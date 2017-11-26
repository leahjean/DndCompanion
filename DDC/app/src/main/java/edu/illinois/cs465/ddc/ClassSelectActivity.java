package edu.illinois.cs465.ddc;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Activity handles page for selecting a class
 */
public class ClassSelectActivity extends Activity implements View.OnClickListener {
    ImageButton nextClassBtn, backClassBtn;
    Button detailBtn, backPageBtn, nextPageBtn;
    WrapContentHeightViewPager portraitViewPager;
    TextView classNameView;

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

        detailBtn = (Button) findViewById(R.id.race_class_detail_btn);
        detailBtn.setOnClickListener(this);

        backPageBtn= (Button) findViewById(R.id.race_class_back_page_btn);
        backPageBtn.setOnClickListener(this);

        nextPageBtn= (Button) findViewById(R.id.race_class_next_page_btn);
        nextPageBtn.setOnClickListener(this);
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
