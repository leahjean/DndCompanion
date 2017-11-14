package edu.illinois.cs465.ddc;


import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageButton;

public class RaceSelectActivity extends Activity implements View.OnClickListener {
    ImageButton nextRaceBtn, backRaceBtn;
    Button detailBtn, backPageBtn, nextPageBtn;
    ViewPager portraitViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.race_class_select);

        initButtons();

//        portraitViewPager = (ViewPager) findViewById(R.id.race_class_portrait_view_pager);
//        PortraitViewPageAdapter pageAdapter = new PortraitViewPageAdapter(this, "race");
    }

    // Initialize button variables and button event listeners for each button on the page
    private void initButtons() {
        backRaceBtn = (ImageButton) findViewById(R.id.race_class_back_btn);
        backRaceBtn.setOnClickListener(this);

        nextRaceBtn = (ImageButton) findViewById(R.id.race_class_next_btn);
        nextRaceBtn.setOnClickListener(this);

        detailBtn = (Button) findViewById(R.id.race_class_detail_btn);
        detailBtn.setOnClickListener(this);

        backPageBtn= (Button) findViewById(R.id.race_class_back_page_btn);
        backPageBtn.setOnClickListener(this);

        nextPageBtn= (Button) findViewById(R.id.race_class_next_page_btn);
        nextPageBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.race_class_back_btn:
                break;
            case R.id.race_class_next_btn:
                break;
        }
    }
}
