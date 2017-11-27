package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SuppliesActivity extends Activity {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplies);

        listView = (ExpandableListView) findViewById(R.id.suppliesExpandaButton);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        // Initialize click listener for the back button
        ImageButton headerBackBtn = (ImageButton) findViewById(R.id.suppliesBackBtn);
        headerBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Initialize arc bubble
        ArcBubbleUtil.createArcBubble(this);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Rations (x16)");
        listDataHeader.add("Potion of Major Healing");
        listDataHeader.add("Silken Rope (50ft)");
        listDataHeader.add("Hand Mirror");

        List<String> rationDesc = new ArrayList<>();
        rationDesc.add("Enough food for a one-person meal.");
        rationDesc.add("This won't stay fresh for long!");

        List<String> potionDesc = new ArrayList<>();
        potionDesc.add("Heals 3d10 + 6 damage");
        potionDesc.add("Contains a sweet-smelling viscous red liquid");

        List<String> ropeDesc = new ArrayList<>();
        ropeDesc.add("Strong enough to hold 500 lbs, and easy on the hands too");

        List<String> mirrorDesc = new ArrayList<>();
        mirrorDesc.add("Useful for seeing around corners or reflecting light");

        listHash.put(listDataHeader.get(0), rationDesc);
        listHash.put(listDataHeader.get(1), potionDesc);
        listHash.put(listDataHeader.get(2), ropeDesc);
        listHash.put(listDataHeader.get(3), mirrorDesc);
    }
}
