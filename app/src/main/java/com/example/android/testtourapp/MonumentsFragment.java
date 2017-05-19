package com.example.android.testtourapp;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonumentsFragment extends Fragment {
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;

    public MonumentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);


        expandableListView = (ExpandableListView) rootView.findViewById(R.id.simple_expandable_listview);

        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);

        setItems();
        setListener();

        return rootView;

    }

    // Setting headers and childs to expandable listview
    void setItems() {

        // Array list for header
        ArrayList<Item> header = new ArrayList<Item>();

        // Array list for child items
        ArrayList<Child> child1 = new ArrayList<Child>();
        ArrayList<Child> child2 = new ArrayList<Child>();
        ArrayList<Child> child3 = new ArrayList<Child>();

        // Initialize Strings
        String royalPalaceDescription = (String) getText(R.string.royal_palace_description);
        String royalPalaceLink = (String) getText(R.string.royal_palace_website);
        String sanLeucioDescription = (String) getText(R.string.san_leucio_description);
        String sanLeucioLink = (String) getText(R.string.san_leucio_website);
        String casertavecchiaDescription = (String) getText(R.string.casertavecchia_description);
        String casertavecchiaLink = (String) getText(R.string.casertavecchia_website);

        // Get website link icon
        Drawable backgroundIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.worldicon, null);

        // Adding child data
        child1.add(new Child(R.drawable.reggia, R.drawable.reggia_stairs, R.drawable.hall, R.drawable.englishgarden, royalPalaceDescription, royalPalaceLink, backgroundIcon));
        child2.add(new Child(R.drawable.sanleucio, R.drawable.sanleucioday, R.drawable.sanleuciosilk, R.drawable.sanleucionight, sanLeucioDescription, sanLeucioLink, backgroundIcon));
        child3.add(new Child(R.drawable.casertavecchiahigh, R.drawable.casertavecchiacathedral, R.drawable.casertavecchiastreet, R.drawable.casertavecchianight, casertavecchiaDescription, casertavecchiaLink, backgroundIcon));

        // Adding headers to list
        header.add(new Item("Royal Palace", R.drawable.monumenticon, child1));
        header.add(new Item("San Leucio Complex", R.drawable.monumenticon, child2));
        header.add(new Item("Casertavecchia", R.drawable.monumenticon, child3));

        adapter = new ExpandableListAdapter(getActivity(), header);

        // Setting adapter over expandableListView
        expandableListView.setAdapter(adapter);
    }

    // Setting different listeners to expandableListView
    void setListener() {

        expandableListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {
                return false;
            }
        });

        // This listener will expand one group at one time
        // You can remove this listener for expanding all groups
        expandableListView
                .setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                    // Default position
                    int previousGroup = -1;

                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if (groupPosition != previousGroup)

                            // Collapse the expanded group
                            expandableListView.collapseGroup(previousGroup);
                        previousGroup = groupPosition;
                    }

                });

        expandableListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView listview, View view,
                                        int groupPos, int childPos, long id) {
                return false;
            }
        });


    }

}




