package com.example.firenote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firenote.model.Adapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
DrawerLayout drawerLayout;
ActionBarDrawerToggle toogle;
NavigationView navigationView;
Toolbar toolbar;
RecyclerView notelist;
Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notelist = findViewById(R.id.notelist);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.Drawer);
        navigationView = findViewById(R.id.NavView);
        navigationView.setNavigationItemSelectedListener(this);
        toogle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toogle);
        toogle.setDrawerIndicatorEnabled(true);
        toogle.syncState();

        FloatingActionButton FloatAddButton = findViewById(R.id.AddNoteButton);
        FloatAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddNote.class));
            }
        });

        List<String> titles = new ArrayList<String>();
        List<String> content = new ArrayList<String>();

        titles.add("First title");
        content.add("First  First content First content First content First content First content First content First content First content First content First content First content First content " +
                "First content First content First content");

        titles.add("Sec title");
        content.add("Sec content");

        titles.add("Third title");
        content.add("Third content");

        adapter = new Adapter(titles,content);
        notelist.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        notelist.setAdapter(adapter);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Note:
                Toast.makeText(this, "Your Note", Toast.LENGTH_SHORT).show();
                break;

            case R.id.AddNote:
                startActivity(new Intent(getApplicationContext(), AddNote.class));
                break;

            case R.id.Sync:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Share:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Rate:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Logout:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;

            default:



        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.setting){
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }






}

