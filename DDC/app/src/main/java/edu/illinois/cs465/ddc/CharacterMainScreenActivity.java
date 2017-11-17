package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CharacterMainScreenActivity extends Activity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        listView = (ExpandableListView) findViewById(R.id.ExpandaButton);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("STR");
        listDataHeader.add("CON");
        listDataHeader.add("DEX");
        listDataHeader.add("INT");
        listDataHeader.add("WIS");
        listDataHeader.add("CHA");

        List<String> strDesc = new ArrayList<>();
        strDesc.add("Athletics");

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
        wisDesc.add("Survival");

        List<String> chaDesc = new ArrayList<>();
        chaDesc.add("Deception");
        chaDesc.add("Intimidation");
        chaDesc.add("Performance");
        chaDesc.add("Persuasion");

        listHash.put(listDataHeader.get(0), strDesc);
        listHash.put(listDataHeader.get(1), conDesc);
        listHash.put(listDataHeader.get(2), dexDesc);
        listHash.put(listDataHeader.get(3), intDesc);
        listHash.put(listDataHeader.get(4), wisDesc);
        listHash.put(listDataHeader.get(5), chaDesc);
    }
}