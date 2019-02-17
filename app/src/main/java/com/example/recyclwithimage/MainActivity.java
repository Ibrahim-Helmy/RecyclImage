package com.example.recyclwithimage;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {


    int[] images = {R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5, R.drawable.m6, R.drawable.m7, R.drawable.m8};
    String names[] = new String[]{"ibrahim", "ibraqim", "ahmed", "ibtsam", "ali", "mohamed", "mahmoued", "moeman"};

    List<Image> imageList = new ArrayList<>();
    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.main);
        setTitle("Images");

        int count = 0;
        for (String name : names) {
            imageList.add(new Image(images[count], name));
            count++;
        }


        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

         adapter = new MyRecyclerAdapter(this,imageList);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem menuItem = menu.findItem(R.id.search_id);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        String text = s.toLowerCase();
        List<Image> newlist = new ArrayList<>();

        for (Image image: imageList){

            String name = image.getTitle().toLowerCase();
            if (name.toLowerCase().contains(text)){

                newlist.add(image);
            }

        }
        adapter.updateRecycle(newlist);
        return false;
    }
}
