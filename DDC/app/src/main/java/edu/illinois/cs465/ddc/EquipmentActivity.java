package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EquipmentActivity extends Activity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);

        listView = (ExpandableListView) findViewById(R.id.equipmentExpandaButton);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        // Initialize arc bubble
        ArcBubbleUtil.createArcBubble(this);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Leather Armor");
        listDataHeader.add("Iron Dagger");
        listDataHeader.add("Long Bow");
        listDataHeader.add("Quiver");

        List<String> armorDesc = new ArrayList<>();
        armorDesc.add("This medium armor grants you +2 AC");

        List<String> daggerDesc = new ArrayList<>();
        daggerDesc.add("1d4 + DEX damage");
        daggerDesc.add("You can attack with this dagger twice in one turn");

        List<String> lbDesc = new ArrayList<>();
        lbDesc.add("300ft range, disadvantage within 20ft");
        lbDesc.add("1d8 + DEX damage");
        lbDesc.add("When you crit with this bow, add an extra d6 on top of normal crit damage");

        List<String> qDesc = new ArrayList<>();
        qDesc.add("Maximum capacity: 40 arrows");

        listHash.put(listDataHeader.get(0), armorDesc);
        listHash.put(listDataHeader.get(1), daggerDesc);
        listHash.put(listDataHeader.get(2), lbDesc);
        listHash.put(listDataHeader.get(3), qDesc);
    }
}