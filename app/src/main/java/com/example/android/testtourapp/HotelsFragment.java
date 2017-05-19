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
public class HotelsFragment extends Fragment {
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;

    public HotelsFragment() {
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
        ArrayList<Child> child6 = new ArrayList<Child>();
        ;

        // Initialize Strings
        String hotelRoyalDescription = (String) getText(R.string.hotel_royal_description);
        String hotelRoyalLink = (String) getText(R.string.hotel_royal_booking);
        String hotelVanvitelliDescription = (String) getText(R.string.hotel_vanvitelli_description);
        String hotelVanvitelliLink = (String) getText(R.string.hotel_vanvitelli_booking);
        String hotelCavalieriDescription = (String) getText(R.string.hotel_cavalieri_description);
        String hotelCavalieriLink = (String) getText(R.string.hotel_cavalieri_booking);
        String villaMariaCristinaDescription = (String) getText(R.string.hotel_villa_maria_cristina_description);
        String villaMariaCristinaLink = (String) getText(R.string.hotel_villa_maria_cristina_booking);
        String hotelBrumanDescription = (String) getText(R.string.hotel_bruman_description);
        String hotelBrumanLink = (String) getText(R.string.hotel_bruman_booking);
        String novotelDescription = (String) getText(R.string.hotel_novotel_description);
        String novotelLink = (String) getText(R.string.hotel_novotel_booking);

        // Get website link icon
        Drawable backgroundIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.bookinglogo, null);

        // Adding child data
        child1.add(new Child(R.drawable.hotelroyal1, R.drawable.hotelroyal2, R.drawable.hotelroyal3, R.drawable.hotelroyal4, hotelRoyalDescription, hotelRoyalLink, backgroundIcon));
        child2.add(new Child(R.drawable.hotelvanvitelli1, R.drawable.hotelvanvitelli2, R.drawable.hotelvanvitelli3, R.drawable.hotelvanvitelli4, hotelVanvitelliDescription, hotelVanvitelliLink, backgroundIcon));
        child3.add(new Child(R.drawable.hotelcavalieri1, R.drawable.hotelcavalieri2, R.drawable.hotelcavalieri3, R.drawable.hotelcavalieri4, hotelCavalieriDescription, hotelCavalieriLink, backgroundIcon));
        child4.add(new Child(R.drawable.villamariacristina1, R.drawable.villamariacristina2, R.drawable.villamariacristina3, R.drawable.villamariacristina4, villaMariaCristinaDescription, villaMariaCristinaLink, backgroundIcon));
        child5.add(new Child(R.drawable.hotelbruman1, R.drawable.hotelbruman2, R.drawable.hotelbruman3, R.drawable.hotelbruman4, hotelBrumanDescription, hotelBrumanLink, backgroundIcon));
        child6.add(new Child(R.drawable.hotelnovotel1, R.drawable.hotelnovotel2, R.drawable.hotelnovotel3, R.drawable.hotelnovotel4, novotelDescription, novotelLink, backgroundIcon));

        // Adding headers to list
        header.add(new Item("Hotel Royal", "Viale Vittorio Veneto 13, 81100 Caserta, Italy", "+39 0823 325222", R.drawable.hotelicon, child1));
        header.add(new Item("Gran Hotel Vanvitelli", "Viale Carlo III, 81020 Caserta, Italy", "+39 0823 217111", R.drawable.hotelicon, child2));
        header.add(new Item("Hotel dei Cavalieri", "Piazza Luigi Vanvitelli 12, 81100 Caserta, Italy", "+39 0823 355520", R.drawable.hotelicon, child3));
        header.add(new Item("Villa Maria Cristina", "Via Giulio Antonio Acquaviva 24, 81100 Caserta, Italy", "+39 0823 352538", R.drawable.hotelicon, child4));
        header.add(new Item("Hotel Bruman", "Via Roma 156, 81100 Caserta, Italy", "+39 0823 353266", R.drawable.hotelicon, child5));
        header.add(new Item("Novotel", "S.S. 87 Sannitica Km 22.600, 81020 Caserta, Italy", "+39 0823 826553", R.drawable.hotelicon, child6));

        adapter = new ExpandableListAdapter(getActivity(), header);

        // Setting adapter over expandableListView
        expandableListView.setAdapter(adapter);
    }

    // Setting different listeners to expandablelistview
    void setListener() {

        // This listener will show toast on group click
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

