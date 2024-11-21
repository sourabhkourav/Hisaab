package com.example.hisaab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hisaab.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new InsertFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.insert :
                    replaceFragment(new InsertFragment());
                    break;
                case R.id.view :
                    replaceFragment(new ViewFragment());
                    break;
                case R.id.farmer :
                    replaceFragment(new FarmerFragment());
                    break;
                case R.id.driver :
                    replaceFragment(new DriverFragment());
                    break;
                case R.id.labour :
                    replaceFragment(new LabourFragment());
                    break;
            }

            return true;
        });
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
    public void message(View view){
        Toast.makeText(getApplicationContext(),"Hii button clicked",Toast.LENGTH_SHORT).show();
    }
}