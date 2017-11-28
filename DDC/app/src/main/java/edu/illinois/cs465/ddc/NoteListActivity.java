package edu.illinois.cs465.ddc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.OverScroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kejij on 11/25/2017.
 */

public class NoteListActivity extends Activity {
    private ExpandableListView notesListView;
    private ExpandableListAdapter notesListAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash = new HashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        notesListView = (ExpandableListView) findViewById(R.id.NotesExpandaButton);
        initHeaders();
        populateHeaders();
        initChildClickListener();
        notesListAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        notesListView.setAdapter(notesListAdapter);

        // Initialize click listener for the back button
        ImageButton headerBackBtn = (ImageButton) findViewById(R.id.notesHeaderBackBtn);
        headerBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Initialize arc bubble
        ArcBubbleUtil.createArcBubble(this);
    }

    // Initialize headers for each note category
    private void initHeaders() {
        listDataHeader = new ArrayList<>(Arrays.asList(
                "Magical Items",
                "Events",
                "Fantastic Beasts",
                "Character Nuances",
                "List of My Favorite DMs"
        ));
    }

    // Populate each header with a list of elements
    private void populateHeaders() {
        // Magical Items
        listHash.put(listDataHeader.get(0), new ArrayList<>(Arrays.asList(
                "Fey Wand",
                "Gregoth Hammer",
                "Bailean Arms",
                "Red Shirt"
        )));

        // Events
        listHash.put(listDataHeader.get(1), new ArrayList<>(Arrays.asList(
                "I ate an apple yesterday",
                "I found a red shirt yesterday with stretched out sleeves",
                "You think this mockup will get us an A?"
        )));

        // Fantastic Beasts
        listHash.put(listDataHeader.get(2), new ArrayList<>(Arrays.asList(
                "Kenku = Loser",
                "Gregothians"
        )));

        // Character Nuances
        listHash.put(listDataHeader.get(3), new ArrayList<>(Arrays.asList(
                "Would only go to Africa if they had no legs",
                "Enjoys lying on chairs"
        )));

        // List of My Favorite DMs
        listHash.put(listDataHeader.get(4), new ArrayList<>(Arrays.asList(
                "Greg"
        )));
    }

    // Add event listener to children of the listView so that notes page is brought up on click
    private void initChildClickListener() {
        notesListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent,
                                        View v, int groupPosition, int childPosition, long id) {
                List<String> groupMsgs = listHash.get(listDataHeader.get(groupPosition));
                String noteMsg = "";
                if (groupMsgs != null && !groupMsgs.isEmpty()) {
                    noteMsg = groupMsgs.get(childPosition);
                }

                Intent noteIntent = new Intent(getApplicationContext(), NoteActivity.class);
                noteIntent.putExtra("Note Msg", noteMsg);
                startActivity(noteIntent);
                return false;
            }
        });
    }
}
