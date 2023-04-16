package com.amtudio.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView linearLayout, gridLayout, staggeredGridLayout;
    private ArrayList<String> linearArrayList, gridArrayList, staggeredGridList;
    private LinearAdapter linearAdapter;
    private GridAdapter gridAdapter;
    private StaggeredGridAdapter staggeredGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        gridLayout = findViewById(R.id.gridLayout);
        gridLayout.setVisibility(View.GONE);
        staggeredGridLayout = findViewById(R.id.staggeredGridLayout);
        staggeredGridLayout.setVisibility(View.GONE);

        linearArrayList = new ArrayList<>();
        gridArrayList = new ArrayList<>();
        staggeredGridList = new ArrayList<>();

        linearAdapter = new LinearAdapter(this, this, linearArrayList);
        linearLayout.setLayoutManager(new LinearLayoutManager(this));
        linearLayout.setAdapter(linearAdapter);

        getListItems();
    }

    private void getListItems()
    {
        linearArrayList.add("Apple");
        linearArrayList.add("Orange");
        linearArrayList.add("Grapes");
        linearArrayList.add("Pineapple");
        linearArrayList.add("Jackfruit");
        linearArrayList.add("Watermelon");
        linearArrayList.add("Muskmelon");
        linearArrayList.add("Strawberry");
        linearArrayList.add("Blackberry");
        linearArrayList.add("Banana");
        linearArrayList.add("Dragon fruit");
        linearArrayList.add("Papaya");
        linearArrayList.add("Chickoo");
        linearArrayList.add("Gauva");
        linearArrayList.add("Mango");
        linearArrayList.add("Kiran");

        gridArrayList.addAll(linearArrayList);
        staggeredGridList.addAll(linearArrayList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.linear:
                linearLayout.setVisibility(View.VISIBLE);
                gridLayout.setVisibility(View.GONE);
                staggeredGridLayout.setVisibility(View.GONE);

                linearAdapter = new LinearAdapter(this, this, linearArrayList);
                linearLayout.setLayoutManager(new LinearLayoutManager(this));
                linearLayout.setAdapter(linearAdapter);

                linearAdapter.notifyDataSetChanged();

                return true;
            case R.id.grid:
                gridLayout.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.GONE);
                staggeredGridLayout.setVisibility(View.GONE);

                gridAdapter = new GridAdapter(this, this, gridArrayList);
                gridLayout.setLayoutManager(new GridLayoutManager(this, 2));
                gridLayout.setAdapter(gridAdapter);

                gridAdapter.notifyDataSetChanged();

                return true;
            case R.id.staggered:
                staggeredGridLayout.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.GONE);
                gridLayout.setVisibility(View.GONE);

                staggeredGridAdapter = new StaggeredGridAdapter(this, this, staggeredGridList);
                staggeredGridLayout.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                staggeredGridLayout.setAdapter(staggeredGridAdapter);

                staggeredGridAdapter.notifyDataSetChanged();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}