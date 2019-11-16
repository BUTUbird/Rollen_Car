package com.example.rollen_car;


import com.example.rollen_car.adapter.MainPagerAdapter;
import com.example.rollen_car.fragment.Fifth_Fragment;
import com.example.rollen_car.fragment.First_Fragment;
import com.example.rollen_car.fragment.Fourth_Fragment;
import com.example.rollen_car.fragment.Second_Fragment;
import com.example.rollen_car.fragment.Thrid_Fragment;
import com.example.car_demo1.R;
import com.example.rollen_car.adapter.MainPagerAdapter;

import com.example.rollen_car.fragment.Fifth_Fragment;
import com.example.rollen_car.fragment.First_Fragment;

import com.example.rollen_car.fragment.Fourth_Fragment;
import com.example.rollen_car.fragment.Second_Fragment;
import com.example.rollen_car.fragment.Thrid_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaeger.library.StatusBarUtil;
;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;




public class MainActivity extends AppCompatActivity {
    MainPagerAdapter adapter;
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
   //状态栏沉浸
        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorPrimary));

         bottomNavigationView  =(BottomNavigationView) findViewById(R.id.nav_view);
 //      navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //获取两个控件的对象
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        //为ViewPager设置Adapter
        adapter = new MainPagerAdapter(getSupportFragmentManager());

        //为Adapter添加Adapter
        adapter.addFragment(new First_Fragment());
        adapter.addFragment(new Second_Fragment());
        adapter.addFragment(new Thrid_Fragment());
        adapter.addFragment(new Fourth_Fragment());
        adapter.addFragment(new Fifth_Fragment());

        viewPager.setAdapter(adapter);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                int itemId = Item.getItemId();
                switch (itemId) {
                    case R.id.navigation_home:
//                    transaction.replace(R.id.content,new First_Fragment());//此处切换class
//                    transaction.commit();//缺少此行不显示；
//                     return true;
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_dashboard:
//                    transaction.replace(R.id.content,new Second_Fragment());
//                    transaction.commit();
//                    return true;
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_notifications:
//                    transaction.replace(R.id.content,new Thrid_Fragment());
//                    transaction.commit();
//                    return true;
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.navigation_timer:
//                    transaction.replace(R.id.content,new Fourth_Fragment());
//                    transaction.commit();
//                    return true;
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.navigation_windows:
//                    transaction.replace(R.id.content,new Fifth_Fragment());
//                    transaction.commit();
//                    return true;
                        viewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
     }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                //测试代码是否生效
                Log.e("ljw","李江武");
               mDrawerLayout.openDrawer(GravityCompat.END);
                break;
            default:
        }
        return true;
    }
}
