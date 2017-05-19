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
public class ShoppingFragment extends Fragment {
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;

    public ShoppingFragment() {
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
        ArrayList<Child> child4 = new ArrayList<Child>();
        ArrayList<Child> child5 = new ArrayList<Child>();

        // Initialize Strings
        String viaMazziniDescription = (String) getText(R.string.via_mazzini_description);
        String casertaWebsiteLink = (String) getText(R.string.caserta_website);
        String corsoTriesteDescription = (String) getText(R.string.corso_trieste_description);
        String viaRomaDescription = (String) getText(R.string.via_roma_description);
        String centroCampaniaDescription = (String) getText(R.string.centro_campania_description);
        String centroCampaniaLink = (String) getText(R.string.centro_campania_website);
        String outletLaReggiaDescription = (String) getText(R.string.outlet_la_reggia_description);
        String outletLaReggiaLink = (String) getText(R.string.outlet_la_reggia_website);

        // Get website link icon
        Drawable backgroundIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.shoppingcentre, null);

        // Adding child data
        child1.add(new Child(R.drawable.viamazzini1, R.drawable.viamazzini2, R.drawable.viamazzini3, R.drawable.viamazzini4, viaMazziniDescription, casertaWebsiteLink, backgroundIcon));
        child2.add(new Child(R.drawable.corsotrieste1, R.drawable.corsotrieste2, R.drawable.corsotrieste3, R.drawable.corsotrieste4, corsoTriesteDescription, casertaWebsiteLink, backgroundIcon));
        child3.add(new Child(R.drawable.viaroma1, R.drawable.viaroma2, R.drawable.viaroma3, R.drawable.viaroma4, viaRomaDescription, casertaWebsiteLink, backgroundIcon));
        child4.add(new Child(R.drawable.campania1, R.drawable.campania2, R.drawable.campania3, R.drawable.campania4, centroCampaniaDescription, centroCampaniaLink, backgroundIcon));
        child5.add(new Child(R.drawable.outletlareggia1, R.drawable.outletlareggia2, R.drawable.outletlareggia3, R.drawable.outletlareggia4, outletLaReggiaDescription, outletLaReggiaLink, backgroundIcon));

        // Adding headers to list
        header.add(new Item("Via Mazzini", R.drawable.shoppingicon, child1));
        header.add(new Item("Corso Trieste", R.drawable.shoppingicon, child2));
        header.add(new Item("Via Roma", R.drawable.shoppingicon, child3));
        header.add(new Item("Shopping Center Campania", "Località Aurno 87, 81025 Marcianise, Italy", "+39 0823 696037", R.drawable.shoppingicon, child4));
        header.add(new Item("La Reggia Designer Outlet", "S.P. 336 Sannitica, 81025 Marcianise, Italy", "+39 0823 510244", R.drawable.shoppingicon, child5));

        adapter = new ExpandableListAdapter(getActivity(), header);

        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);
    }

    // Setting different listeners to expandablelistview
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
