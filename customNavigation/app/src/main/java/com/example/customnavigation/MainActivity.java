package com.example.customnavigation;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Fragment temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.container1,new HomeFragment()).commit();
        nav.setCheckedItem(R.id.menu_home);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {

                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        temp = new HomeFragment();
//                        Toast.makeText(getApplicationContext(),"Home Panel is Open",Toast.LENGTH_LONG).show();
//                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_call:
                        temp = new CallFragment();
//                        Toast.makeText(getApplicationContext(),"Call Panel is Open",Toast.LENGTH_LONG).show();
//                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_setting:
                        temp = new SettingFragment();
                        //                        Toast.makeText(getApplicationContext(),"Setting Panel is Open",Toast.LENGTH_LONG).show();
//                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container1,temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });




    }



}