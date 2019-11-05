package com.haroun.myplanner;

import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class sectionAct1 extends AppCompatActivity {

    ListView taskListView;
    String[] tasks;
    String[] descriptions;
    String[] dueDates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_act1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }) ;

        Resources res = getResources() ;
        taskListView = (ListView) findViewById(R.id.taskListView1);
        tasks = res.getStringArray(R.array.tasks1) ;
        descriptions = res.getStringArray(R.array.descriptions1) ;
        dueDates = res.getStringArray(R.array.dueDate1) ;

        taskListView.setAdapter(new ArrayAdapter<String>(this, R.layout.task_list_view_1, tasks));



    }

}
