package com.readingbooks.li.readingbooks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    PagerAdapter mSwipingViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureNavigationDrawer();
        configureToolbar();
        setViewPager();
    }

    private void configureNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Fragment f = null;
                Intent intent = null;

                int itemId = menuItem.getItemId();

                switch (itemId) {
                    case R.id.category1:
                        f = new BookList1Fragment();
                        break;
                    case R.id.category2:
                        f = new BookList2Fragment();
                        break;
                    case R.id.search_book:
                        intent = new Intent(MainActivity.this, SearchActivity.class);
                        break;
                    case R.id.camera:
                        //it shows dialog asking user to allow permission, but would crash first?
                        //then works fine after permission granted
                        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                                == PackageManager.PERMISSION_DENIED){
                            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, 100);
                        }
                        intent = new Intent(MainActivity.this, CameraActivity.class);
                        break;
                    case R.id.location:
                      //  intent = new Intent(MainActivity.this, GoogleLocationApiActivity.class);
                        //intent = new Intent(MainActivity.this, GpsGoogleActivity.class);
                        intent = new Intent(MainActivity.this, GPSTrackingActivity.class);
                        break;
                    case R.id.test_activity:
                        intent = new Intent(MainActivity.this, TestActivity.class);
                        break;
                    case R.id.test_activity_1:
                        intent = new Intent(MainActivity.this, TestActivity1.class);
                        break;
                    case R.id.test_activity_3:
                        intent = new Intent(MainActivity.this, TestActivity3.class);
                        break;
                    default:
                        break;
                }

             if (f != null){
                 FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                 transaction.replace(R.id.main_content, f);
                 transaction.commit();
                 drawerLayout.closeDrawers();
                 return true;
             } else if (intent != null){
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                    return true;
                }

                return false;
            }
        });
    }

    private void configureToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_navigation_top);
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    private void setViewPager() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.id_viewpager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BookContentFragment(), "Book Content1");
        adapter.addFragment(new BookAudioFragment(), "Book Audio2");
        adapter.addFragment(new BookDownloadFragment(), "Book Download3");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.id_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_empty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            // Android home
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            // manage other entries if you have it ...
            case R.id.about:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            case R.id.help:
                startActivity(new Intent(this, HelpActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // broadcast a custom intent.
    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
