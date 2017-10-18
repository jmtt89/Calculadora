package com.master.homework.torresj_u2;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


/**
 * (X) Ejercicio: Uso de FragmentTabHost
 */
public class MainActivity extends AppCompatActivity {
    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Tabs
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(getApplicationContext(), getSupportFragmentManager(), android.R.id.tabcontent);

        //Tab 1
        CharSequence[] tabsTitles = {
                getResources().getText(R.string.title_asteroids),
                getResources().getText(R.string.title_constraints),
                getResources().getText(R.string.title_custom_buttons),
                getResources().getText(R.string.title_calculator),
                getResources().getText(R.string.title_calculator_plus),
                getResources().getText(R.string.title_my_places),
                getResources().getText(R.string.title_add_place)
        };



        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(tabsTitles[0]), AsteroidsFragment.class, null);

        //Tab 2
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(tabsTitles[1]), ConstraintExampleFragment.class, null);

        //Tab 3
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator(tabsTitles[2]), CustomBtnFragment.class, null);

        //Tab 4
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator(tabsTitles[3]), CalcFragment.class, null);

        //Tab 5
        tabHost.addTab(tabHost.newTabSpec("tab5").setIndicator(tabsTitles[4]), CalcFragmentPlus.class, null);

        /**
         * Hay un bug que no encontre como resolver cuando activo el tab6 y tab7 agrega un espacio
         * extra sobre el Toolbar, asumo que es porque los tabs de myplaces utilizan el metodo de
         * toolbar expandible y so dana lo demas.
         */

        //Tab 6
//        tabHost.addTab(tabHost.newTabSpec("tab6").setIndicator(tabsTitles[5]), MyPlacesFragment.class, null);

        //Tab 7
//        tabHost.addTab(tabHost.newTabSpec("tab7").setIndicator(tabsTitles[6]), AddPlaceFragment.class, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Aun no tengo nada que poner en el menu
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
