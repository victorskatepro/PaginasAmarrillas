package com.victorsaico.paginasamarrillas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.victorsaico.paginasamarrillas.fragments.BuscarFragment;
import com.victorsaico.paginasamarrillas.fragments.ConfiguracionFragment;
import com.victorsaico.paginasamarrillas.fragments.LocationFragment;
import com.victorsaico.paginasamarrillas.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Fragment buscarFragment = new BuscarFragment();
        final Fragment locationFragment = new LocationFragment();
        final Fragment perfilFragment = new PerfilFragment();
        final Fragment configuracionFragment = new ConfiguracionFragment();
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, buscarFragment).commit();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                if(item.getItemId() == R.id.buscarItem){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, buscarFragment).commit();
                }else if (item.getItemId() == R.id.locationItem){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, locationFragment).commit();
                }else if (item.getItemId() == R.id.ajustesItem){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, configuracionFragment).commit();
                }else if (item.getItemId() == R.id.perfilItem){
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, perfilFragment).commit();
                }
              return true;
            }
        });
    }
}