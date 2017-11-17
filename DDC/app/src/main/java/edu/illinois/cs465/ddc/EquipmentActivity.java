package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

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

        listView = (ExpandableListView) findViewById(R.id.ExpandaButton);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Light Armor");
        listDataHeader.add("Iron Dagger");
        listDataHeader.add("Long Bow");
        listDataHeader.add("Quiver");

        List<String> armorDesc = new ArrayList<>();
        armorDesc.add("this light armor grants you +2 AC and makes you the most desirable man on earth to all those babes. cause that's what we care about. imaginary babes.");

        List<String> daggerDesc = new ArrayList<>();
        daggerDesc.add("dagaggagaaga");
        daggerDesc.add("you can attack with this dagger twice in one turn");
        daggerDesc.add("it does 1d4 + DEX damage");

        List<String> lbDesc = new ArrayList<>();
        lbDesc.add("BOWWWWWwwwwww");
        lbDesc.add("this bow has disadvantage at <20ft range");
        lbDesc.add("when you crit with this bow, add an extra d6 on top of normal crit damage");

        List<String> qDesc = new ArrayList<>();
        qDesc.add("KwYvVvVVvVvVRrrr");
        qDesc.add("maximum capacity: 40 arrows");


        listHash.put(listDataHeader.get(0), armorDesc);
        listHash.put(listDataHeader.get(1), daggerDesc);
        listHash.put(listDataHeader.get(2), lbDesc);
        listHash.put(listDataHeader.get(3), qDesc);
    }
}