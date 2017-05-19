package com.example.android.testtourapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


//For expandable list view use BaseExpandableListAdapter
public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private ArrayList<Item> header;

    /**
     * Create a new  Adapter object.
     *
     * @param context        is the current context (i.e. Activity) that the adapter is being created in.
     * @param listDataHeader is the list of {@link Item}s to be displayed.
     */
    public ExpandableListAdapter(Context context, ArrayList<Item> listDataHeader) {
        this._context = context;
        this.header = listDataHeader;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // This will return the child
        ArrayList<Child> childrenList = this.header.get(groupPosition).getChildrenList();
        return childrenList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        Child child = (Child) getChild(groupPosition, childPosition);

        // Inflating child layout and setting textview
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child, parent, false);
        }
        // Getting images in the horizontal Scroll View and setting them.
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image1);
        imageView.setImageResource(child.getImage1());
        ImageView imageView2 = (ImageView) convertView.findViewById(R.id.image2);
        imageView2.setImageResource(child.getImage2());
        ImageView imageView3 = (ImageView) convertView.findViewById(R.id.image3);
        imageView3.setImageResource(child.getImage3());
        ImageView imageView4 = (ImageView) convertView.findViewById(R.id.image4);
        imageView4.setImageResource(child.getImage4());

        // Getting Child text and icon (website link), and setting into the TextViews
        TextView childText = (TextView) convertView.findViewById(R.id.child);
        childText.setText(child.getDescription().trim());
        Button childLink = (Button) convertView.findViewById((R.id.child2));
        childLink.setText((child.getLink().trim()));
        childLink.setBackground(child.getBackgroundIcon());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        // return children count
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {

        // Get header position
        return this.header.get(groupPosition);
    }

    @Override
    public int getGroupCount() {

        // Get header size
        return this.header.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        Item currentItem = (Item) getGroup(groupPosition);

        // Inflating header layout and setting text
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.header, parent, false);
        }
        // Getting and setting header title
        TextView header_text = (TextView) convertView.findViewById(R.id.header);
        header_text.setText(currentItem.getTitle());

        // Getting and setting header image
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        imageView.setImageResource(currentItem.getImageResourceId());

        // Getting and setting address
        TextView address = (TextView) convertView.findViewById(R.id.address);
        ImageView addressIcon = (ImageView) convertView.findViewById(R.id.address_icon);

        // Getting and setting phone number
        TextView phoneNumber = (TextView) convertView.findViewById(R.id.phone_number);
        ImageView phoneIcon = (ImageView) convertView.findViewById(R.id.phone_icon);
        phoneNumber.setText(currentItem.getPhoneNumber());

        // Check if the header has or not address
        if (currentItem.hasAddress()) {
            address.setText(currentItem.getAddress());
            address.setVisibility(View.VISIBLE);
            addressIcon.setVisibility(View.VISIBLE);
        } else {
            address.setVisibility(View.GONE);
            addressIcon.setVisibility(View.GONE);
        }

        // Check if the header has or not phone number
        if (currentItem.hasPhoneNumber()) {
            phoneNumber.setText(currentItem.getPhoneNumber());
            phoneNumber.setVisibility(View.VISIBLE);
            phoneIcon.setVisibility(View.VISIBLE);
        } else {
            phoneNumber.setVisibility(View.GONE);
            phoneIcon.setVisibility(View.GONE);
        }

        // If group is expanded then change the text into bold and change the
        // icon
        if (isExpanded) {
            header_text.setTypeface(null, Typeface.BOLD);
            header_text.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    R.drawable.ic_up, 0);
        } else {
            // If group is not expanded then change the text back into normal
            // and change the icon

            header_text.setTypeface(null, Typeface.NORMAL);
            header_text.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    R.drawable.ic_down, 0);
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
