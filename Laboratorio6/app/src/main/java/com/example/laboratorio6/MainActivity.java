package com.example.laboratorio6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.laboratorio6.fragemtns.HomeFragment;
import com.example.laboratorio6.fragemtns.MapFragment;
import com.example.laboratorio6.fragemtns.StatisticsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;
    ArrayList<String> listDatos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*recycler= (RecyclerView) findViewById(R.id.recyclerId);
        //recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recycler.setLayoutManager(new GridLayoutManager(this,2));//para columnas en este caso 2

        listDatos=new ArrayList<String>();

        for (int i=0; i<50; i++){
            listDatos.add("Dato # "+i+" ");
        }

        AdapterDatos adapter=new AdapterDatos(listDatos);
        recycler.setAdapter(adapter);*/

        showSelectedFragment(new HomeFragment());
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.menu_home){
                    showSelectedFragment(new HomeFragment());
                }
                if (menuItem.getItemId() == R.id.menu_map){
                    showSelectedFragment(new MapFragment());
                }
                if (menuItem.getItemId() == R.id.menu_statistics){
                    showSelectedFragment(new StatisticsFragment());
                }
                return true;
            }
        });
    }

    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}