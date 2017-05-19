package com.example.android.testtourapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TourFragmentPagerAdapter extends FragmentPagerAdapter {

    /**
     * Provides the appropriate {@link Fragment} for a view pager.
     */
    private Context mContext;

    public TourFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MonumentsFragment();
        } else if (position == 1) {
            return new RestaurantsFragment();
        } else if (position == 2) {
            return new HotelsFragment();
        } else {
            return new ShoppingFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.monuments_fragment);
        } else if (position == 1) {
            return mContext.getString(R.string.restaurants_fragment);
        } else if (position == 2) {
            return mContext.getString((R.string.hotels_fragment));
        } else {
            return mContext.getString((R.string.shopping_fragment));
        }
    }

}
