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
public class RestaurantsFragment extends Fragment {
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;

    public RestaurantsFragment() {
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
        ArrayList<Child> child7 = new ArrayList<Child>();
        ArrayList<Child> child8 = new ArrayList<Child>();
        ArrayList<Child> child9 = new ArrayList<Child>();
        ArrayList<Child> child10 = new ArrayList<Child>();

        // Initialize Strings
        String pataPanDescription = (String) getText(R.string.pata_pan_description);
        String pataPanLink = (String) getText(R.string.pata_pan_tripadvisor);
        String ilCantuccioDescription = (String) getText(R.string.il_cantuccio_description);
        String ilCantuccioLink = (String) getText(R.string.il_cantuccio_tripadvisor);
        String iMasanielliDescription = (String) getText(R.string.i_masanielli_description);
        String iMasanielliLink = (String) getText(R.string.i_masanielli_tripadvisor);
        String meburgerDescription = (String) getText(R.string.meburger_description);
        String meburgerLink = (String) getText(R.string.meburger_tripadvisor);
        String vignaReDescription = (String) getText(R.string.vigna_re_description);
        String vignaReLink = (String) getText(R.string.vigna_re_tripadvisor);
        String guggenheimDescription = (String) getText(R.string.guggenheim_description);
        String guggenheimLink = (String) getText(R.string.guggenheim_tripadvisor);
        String sanCarloDescription = (String) getText(R.string.san_carlo_description);
        String sanCarloLink = (String) getText(R.string.san_carlo_tripadvisor);
        String iMasanielliMartucciDescription = (String) getText(R.string.i_masanielli_martucci_description);
        String iMasanielliMartucciLink = (String) getText(R.string.i_masanielli_martucci_tripadvisor);
        String oTianielloDescription = (String) getText(R.string.o_tianiello_description);
        String otianielloLink = (String) getText(R.string.o_tianiello_tripadvisor);
        String hostariaMassaDescription = (String) getText(R.string.hostaria_massa_description);
        String hostariaMassaLink = (String) getText(R.string.hostaria_massa_tripadvisor);

        // Get website link icon
        Drawable backgroundIcon = ResourcesCompat.getDrawable(getResources(), R.drawable.tripadvisoricon, null);

        // Adding child data
        child1.add(new Child(R.drawable.patapan1, R.drawable.patapan2, R.drawable.patapan3, R.drawable.patapan4, pataPanDescription, pataPanLink, backgroundIcon));
        child2.add(new Child(R.drawable.ilcantuccio1, R.drawable.ilcantuccio2, R.drawable.ilcantuccio3, R.drawable.ilcantuccio4, ilCantuccioDescription, ilCantuccioLink, backgroundIcon));
        child3.add(new Child(R.drawable.imasanielli1, R.drawable.imasanielli2, R.drawable.imasanielli3, R.drawable.imasanielli4, iMasanielliDescription, iMasanielliLink, backgroundIcon));
        child4.add(new Child(R.drawable.meburger1, R.drawable.meburger2, R.drawable.meburger3, R.drawable.meburger4, meburgerDescription, meburgerLink, backgroundIcon));
        child5.add(new Child(R.drawable.vignare1, R.drawable.vignare2, R.drawable.vignare3, R.drawable.vignare4, vignaReDescription, vignaReLink, backgroundIcon));
        child6.add(new Child(R.drawable.guggenheim1, R.drawable.guggenheim2, R.drawable.guggenheim3, R.drawable.guggenheim4, guggenheimDescription, guggenheimLink, backgroundIcon));
        child7.add(new Child(R.drawable.sancarlo1, R.drawable.sancarlo2, R.drawable.sancarlo3, R.drawable.sancarlo4, sanCarloDescription, sanCarloLink, backgroundIcon));
        child8.add(new Child(R.drawable.imasaniellimartucci1, R.drawable.imasaniellimartucci2, R.drawable.imasaniellimartucci3, R.drawable.imasaniellimartucci4, iMasanielliMartucciDescription, iMasanielliMartucciLink, backgroundIcon));
        child9.add(new Child(R.drawable.otianiello1, R.drawable.otianiello2, R.drawable.otianiello3, R.drawable.otianiello4, oTianielloDescription, otianielloLink, backgroundIcon));
        child10.add(new Child(R.drawable.hostariamassa1, R.drawable.hostariamassa2, R.drawable.hostariamassa3, R.drawable.hostariamassa4, hostariaMassaDescription, hostariaMassaLink, backgroundIcon));

        // Adding headers to list
        header.add(new Item("Pata Pan", "Via Don Giovanni Bosco 6, 81100, Caserta, Italy", "+39 348 709 7948", R.drawable.plate, child1));
        header.add(new Item("Il Cantuccio Pub & Beer", "Via Raffaele Gasparri N 24, 81100, Caserta, Italy", "+39 377 684 6755", R.drawable.plate, child2));
        header.add(new Item("Pizzeria I Masanielli", "Viale Abraham Lincoln 29, 81100, Caserta, Italy", "+39 0823 154 0786", R.drawable.plate, child3));
        header.add(new Item("Meburger", "Via Giacomo Medici Bosco, 16/18, 81100, Caserta, Italy", "+39 0823 216392", R.drawable.plate, child4));
        header.add(new Item("Moderna Vineria Vigna Ré", "Via Antonio Planelli 8, 81100 San Leucio, Caserta, Italy", "+39 0823 304606", R.drawable.plate, child5));
        header.add(new Item("Guggenheim", "Via C. Golgi, 28, 81100, Caserta, Italy", "+39 333 316 5335", R.drawable.plate, child6));
        header.add(new Item("San Carlo Ristorante Pizzeria", "Via San Carlo 134/140, 81100, Caserta, Italy", "+39 0823 279005", R.drawable.plate, child7));
        header.add(new Item("I Masanielli", "Via Antonio Vivaldi 23, 81100, Caserta, Italy", "+39 0823 220092", R.drawable.plate, child8));
        header.add(new Item("O' Tianiello", "Via Giuseppe Verdi 86, 81100, Caserta, Italy", "+39 0823 441473", R.drawable.plate, child9));
        header.add(new Item("Antica Hostaria Massa", "Via Giuseppe Mazzini 55, 81100, Caserta, Italy", "+39 0823 456527", R.drawable.plate, child10));

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


