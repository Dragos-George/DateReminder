package com.example.datereminder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.example.datereminder.Fragments.CategoriesFragment;
import com.example.datereminder.Fragments.HomeFragment;
import com.example.datereminder.Fragments.SearchFragment;
import com.example.datereminder.Fragments.SettingsFragment;
import com.example.datereminder.Model.Categories;
import com.example.datereminder.Model.DateItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    SearchFragment searchFragment;
    CategoriesFragment categoriesFragment;
    SettingsFragment settingsFragment;

    private Button setButton;

    // private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment=new HomeFragment();
        searchFragment = new SearchFragment();
        categoriesFragment = new CategoriesFragment();
        settingsFragment=new SettingsFragment();

        //dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                    new HomeFragment()).commit();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = homeFragment;
                            break;
                        case R.id.navigation_search:
                            selectedFragment = searchFragment;
                            break;
                        case R.id.navigation_categories:
                            selectedFragment = categoriesFragment;
                            break;
                        case R.id.navigation_settings:
                            selectedFragment = settingsFragment;
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();
                    return true;
                }
            };

    public void sendList(ArrayList<DateItem> results) {
        searchFragment.addToItems(results);
    }
}
