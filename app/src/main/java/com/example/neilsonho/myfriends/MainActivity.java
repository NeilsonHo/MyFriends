package com.example.neilsonho.myfriends;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ActionBarActivity {
    private MyDBHandler dbMain;
    List<Friend> array_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbMain =  new MyDBHandler(this,null,null,1); ;
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.listView);

        ///*
        array_list = dbMain.populateStudent();

        ArrayAdapter<Friend> adapter = new ArrayAdapter<Friend>(this, android.R.layout.simple_list_item_1,array_list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Name: "+array_list.get(position).getName()+ " Phone: " + array_list.get(position).getPhone() +" Email: "+ array_list.get(position).getEmail() ,
                        Toast.LENGTH_LONG).show();
            }
        });
        //v*/
        dbMain.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        final Intent myIntent = new Intent(this,Help.class);
        final Intent myIntent2 = new Intent(this,About.class);

        if(id==R.id.action_help){
            startActivity(myIntent);
        }
        else{
            startActivity(myIntent2);
        }
        return super.onOptionsItemSelected(item);
    }
}
