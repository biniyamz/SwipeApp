package com.example.root.swipeapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.view.Gravity;

import java.util.List;

/**
 * Created by root on 11/11/15.
 */
public class AlbumGridPagerAdapter extends FragmentGridPagerAdapter {



    private static final float MAXIMUM_CARD_EXPANSION_FACTOR = 3.0f;

    private Context mContext;
    private List<MainActivity.AlbumList> mData;

    public AlbumGridPagerAdapter(Context context, List<MainActivity.AlbumList> AlbumLists, FragmentManager fm) {
        super(fm);
        mContext = context;
        mData = AlbumLists;
    }

    @Override
    public Fragment getFragment(int row, int column) {
        MainActivity.AlbumList AlbumList = mData.get(row);
        CardFragment fragment = CardFragment.create(AlbumList.getTitle(column), AlbumList.getText(column));
        fragment.setCardGravity(Gravity.BOTTOM);
        fragment.setExpansionEnabled(true);
        fragment.setExpansionDirection(CardFragment.EXPAND_DOWN);
        fragment.setExpansionFactor(MAXIMUM_CARD_EXPANSION_FACTOR);
        return fragment;
    }

    @Override
    public int getRowCount() {
        return mData.size();
    }

    @Override
    public int getColumnCount(int row) {
        return mData.get(row).getPageCount();
    }

    @Override
    public Drawable getBackgroundForRow(int row) {
        return mContext.getResources().getDrawable(mData.get(row).getImageResource());
    }
}
