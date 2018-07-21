package android.cadi.desserttestapp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class HomePagerAdapter extends FragmentPagerAdapter {
    public FragmentManager mFragmentManager;
    private int nowPosition;

    public HomePagerAdapter(android.support.v4.app.FragmentManager manager) {
        super(manager);
        mFragmentManager = manager;
    }

    @Override
    public Fragment getItem(int position) {
        nowPosition = position;
        switch (position) {
            case 0:
                return HomeFragment.newInstance();
            default:
                return HomeFragment.newInstance();

        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "홈";
            case 1:
                return "랭킹";
            case 2:
                return "소식";
            case 3:
                return "마이페이지";
                default:
                    return null;
        }

//        return super.getPageTitle(position);
    }
}
