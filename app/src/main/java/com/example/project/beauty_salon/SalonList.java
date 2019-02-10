package com.example.project.beauty_salon;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalonList extends Activity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_list);
            final DBHelper helper = new DBHelper(getBaseContext(), null, null, 1);

        lv = (ListView) findViewById(R.id.lv1);
        final ArrayList<String> al = new ArrayList<String>();
        Cursor cur = helper.getAllTitles();
        if (cur.moveToFirst()) {
            do {
                al.add(cur.getString(0) + "-" + cur.getString(1) + "-" + cur.getString(2) + "-" + cur.getString(3));
            }
            while (cur.moveToNext());
        }
        lv.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, al));
      lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent appInfo = new Intent(SalonList.this, Details.class);
                startActivity(appInfo);

            }
        });
    }
}

