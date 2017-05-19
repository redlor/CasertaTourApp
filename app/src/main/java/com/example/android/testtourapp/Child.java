package com.example.android.testtourapp;

import android.graphics.drawable.Drawable;


// Public class for custom child item
public class Child {
    private String mDescription;
    private String mLink;
    private int mImage1, mImage2, mImage3, mImage4;
    private Drawable mBackgroundIcon;

    /**
     * Create a new Child object.
     */
    public Child(int image1, int image2, int image3, int image4, String description, String link, Drawable backgroundIcon) {
        mImage1 = image1;
        mImage2 = image2;
        mImage3 = image3;
        mImage4 = image4;
        mDescription = description;
        mLink = link;
        mBackgroundIcon = backgroundIcon;
    }

    // Getters methods for components of the child item
    public String getDescription() {
        return mDescription;
    }

    public String getLink() {
        return mLink;
    }

    public int getImage1() {
        return mImage1;
    }

    public int getImage2() {
        return mImage2;
    }

    public int getImage3() {
        return mImage3;
    }

    public int getImage4() {
        return mImage4;
    }

    public Drawable getBackgroundIcon() {
        return mBackgroundIcon;
    }


}

