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
        armorDesc.add("this light armor grants you +2 AC");

        List<String> daggerDesc = new ArrayList<>();
        daggerDesc.add("dagaggagaaga");

        List<String> lbDesc = new ArrayList<>();
        daggerDesc.add("BOWWWWWwwwwww");

        List<String> qDesc = new ArrayList<>();
        daggerDesc.add("KwYvVvVVvVvVRrrr");


        listHash.put(listDataHeader.get(0), armorDesc);
        listHash.put(listDataHeader.get(1), daggerDesc);
        listHash.put(listDataHeader.get(2), lbDesc);
        listHash.put(listDataHeader.get(3), qDesc);
    }
}