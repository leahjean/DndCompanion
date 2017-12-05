package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static edu.illinois.cs465.ddc.GeneralUtil.addSimpleTooltip;
import static edu.illinois.cs465.ddc.GeneralUtil.addSimpleTooltipListener;
import static edu.illinois.cs465.ddc.GeneralUtil.tooltipTexts;

/**
 * Character Creation screen to edit initial abilities
 */
public class AbilityEditActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ability_edit);

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
                R.id.athletics_label,
                R.id.acrobatics_label,
                R.id.sleight_of_hand_label,
                R.id.stealth_label,
                R.id.arcana_label,
                R.id.history_label,
                R.id.investigation_label,
                R.id.nature_label,
                R.id.religion_label,
                R.id.animal_handling_label,
                R.id.insight_label,
                R.id.medicine_label,
                R.id.perception_label,
                R.id.survival_label,
                R.id.deception_label,
                R.id.intimidation_label,
                R.id.performance_label,
                R.id.persuasion_label
        };

        for (int labelId : labelIds) {
            TextView labelTextView = (TextView) findViewById(labelId);
            labelTextView.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.athletics_label:
                addSimpleTooltip(this, v, tooltipTexts.get("athletics"), Gravity.BOTTOM);
                break;
            case R.id.acrobatics_label:
                addSimpleTooltip(this, v, tooltipTexts.get("acrobatics"), Gravity.BOTTOM);
                break;
            case R.id.sleight_of_hand_label:
                addSimpleTooltip(this, v, tooltipTexts.get("sleight of hand"), Gravity.BOTTOM);
                break;
            case R.id.stealth_label:
                addSimpleTooltip(this, v, tooltipTexts.get("stealth"), Gravity.BOTTOM);
                break;
            case R.id.arcana_label:
                addSimpleTooltip(this, v, tooltipTexts.get("arcana"), Gravity.BOTTOM);
                break;
            case R.id.history_label:
                addSimpleTooltip(this, v, tooltipTexts.get("history"), Gravity.BOTTOM);
                break;
            case R.id.investigation_label:
                addSimpleTooltip(this, v, tooltipTexts.get("investigation"), Gravity.BOTTOM);
                break;
            case R.id.nature_label:
                addSimpleTooltip(this, v, tooltipTexts.get("nature"), Gravity.BOTTOM);
                break;
            case R.id.religion_label:
                addSimpleTooltip(this, v, tooltipTexts.get("religion"), Gravity.BOTTOM);
                break;
            case R.id.animal_handling_label:
                addSimpleTooltip(this, v, tooltipTexts.get("animal handling"), Gravity.BOTTOM);
                break;
            case R.id.insight_label:
                addSimpleTooltip(this, v, tooltipTexts.get("insight"), Gravity.BOTTOM);
                break;
            case R.id.medicine_label:
                addSimpleTooltip(this, v, tooltipTexts.get("medicine"), Gravity.BOTTOM);
                break;
            case R.id.perception_label:
                addSimpleTooltip(this, v, tooltipTexts.get("perception"), Gravity.BOTTOM);
                break;
            case R.id.survival_label:
                addSimpleTooltip(this, v, tooltipTexts.get("survival"), Gravity.BOTTOM);
                break;
            case R.id.deception_label:
                addSimpleTooltip(this, v, tooltipTexts.get("deception"), Gravity.BOTTOM);
                break;
            case R.id.intimidation_label:
                addSimpleTooltip(this, v, tooltipTexts.get("intimidation"), Gravity.BOTTOM);
                break;
            case R.id.performance_label:
                addSimpleTooltip(this, v, tooltipTexts.get("performance"), Gravity.BOTTOM);
                break;
            case R.id.persuasion_label:
                addSimpleTooltip(this, v, tooltipTexts.get("persuasion"), Gravity.BOTTOM);
                break;
            case R.id.stats_edit_back_page_btn:
                this.finish();
                break;
            case R.id.stats_edit_next_page_btn:
                Intent intent = new Intent(this, CharBackgroundActivity.class);
                Bundle prevBundle = getIntent().getExtras();
                intent.putExtra("Selected Class", prevBundle.getString("Selected Class"));
                intent.putExtra("Selected Race", prevBundle.getString("Selected Race"));
                startActivity(intent);
        }

    }
}
