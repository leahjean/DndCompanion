package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CharacterMainScreenActivity extends Activity implements View.OnClickListener {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_main_screen);

        listView = (ExpandableListView) findViewById(R.id.msExpandaButton);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        ImageButton backbtn = findViewById(R.id.main_screen_backbtn);
        backbtn.setOnClickListener(this);

        // Initialize arc bubble
        ArcBubbleUtil.createArcBubble(this);
    }



    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("STR: +3");
        listDataHeader.add("CON: +1");
        listDataHeader.add("DEX: +1");
        listDataHeader.add("INT: -1");
        listDataHeader.add("WIS: +0");
        listDataHeader.add("CHA: +0");

        List<String> strDesc = new ArrayList<>();
        strDesc.add("Athletics [Prof]");

        List<String> conDesc = new ArrayList<>();
        conDesc.add("None");

        List<String> dexDesc = new ArrayList<>();
        dexDesc.add("Acrobatics");
        dexDesc.add("Sleight of Hand");
        dexDesc.add("Stealth");

        List<String> intDesc = new ArrayList<>();
        intDesc.add("Arcana");
        intDesc.add("History");
        intDesc.add("Investigation");
        intDesc.add("Nature");
        intDesc.add("Religion");

        List<String> wisDesc = new ArrayList<>();
        wisDesc.add("Animal Handling");
        wisDesc.add("Insight");
        wisDesc.add("Medicine");
        wisDesc.add("Perception");
        wisDesc.add("Survival [Prof]");

        List<String> chaDesc = new ArrayList<>();
        chaDesc.add("Deception");
        chaDesc.add("Intimidation [Prof]");
        chaDesc.add("Performance");
        chaDesc.add("Persuasion");

        listHash.put(listDataHeader.get(0), strDesc);
        listHash.put(listDataHeader.get(1), conDesc);
        listHash.put(listDataHeader.get(2), dexDesc);
        listHash.put(listDataHeader.get(3), intDesc);
        listHash.put(listDataHeader.get(4), wisDesc);
        listHash.put(listDataHeader.get(5), chaDesc);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_screen_backbtn:
                this.finish();
                break;
        }
    }
}