package edu.illinois.cs465.ddc;

import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Greg on 11/27/2017.
 */

public class AbilityTab extends Fragment {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private List<Integer> listDataImages;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.fragment_ability_tab, container, false);

        listView = (ExpandableListView) myview.findViewById(R.id.combatAbilitiesExpandaButton);
        initData();
        listAdapter = new ExpandableListAdapter(myview.getContext(), listDataHeader, listHash, listDataImages);
        listView.setAdapter(listAdapter);

        return myview;
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listDataImages = new ArrayList<>();

        listDataImages.add(R.drawable.fireball);
        listDataImages.add(R.drawable.lightning);
        listDataImages.add(R.drawable.dimensiondoor);
        listDataImages.add(R.drawable.magicmissile);
        listDataImages.add(R.drawable.plantgrowth);
        listDataImages.add(R.drawable.sparkles);
        listDataImages.add(R.drawable.massheal);

        listDataHeader.add("Fireball");
        listDataHeader.add("Electrocute");
        listDataHeader.add("Dimension Door");
        listDataHeader.add("Magic Missile");
        listDataHeader.add("Plant Growth");
        listDataHeader.add("Animate Objects");
        listDataHeader.add("Mass Heal");

        List<String> fireballDesc = new ArrayList<>();
        fireballDesc.add("Level 3 spell");
        fireballDesc.add("120ft range");
        fireballDesc.add("8d6 fire damage in a 20ft radius");

        List<String> elecDesc = new ArrayList<>();
        elecDesc.add("Level 4 spell");
        elecDesc.add("100ft range");
        elecDesc.add("8d6 lightning damage in a 100ft by 5ft line");

        List<String> ddDesc = new ArrayList<>();
        ddDesc.add("Level 5 spell");
        ddDesc.add("500ft range");
        ddDesc.add("Teleport to a specified location up to 500ft away");

        List<String> mmDesc = new ArrayList<>();
        mmDesc.add("Level 1 spell");
        mmDesc.add("60ft range");
        mmDesc.add("Fire 3 bolts of arcane energy, dealing 1d4 damage each");
        mmDesc.add("Cannot miss");

        List<String> pgDesc = new ArrayList<>();
        pgDesc.add("Level 1 spell");
        pgDesc.add("Cause plants within 100ft to grow wildly");

        List<String> aoDesc = new ArrayList<>();
        aoDesc.add("Level 5 spell");
        aoDesc.add("Animate up to 10 objects of size \"medium\" or smaller");

        List<String> mhDesc = new ArrayList<>();
        mhDesc.add("Level 9 spell");
        mhDesc.add("120ft range");
        mhDesc.add("Heal all allies within 120ft for 10d8 health");

        listHash.put(listDataHeader.get(0), fireballDesc);
        listHash.put(listDataHeader.get(1), elecDesc);
        listHash.put(listDataHeader.get(2), ddDesc);
        listHash.put(listDataHeader.get(3), mmDesc);
        listHash.put(listDataHeader.get(4), pgDesc);
        listHash.put(listDataHeader.get(5), aoDesc);
        listHash.put(listDataHeader.get(6), mhDesc);
    }
}