package com.example.a16046562.demosqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btninsert, btngettasks;
    TextView tvresults;
    ListView lv;

    ArrayAdapter aa;
    ArrayList<Task> tasksss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninsert = (Button) findViewById(R.id.btnInsert);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });

        tvresults = (TextView) findViewById(R.id.tvResults);
        btngettasks = (Button) findViewById(R.id.buttonGetTasks);
        btngettasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                ArrayList<Task>

                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". " + data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }
                tvresults.setText(txt);

            }
        });

        lv = (ListView) this.findViewById(R.id.lv1);
        tasksss = new ArrayList<Task>();
        aa = new TaskAdapter(this,R.layout.row,tasksss);
        lv.setAdapter(aa);

    }
}
