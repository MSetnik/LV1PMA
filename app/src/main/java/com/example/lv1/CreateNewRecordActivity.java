package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.lv1.Adapter.ViewPagerAdapter;
import com.example.lv1.Fragment.PersonalInfoFragment;
import com.example.lv1.Fragment.StudentInfoFragment;
import com.example.lv1.Fragment.SummaryFragment;

public class CreateNewRecordActivity extends AppCompatActivity implements PersonalInfoFragment.PersonalInfoListener, StudentInfoFragment.StudentInfoListener  {

    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
    }


    public static void setCurrentItem (int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void GetPersonalInfo(String ime, String prezime, String datumRodenja) {
        String tag = "android:switcher:" + R.id.viewpager + ":" + 2;
        SummaryFragment fragment = (SummaryFragment) getSupportFragmentManager().findFragmentByTag(tag);
        fragment.GetPersonalInfo(ime, prezime, datumRodenja);
    }

    @Override
    public void GetStudentInfo(String predmet, String profesor, String godina, String predavanja, String vjezbe) {
        String tag = "android:switcher:" + R.id.viewpager + ":" + 2;
        SummaryFragment fragment = (SummaryFragment) getSupportFragmentManager().findFragmentByTag(tag);
        fragment.GetStudentInfo(predmet, profesor, godina, predavanja, vjezbe);
    }
}
