package com.example.scorex;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomeScreenAdpater extends FragmentPagerAdapter {
    private Context context;

    public HomeScreenAdpater(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new GamesFragment();
        else
            return new PastGamesFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return context.getString(R.string.tab_text_1);
        else
            return context.getString(R.string.tab_text_2);

    }

    @Override
    public int getCount() {
        return 2;
    }
}
