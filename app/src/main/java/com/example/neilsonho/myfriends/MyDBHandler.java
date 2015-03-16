package com.example.neilsonho.myfriends;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by neilsonho on 15-02-23.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_PATH = "data/data/com.example.neilsonho.myfriends/databases/";
    private static final String DATABASE_NAME = "friends.db";
    public static final String FRIENDS = "friends";
    public static final String ID = "id";
    public static final String FRIEND_NAME = "name";
    public static final String FRIEND_EMAIL = "email";
    public static final String FRIEND_PHONE = "phone";
    private final Context context;

    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //try {
            File dbFile = new File(DATABASE_PATH + DATABASE_NAME);
            if (dbFile.exists()) {
                //copyDatabase(dbFile);

            } else {
                Log.d("My Debug", "copied db");
            }
        //}catch (IOException e){
        //    e.printStackTrace();
        //}
    }
/*
    private void copyDatabase(File dbfile) throws IOException{
        InputStream iStream = context.getAssets().open(DATABASE_NAME);
        OutputStream oStream = new FileOutputStream(DATABASE_PATH+DATABASE_NAME);

        byte[] buffer = new byte[1024];
        int length;
        while((length = iStream.read(buffer)) >0){
            oStream.write(buffer,0,length);
        }
        oStream.flush();
        oStream.close();
        iStream.close();
    }
*/



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FRIENDS +";");
        onCreate(db);
    }

    public List<Friend> populateStudent(){
        List<Friend> friends = new ArrayList<Friend>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM friends",null);

        if(c.moveToFirst()){
            do{
                Friend temp = new Friend();
                //temp.setID(c.getInt(0));
                temp.setName(c.getString(1));
                temp.setPhone(c.getString(2));
                temp.setEmail(c.getString(3));
                friends.add(temp);

            }while(c.moveToNext());
        }
        return friends;
    }

    public void addFriend(String name, String phone, String email) {
        Friend friend = new Friend (name, email, phone);

        ContentValues values = new ContentValues();
        values.put(FRIEND_NAME, friend.getName());
        values.put(FRIEND_PHONE,friend.getPhone());
        values.put(FRIEND_EMAIL,friend.getEmail());


        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(FRIENDS, null, values);
        db.close();
    }

}
