package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

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
        bindIconClickListeners();

        // Display initial tooltip
        TextView header = (TextView) findViewById(R.id.ability_score_header);
        new SimpleTooltip.Builder(getApplicationContext())
                .anchorView(header)
                .text("Assign your ability scores! Tap the ability icons or names to view more details.")
                .gravity(Gravity.BOTTOM)
                .build()
                .show();
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

    // Bind click listeners for every icon so that tooltips appear on click
    private void bindIconClickListeners() {
        int[] iconIds = {
                R.id.strength_icon,
                R.id.dexterity_icon,
                R.id.constitution_icon,
                R.id.intelligence_icon,
                R.id.wisdom_icon,
                R.id.charisma_icon
        };

        for (int iconId : iconIds) {
            ImageView iconImageView = (ImageView) findViewById(iconId);
            iconImageView.setOnClickListener(this);
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
                addSimpleTooltip(this, v, tooltipTexts.get("CHA"), Gravity.TOP);
                break;
            case R.id.strength_icon:
                addSimpleTooltip(this, v, tooltipTexts.get("STR"), Gravity.BOTTOM);
                break;
            case R.id.dexterity_icon:
                addSimpleTooltip(this, v, tooltipTexts.get("DEX"), Gravity.BOTTOM);
                break;
            case R.id.constitution_icon:
                addSimpleTooltip(this, v, tooltipTexts.get("CON"), Gravity.BOTTOM);
                break;
            case R.id.intelligence_icon:
                addSimpleTooltip(this, v, tooltipTexts.get("INT"), Gravity.BOTTOM);
                break;
            case R.id.wisdom_icon:
                addSimpleTooltip(this, v, tooltipTexts.get("WIS"), Gravity.BOTTOM);
                break;
            case R.id.charisma_icon:
                addSimpleTooltip(this, v, tooltipTexts.get("CHA"), Gravity.TOP);
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
