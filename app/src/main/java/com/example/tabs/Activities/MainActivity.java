package com.example.tabs.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.example.tabs.Adapters.PagerAdapter;
import com.example.tabs.R;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(myToolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));

        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));

        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));


        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());


        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override

            public void onTabSelected(TabLayout.Tab tab) {

                Toast.makeText(MainActivity.this, "Selected -> " + tab.getText(), Toast.LENGTH_SHORT).show();

                int position = tab.getPosition();

                viewPager.setCurrentItem(position);

            }


            @Override

            public void onTabUnselected(TabLayout.Tab tab) {

                Toast.makeText(MainActivity.this, "Unselected -> " + tab.getText(), Toast.LENGTH_SHORT).show();

            }


            @Override

            public void onTabReselected(TabLayout.Tab tab) {

                Toast.makeText(MainActivity.this, "Reselected -> " + tab.getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }
}