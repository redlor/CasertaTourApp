package com.example.android.testtourapp;

import java.util.ArrayList;

public class Item {

    //** Constant value that represents no duration was provided for this item */
    private static final String NO_ADDRESS_PROVIDED = "None";
    //** Constant value that represents no phone number was provided for this item */
    private static final String NO_PHONE_NUMBER_PROVIDED = "None";
    private String mTitle;
    private String mAddress = NO_ADDRESS_PROVIDED;
    private String mPhoneNumber = NO_PHONE_NUMBER_PROVIDED;
    private int mImageResourceId;
    private ArrayList<Child> mChildrenList = new ArrayList<Child>();

    /**
     * Create a new Item object for headers.
     *
     * @param title           is the title f the header
     * @param imageResourceId is the image in the header
     * @param childrenList    is the custom class Child
     */
    public Item(String title, int imageResourceId, ArrayList<Child> childrenList) {
        mTitle = title;
        mImageResourceId = imageResourceId;
        mChildrenList = childrenList;
    }

    /**
     * Create a new Item object for headers.
     *
     * @param title           is the title f the header
     * @param imageResourceId is the image in the header
     * @param childrenList    is the custom class Child
     * @param address         is the address of the business
     * @param phoneNumber     is the phone number of the business
     */
    public Item(String title, String address, String phoneNumber, int imageResourceId, ArrayList<Child> childrenList) {
        mTitle = title;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        mImageResourceId = imageResourceId;
        mChildrenList = childrenList;
    }

    // Getting methods
    public String getTitle() {
        return mTitle;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }


    public boolean hasPhoneNumber() {
        return mPhoneNumber != NO_PHONE_NUMBER_PROVIDED;
    }

    public boolean hasAddress() {
        return mAddress != NO_ADDRESS_PROVIDED;
    }

    public ArrayList<Child> getChildrenList() {
        return mChildrenList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "mTitle='" + mTitle + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
