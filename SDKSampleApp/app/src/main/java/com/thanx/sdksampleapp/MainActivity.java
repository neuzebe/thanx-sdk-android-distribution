package com.thanx.sdksampleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

  Context context = this;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    String[] sections = { "Card Encryption" };
    ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listview_section, sections);
    ListView listView = findViewById(R.id.listview);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener((adapterView, view, position, l) -> {
      String section = (String) listView.getItemAtPosition(position);
      Intent intent = null;
      switch (section) {
        case "Card Encryption":
          intent = new Intent(context, CardEncryptionActivity.class);
      }
      startActivity(intent);
    });

  }
}
