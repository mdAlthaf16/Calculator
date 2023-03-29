package com.conversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.conversion.Fragments.MyAdapter;
import com.conversion.Fragments.SNF_Fragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    MyAdapter adapter;
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    public static String STATE_TEM_VOLUME_1 = "", STATE_TEM_VOLUME_2 = "", CURRENT_STATE = "";

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch keralaSwitch,
            tamilNaduSwitch, gujaratSwitch,
            westBengalSwitch, orissaSwitch,
            maharashtraSwitch, goaSwitch, assamSwitch,
            restOfBiharSwitch,
            mpSwitch, upSwitch, apSwitch,
            punjabSwitch, haryanaSwitch, karnatakaSwitch;

    String SHARED_PREFERENCE = "SHARED PREFERENCE",
            KERALA = "KERALA", TAMIL_NADU = "TAMIL NADU",
            GUJARAT = "GUJARAT", WEST_BENGAL = "WEST BENGAL",
            ORISSA = "ORISSA", MAHARASHTRA = "MAHARASHTRA",
            GOA = "GOA", ASSAM = "ASSAM",
            REST_OF_BIHAR = "REST OF BIHAR", MP = "MP",
            UP = "UP", AP = "AP", PUNJAB = "PUNJAB",
            HARYANA = "HARYANA", KARNATAKA = "KARNATAKA";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBarLayout);
        setSupportActionBar(toolbar);

        showTabLayout();
        navigationView();
        loadData();

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isOpen()) {
            drawerLayout.close();
        } else {
            super.onBackPressed();
        }
    }

    protected void showTabLayout() {

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new MyAdapter(this);
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                Objects.requireNonNull(tabLayout.getTabAt(position)).select();
            }
        });

    }

    @SuppressLint("NonConstantResourceId")
    protected void navigationView() {

        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);

        toggle.syncState();

        drawerLayout.addDrawerListener(toggle);

        keralaSwitch = (Switch) navigationView.getMenu().findItem(R.id.kerala).getActionView();
        tamilNaduSwitch = (Switch) navigationView.getMenu().findItem(R.id.tamilNadu).getActionView();
        gujaratSwitch = (Switch) navigationView.getMenu().findItem(R.id.gujarat).getActionView();
        westBengalSwitch = (Switch) navigationView.getMenu().findItem(R.id.westBengal).getActionView();
        orissaSwitch = (Switch) navigationView.getMenu().findItem(R.id.orissa).getActionView();
        maharashtraSwitch = (Switch) navigationView.getMenu().findItem(R.id.maharashtra).getActionView();
        goaSwitch = (Switch) navigationView.getMenu().findItem(R.id.goa).getActionView();
        assamSwitch = (Switch) navigationView.getMenu().findItem(R.id.assam).getActionView();
        restOfBiharSwitch = (Switch) navigationView.getMenu().findItem(R.id.restOfBihar).getActionView();
        mpSwitch = (Switch) navigationView.getMenu().findItem(R.id.mp).getActionView();
        upSwitch = (Switch) navigationView.getMenu().findItem(R.id.up).getActionView();
        apSwitch = (Switch) navigationView.getMenu().findItem(R.id.ap).getActionView();
        punjabSwitch = (Switch) navigationView.getMenu().findItem(R.id.punjab).getActionView();
        haryanaSwitch = (Switch) navigationView.getMenu().findItem(R.id.haryana).getActionView();
        karnatakaSwitch = (Switch) navigationView.getMenu().findItem(R.id.karnataka).getActionView();

        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.kerala:
                    keralaSwitch.setChecked(true);
                    break;
                case R.id.tamilNadu:
                    tamilNaduSwitch.setChecked(true);
                    break;
                case R.id.gujarat:
                    gujaratSwitch.setChecked(true);
                    break;
                case R.id.westBengal:
                    westBengalSwitch.setChecked(true);
                    break;
                case R.id.orissa:
                    orissaSwitch.setChecked(true);
                    break;
                case R.id.maharashtra:
                    maharashtraSwitch.setChecked(true);
                    break;
                case R.id.goa:
                    goaSwitch.setChecked(true);
                    break;
                case R.id.assam:
                    assamSwitch.setChecked(true);
                    break;
                case R.id.restOfBihar:
                    restOfBiharSwitch.setChecked(true);
                    break;
                case R.id.mp:
                    mpSwitch.setChecked(true);
                    break;
                case R.id.up:
                    upSwitch.setChecked(true);
                    break;
                case R.id.ap:
                    apSwitch.setChecked(true);
                    break;
                case R.id.punjab:
                    punjabSwitch.setChecked(true);
                    break;
                case R.id.haryana:
                    haryanaSwitch.setChecked(true);
                    break;
                case R.id.karnataka:
                    karnatakaSwitch.setChecked(true);
                    break;

            }

            return true;
        });

        keralaSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.20";
                STATE_TEM_VOLUME_2 = "0.50";
                CURRENT_STATE = "Kerala";

                navigationView.setCheckedItem(keralaSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        tamilNaduSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {


                STATE_TEM_VOLUME_1 = "0.20";
                STATE_TEM_VOLUME_2 = "0.36";
                CURRENT_STATE = "Tamil Nadu";

                navigationView.setCheckedItem(tamilNaduSwitch.getId());
                keralaSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        gujaratSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {



                STATE_TEM_VOLUME_1 = "0.21";
                STATE_TEM_VOLUME_2 = "0.36";
                CURRENT_STATE = "Gujarat";

                navigationView.setCheckedItem(gujaratSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        westBengalSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.21";
                STATE_TEM_VOLUME_2 = "0.36";
                CURRENT_STATE = "West Bengal";

                navigationView.setCheckedItem(westBengalSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        orissaSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {


                STATE_TEM_VOLUME_1 = "0.21";
                STATE_TEM_VOLUME_2 = "0.36";
                CURRENT_STATE = "Orissa";

                navigationView.setCheckedItem(orissaSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        maharashtraSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.21";
                STATE_TEM_VOLUME_2 = "0.36";
                CURRENT_STATE = "Maharashtra";

                navigationView.setCheckedItem(maharashtraSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        goaSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {




                STATE_TEM_VOLUME_1 = "0.21";
                STATE_TEM_VOLUME_2 = "0.36";
                CURRENT_STATE = "Goa";

                navigationView.setCheckedItem(goaSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        assamSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.20";
                STATE_TEM_VOLUME_2 = "0.66";
                CURRENT_STATE = "Assam";

                navigationView.setCheckedItem(assamSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        restOfBiharSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.20";
                STATE_TEM_VOLUME_2 = "0.66";
                CURRENT_STATE = "Rest of Bihar";

                navigationView.setCheckedItem(restOfBiharSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        mpSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.20";
                STATE_TEM_VOLUME_2 = "0.70";
                CURRENT_STATE = "Madhya Pradesh";

                navigationView.setCheckedItem(mpSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        apSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.21";
                STATE_TEM_VOLUME_2 = "0.36";
                CURRENT_STATE = "Andra Pradesh";

                navigationView.setCheckedItem(apSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        upSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.20";
                STATE_TEM_VOLUME_2 = "0.29";
                CURRENT_STATE = "Uttar Pradesh";

                navigationView.setCheckedItem(upSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        punjabSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.20";
                STATE_TEM_VOLUME_2 = "0.29";
                CURRENT_STATE = "Punjab";

                navigationView.setCheckedItem(punjabSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        haryanaSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.20";
                STATE_TEM_VOLUME_2 = "0.29";
                CURRENT_STATE = "Haryana";

                navigationView.setCheckedItem(haryanaSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                keralaSwitch.setChecked(false);
                karnatakaSwitch.setChecked(false);

            }

            saveData();
        });
        karnatakaSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if (isChecked) {

                STATE_TEM_VOLUME_1 = "0.25";
                STATE_TEM_VOLUME_2 = "0.35";
                CURRENT_STATE = "Karnataka";

                navigationView.setCheckedItem(karnatakaSwitch.getId());
                tamilNaduSwitch.setChecked(false);
                gujaratSwitch.setChecked(false);
                westBengalSwitch.setChecked(false);
                orissaSwitch.setChecked(false);
                maharashtraSwitch.setChecked(false);
                goaSwitch.setChecked(false);
                assamSwitch.setChecked(false);
                restOfBiharSwitch.setChecked(false);
                mpSwitch.setChecked(false);
                apSwitch.setChecked(false);
                upSwitch.setChecked(false);
                punjabSwitch.setChecked(false);
                haryanaSwitch.setChecked(false);
                keralaSwitch.setChecked(false);

            }

            saveData();
        });


    }

    protected void saveData() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(KERALA, keralaSwitch.isChecked());
        editor.putBoolean(TAMIL_NADU, tamilNaduSwitch.isChecked());
        editor.putBoolean(GUJARAT, gujaratSwitch.isChecked());
        editor.putBoolean(WEST_BENGAL, westBengalSwitch.isChecked());
        editor.putBoolean(ORISSA, orissaSwitch.isChecked());
        editor.putBoolean(MAHARASHTRA, maharashtraSwitch.isChecked());
        editor.putBoolean(GOA, goaSwitch.isChecked());
        editor.putBoolean(ASSAM, assamSwitch.isChecked());
        editor.putBoolean(REST_OF_BIHAR, restOfBiharSwitch.isChecked());
        editor.putBoolean(MP, mpSwitch.isChecked());
        editor.putBoolean(UP, upSwitch.isChecked());
        editor.putBoolean(AP, apSwitch.isChecked());
        editor.putBoolean(PUNJAB, punjabSwitch.isChecked());
        editor.putBoolean(HARYANA, haryanaSwitch.isChecked());
        editor.putBoolean(KARNATAKA, karnatakaSwitch.isChecked());
        editor.apply();

    }

    protected void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE, MODE_PRIVATE);
        boolean switchState1 = sharedPreferences.getBoolean(KERALA, true);
        boolean switchState2 = sharedPreferences.getBoolean(TAMIL_NADU, false);
        boolean switchState3 = sharedPreferences.getBoolean(GUJARAT, false);
        boolean switchState4 = sharedPreferences.getBoolean(WEST_BENGAL, false);
        boolean switchState5 = sharedPreferences.getBoolean(ORISSA, false);
        boolean switchState6 = sharedPreferences.getBoolean(MAHARASHTRA, false);
        boolean switchState7 = sharedPreferences.getBoolean(GOA, false);
        boolean switchState8 = sharedPreferences.getBoolean(ASSAM, false);
        boolean switchState9 = sharedPreferences.getBoolean(REST_OF_BIHAR, false);
        boolean switchState10 = sharedPreferences.getBoolean(MP, false);
        boolean switchState11 = sharedPreferences.getBoolean(UP, false);
        boolean switchState12 = sharedPreferences.getBoolean(AP, false);
        boolean switchState13 = sharedPreferences.getBoolean(PUNJAB, false);
        boolean switchState14 = sharedPreferences.getBoolean(HARYANA, false);
        boolean switchState15 = sharedPreferences.getBoolean(KARNATAKA, false);

        // update view

        keralaSwitch.setChecked(switchState1);
        tamilNaduSwitch.setChecked(switchState2);
        gujaratSwitch.setChecked(switchState3);
        westBengalSwitch.setChecked(switchState4);
        orissaSwitch.setChecked(switchState5);
        maharashtraSwitch.setChecked(switchState6);
        goaSwitch.setChecked(switchState7);
        assamSwitch.setChecked(switchState8);
        restOfBiharSwitch.setChecked(switchState9);
        mpSwitch.setChecked(switchState10);
        upSwitch.setChecked(switchState11);
        apSwitch.setChecked(switchState12);
        punjabSwitch.setChecked(switchState13);
        haryanaSwitch.setChecked(switchState14);
        karnatakaSwitch.setChecked(switchState15);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.infoDialog) {

            showInfoDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    private void showInfoDialog() {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.info_dialog_layout);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        TextView state = dialog.findViewById(R.id.displayCurrentState);
        TextView snfFormula = dialog.findViewById(R.id.displaySNF_formula);
        TextView clrFormula = dialog.findViewById(R.id.displayCLR_formula);

        state.setText(CURRENT_STATE);
        snfFormula.setText("( CLR / 4 ) + ( " + STATE_TEM_VOLUME_1 + " * FAT ) + " + STATE_TEM_VOLUME_2);
        clrFormula.setText("( SNF - ( " + STATE_TEM_VOLUME_1 + " * FAT ) - " + STATE_TEM_VOLUME_2 + " ) * 4");

        dialog.show();
    }
}