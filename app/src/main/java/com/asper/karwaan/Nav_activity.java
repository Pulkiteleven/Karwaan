package com.asper.karwaan;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.asper.karwaan.Fragments.HomeFragment;
import com.asper.karwaan.Fragments.MicFragment;
import com.asper.karwaan.Fragments.MoviesFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class Nav_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("KARWAAN");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        AnimatedBottomBar bottomBar = findViewById(R.id.bottom_bar);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,1,0);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.draic,Nav_activity.this.getTheme());
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(drawable);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        Fragment fragment = new HomeFragment();
        displayFragment(fragment);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        bottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NotNull AnimatedBottomBar.Tab tab1) {
                Fragment fragment = new HomeFragment();
                displayFragment(fragment);
                switch (tab1.getId()){
                    case R.id.movieb:
                        fragment = new MoviesFragment();
                        break;

                    case R.id.homeb:
                        fragment = new HomeFragment();
                        break;

                    case R.id.micb:
                        fragment = new MicFragment();
                        break;
                    default:
                        fragment = new HomeFragment();
                        break;
                }
                displayFragment(fragment);
            }

            @Override
            public void onTabReselected(int i, @NotNull AnimatedBottomBar.Tab tab) {

            }
        });
    }

    private void displayFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_about:
                Intent intent = new Intent(Nav_activity.this,About_activity.class);
                startActivity(intent);
                    break;
            case R.id.nav_contact:
                Intent intentt = new Intent(Nav_activity.this,Contact_activity.class);
                startActivity(intentt);
                break;
            case R.id.nav_team:
                Intent intenttt = new Intent(Nav_activity.this,Team_activity.class);
                startActivity(intenttt);
                break;
            case R.id.nav_event:
                Toast.makeText(this, "Event", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}