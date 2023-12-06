package com.openclassrooms.realestatemanager.mainPage;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.openclassrooms.realestatemanager.BaseActivity;
import com.openclassrooms.realestatemanager.R;
import com.openclassrooms.realestatemanager.createEstate.AddActivity;
import com.openclassrooms.realestatemanager.databinding.ActivityMainBinding;
import com.openclassrooms.realestatemanager.detailDescription.DetailFragment;
import com.openclassrooms.realestatemanager.editEstate.EditActivity;
import com.openclassrooms.realestatemanager.listPage.ListFragment;
import com.openclassrooms.realestatemanager.mapPage.MapActivity;
import com.openclassrooms.realestatemanager.searchPage.SearchActivity;
import com.openclassrooms.realestatemanager.utils.Utils;
public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;
    private ListFragment listFragment;
    private DetailFragment detailFragment;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        this.onClickFab();
//        //First error id call error
////        this.textViewMain = findViewById(R.id.activity_second_activity_text_view_main);
        this.configureAndShowListFragment();
//         this.configureAndShowDetailFragment();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.configureToolbar();
        }
    }

//    @SuppressLint("SetTextI18n")
//    private void configureTextViewQuantity(){
//        int quantity = Utils.convertDollarToEuro(100);
//        this.textViewQuantity.setTextSize(20);
//        //Second Error : call integer in setText
//        //this.texViewQuantity.setText(quantity);
//        this.textViewQuantity.setText(Integer.toString(quantity));
//    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        //Inflate the menu and add it to the Toolbar
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }
    //For click on floating action button
    public void onClickFab () {
        binding.fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fabIntent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(fabIntent);
            }
        });

    }

//for click on buttons in toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle actions on menu items
        switch (item.getItemId()) {
            case R.id.edit_btn :
                Intent editIntent = new Intent(this, EditActivity.class);
                startActivity(editIntent);
                return true;
            case R.id.search_btn :
                Intent searchIntent = new Intent(this, SearchActivity.class);
                startActivity(searchIntent);
                return true;
            case R.id.map_btn :
                Intent mapIntent = new Intent(this, MapActivity.class);
                startActivity(mapIntent);
                return true;
            default :
                return
                        super.onOptionsItemSelected(item);
        }
    }
    private void configureAndShowListFragment(){
        //Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        listFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);
        if (listFragment == null) {
            //Create new main fragment
            listFragment = new ListFragment();
            //Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_main, listFragment)
                    .commit();
        }
    }
}