package com.shahjahan.tablayout274;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    TabLayout tablayout;

    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewPager2);


        viewPagerAdapter = new ViewPagerAdapter(MainActivity.this);
        viewPager2.setAdapter(viewPagerAdapter);




        //start fragment >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
           FragmentManager fragmentManager = getSupportFragmentManager();
           FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
           fragmentTransaction.add(R.id.frameLayout,new Fragment_group());
           fragmentTransaction.commit();
        //start fragment >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>




        //tablayout cleck >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager2.setCurrentItem(tab.getPosition());
                int tabpozition = tab.getPosition();

                if (tabpozition == 0){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout,new Fragment_group());
                    fragmentTransaction.commit();
                } else if (tabpozition == 1) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout,new Fragment_chats());
                    fragmentTransaction.commit();
                } else if (tabpozition == 2) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout,new Fragment_updates());
                    fragmentTransaction.commit();
                }else if(tabpozition == 3) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout,new Fragment_calls());
                    fragmentTransaction.commit();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //tablayout cleck >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



        //viewpager2 callback>>>>>>>>>>>>>>>>>>>>>>>>
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tablayout.getTabAt(position).select();
            }
        });
        //viewpager2 callback>>>>>>>>>>>>>>>>>>>>>>>>









    }//oncreate mathod







    //viewpager2 Adapter>>>>>>>>>>>>>>>>>>>>>>>>
    public class ViewPagerAdapter extends FragmentStateAdapter{

        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {

            switch (position){
                case 0: return new Fragment_group();
                 case 1: return new Fragment_chats();
                 case 2: return new Fragment_updates();
                 case 3: return new Fragment_calls();
                default: return new Fragment_group();

            }

        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }

    //viewpager2 Adapter>>>>>>>>>>>>>>>>>>>>>>>>







}//public class>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>