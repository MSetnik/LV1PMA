package com.example.lv1.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.lv1.Fragment.PersonalInfoFragment;
import com.example.lv1.Fragment.StudentInfoFragment;
import com.example.lv1.Fragment.SummaryFragment;

public class ViewPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return new PersonalInfoFragment();

            case 1:
                return new StudentInfoFragment();

            case 2:
                return new SummaryFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
