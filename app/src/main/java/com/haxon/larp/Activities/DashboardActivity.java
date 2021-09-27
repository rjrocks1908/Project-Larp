package com.haxon.larp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.haxon.larp.R;
import com.haxon.larp.fragments.CO2CalcFragment;
import com.haxon.larp.fragments.HomeFragment;
import com.haxon.larp.fragments.RulesFragment;
import com.haxon.larp.fragments.TaskFragment;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new HomeFragment()).commit();
                        break;
                    case R.id.intruction_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new RulesFragment()).commit();
                        break;
                    case R.id.task_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new TaskFragment()).commit();
                        break;
                    case R.id.character_menu:
                        Toast.makeText(DashboardActivity.this, "Avatar", Toast.LENGTH_SHORT).show();
                        navigationView.setCheckedItem(R.id.character_menu);
                        break;
                    case R.id.calc_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new CO2CalcFragment()).commit();
                        navigationView.setCheckedItem(R.id.calc_menu);
                        break;
                    case R.id.logout_menu:
                        SharedPreferences preferences = getSharedPreferences("mypref", 0);
                        preferences.edit().remove("username").apply();
                        startActivity(new Intent(DashboardActivity.this, StartHomeActivity.class));
                        finish();
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_open,R.string.navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home_menu);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}