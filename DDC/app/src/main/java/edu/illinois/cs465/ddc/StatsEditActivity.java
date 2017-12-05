package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static edu.illinois.cs465.ddc.GeneralUtil.addSimpleTooltip;
import static edu.illinois.cs465.ddc.GeneralUtil.tooltipTexts;

/**
 * Character Creation screen to edit initial stats
 */
public class StatsEditActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_edit);

        Button next_button, back_button;
        next_button = (Button) findViewById(R.id.stats_edit_next_page_btn);
        next_button.setOnClickListener(this);
        back_button = (Button) findViewById(R.id.stats_edit_back_page_btn);
        back_button.setOnClickListener(this);

        bindLabelClickListeners();
    }

    // Bind click listeners for every label so that tooltips appear on click
    private void bindLabelClickListeners() {
        int[] labelIds = {
                R.id.strength_label,
                R.id.dexterity_label,
                R.id.constitution_label,
                R.id.intelligence_label,
                R.id.wisdom_label,
                R.id.charisma_label
        };

        for (int labelId : labelIds) {
            TextView labelTextView = (TextView) findViewById(labelId);
            labelTextView.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.strength_label:
                addSimpleTooltip(this, v, tooltipTexts.get("STR"), Gravity.BOTTOM);
                break;
            case R.id.dexterity_label:
                addSimpleTooltip(this, v, tooltipTexts.get("DEX"), Gravity.BOTTOM);
                break;
            case R.id.constitution_label:
                addSimpleTooltip(this, v, tooltipTexts.get("CON"), Gravity.BOTTOM);
                break;
            case R.id.intelligence_label:
                addSimpleTooltip(this, v, tooltipTexts.get("INT"), Gravity.BOTTOM);
                break;
            case R.id.wisdom_label:
                addSimpleTooltip(this, v, tooltipTexts.get("WIS"), Gravity.BOTTOM);
                break;
            case R.id.charisma_label:
                addSimpleTooltip(this, v, tooltipTexts.get("CHA"), Gravity.BOTTOM);
                break;
            case R.id.stats_edit_back_page_btn:
                this.finish();
                break;
            case R.id.stats_edit_next_page_btn:
                Intent intent = new Intent(this, AbilityEditActivity.class);
                Bundle prevBundle = getIntent().getExtras();
                intent.putExtra("Selected Class", prevBundle.getString("Selected Class"));
                intent.putExtra("Selected Race", prevBundle.getString("Selected Race"));
                startActivity(intent);
        }

    }
}
