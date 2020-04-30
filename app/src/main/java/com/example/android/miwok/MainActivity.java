/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CategoryAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        mAdapter = new CategoryAdapter(MainActivity.this, getSupportFragmentManager());
        // Set the adapter onto the view pager
        viewPager.setAdapter(mAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.active_tab_color));
        tabLayout.setTabTextColors(Color.parseColor("#ABA19E"), Color.parseColor("#ffffff"));

     }

    /**
     * This code snippet was used for the old layout where the user ha to click on a category
     */
    /*
    public void openNumbersList(View view) {
        Intent numberIntent = new Intent(this, NumbersActivity.class);
        startActivity(numberIntent);
    }

    public void openFamilyMembers(View view){
        Intent familyMembersIntent = new Intent(this, FamilyMembersActivity.class);
        startActivity(familyMembersIntent);
    }

    public void openColors(View view){
        Intent colorsIntent = new Intent(this, ColorsActivity.class);
        startActivity(colorsIntent);
    }

    public void openPhrases (View view){
        Intent colorsIntent = new Intent(this, PhrasesActivity.class);
        startActivity(colorsIntent);
    }
     */

}
