package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.IntegerRes;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

import static edu.illinois.cs465.ddc.GeneralUtil.addSimpleTooltip;
import static edu.illinois.cs465.ddc.GeneralUtil.tooltipTexts;

/**
 * Character Creation screen to edit initial abilities
 */
public class AbilityEditActivity extends Activity implements View.OnClickListener{
    private Set<Integer> selectedSkills = new HashSet<>();
    Integer maxSkillCount = 4;
    Integer remainingSkillCount;
    TextView remainingSkillCountView;
    private Set<Integer> checkBoxIdsSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ability_edit);

        Button next_button, back_button;
        next_button = (Button) findViewById(R.id.stats_edit_next_page_btn);
        next_button.setOnClickListener(this);
        back_button = (Button) findViewById(R.id.stats_edit_back_page_btn);
        back_button.setOnClickListener(this);

        initRemainingSkillCount();
        bindLabelClickListeners();
        bindCheckboxClickListeners();

        // Display initial tooltip
        TextView header = (TextView) findViewById(R.id.skill_proficiencies_header);
        new SimpleTooltip.Builder(getApplicationContext())
                .anchorView(header)
                .text("Select the skills you'd like to be proficient in! Tap the skill names to view more details.")
                .gravity(Gravity.BOTTOM)
                .build()
                .show();
    }

    // Initialize remaining skill count
    private void initRemainingSkillCount() {
        remainingSkillCountView = (TextView) findViewById(R.id.remaining_skill_count);
        remainingSkillCount = maxSkillCount;
        updateRemainingSkillCountMsg();
    }

    // Decrement the remaining skill count when a skill is selected
    private void decrementRemainingSkillCount() {
        remainingSkillCount -= 1;
        updateRemainingSkillCountMsg();
    }

    // Increment the remaining skill count when a skill is selected
    private void incrementRemainingSkillCount() {
        remainingSkillCount += 1;
        updateRemainingSkillCountMsg();
    }

    // Update the remaining skills message on load, decrement, or increment
    private void updateRemainingSkillCountMsg() {
        String msg = "Select: " + Integer.toString(remainingSkillCount);
        remainingSkillCountView.setText(msg);
    }

    // Bind click listeners for every label so that tooltips appear on click
    private void bindLabelClickListeners() {
        Integer[] labelIds = {
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

    // Bind click listeners for every checkbox so that tooltips appear on click
    private void bindCheckboxClickListeners() {
        Integer[] checkboxIds = {
                R.id.athletics_checkbox,
                R.id.acrobatics_checkbox,
                R.id.sleight_of_hand_checkbox,
                R.id.stealth_checkbox,
                R.id.arcana_checkbox,
                R.id.history_checkbox,
                R.id.investigation_checkbox,
                R.id.nature_checkbox,
                R.id.religion_checkbox,
                R.id.animal_handling_checkbox,
                R.id.insight_checkbox,
                R.id.medicine_checkbox,
                R.id.perception_checkbox,
                R.id.survival_checkbox,
                R.id.deception_checkbox,
                R.id.intimidation_checkbox,
                R.id.performance_checkbox,
                R.id.persuasion_checkbox
        };

        checkBoxIdsSet = new HashSet<Integer>(Arrays.asList(checkboxIds));

        for (int checkboxId : checkboxIds) {
            CheckBox checkbox = (CheckBox) findViewById(checkboxId);
            checkbox.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Integer viewId = v.getId();
//        if (checkBoxIdsSet.contains(viewId)) {
//            if (selectedSkills.contains(viewId)) {
//                incrementRemainingSkillCount();
//                selectedSkills.remove(viewId);
//            } else {
//                if (selectedSkills.size() < maxSkillCount) {
//                    decrementRemainingSkillCount();
//                    selectedSkills.add(viewId);
//                }
//            }
//
//            if (selectedSkills.size() == maxSkillCount) {
//                for (Integer id : checkBoxIdsSet) {
//
//                }
//            }
//        }

        switch (viewId){
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
