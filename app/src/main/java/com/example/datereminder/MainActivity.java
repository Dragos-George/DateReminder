package com.example.datereminder;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.datereminder.MainMenuFragments.CategoriesFragment;
import com.example.datereminder.MainMenuFragments.HomeFragment;
import com.example.datereminder.MainMenuFragments.SettingsFragment;
import com.example.datereminder.Model.FutureAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                    new HomeFragment()).commit();
        }

        ArrayList<FirstItem> firstList = new ArrayList<>();
        firstList.add(new FirstItem(R.drawable.ic_fire24dp, "Line 1", "Line 2"));
        firstList.add(new FirstItem(R.drawable.ic_fire24dp, "Line 3", "Line 4"));
        firstList.add(new FirstItem(R.drawable.ic_fire24dp, "Line 5", "Line 6"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new FutureAdapter(firstList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.navigation_categories:
                            selectedFragment = new CategoriesFragment();
                            break;
                        case R.id.navigation_settings:
                            selectedFragment = new SettingsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();
                    return true;
                }
            };
}
