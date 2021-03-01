package com.example.wsr_2021_itswfb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String dbUSer = "UserDB";

    public static final String userTable = "User";
    public static final String colUserEmail = "Email";
    public static final String colUserPass = "Password";

    public DataBaseHelper(@Nullable Context context) {
        super(context, dbUSer, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + userTable + "(" +
                colUserEmail + " TEXT PRIMARY KEY, " +
                colUserPass + " TEXT NOT NULL);"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + userTable);
        onCreate(db);
    }

    public Boolean RegUser(String email, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT COUNT(*) as 'count' FROM " + userTable +
                " WHERE " + colUserEmail + "=?";
        Cursor c = db.rawQuery(selectQuery, new String[]{email});
        if(c!=null) {
            c.moveToFirst();
            Integer count = c.getInt(c.getColumnIndex("count"));
            if (count == 0) {
                db = this.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put(colUserEmail, email);
                cv.put(colUserPass, pass);
                db.insert(userTable, null, cv);
                return true;
            }
        }
        return false;
    }

    public Boolean AuthUser(String email, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT COUNT(*) as 'count' FROM " + userTable +
                " WHERE " + colUserEmail + "=?";
        Cursor c = db.rawQuery(selectQuery, new String[]{email});
        if(c!=null){
            c.moveToFirst();
            Integer count = c.getInt(c.getColumnIndex("count"));
            if (count == 0) {
                return false;
            }
        }
        return true;
    }

    public List<User> getUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT " + colUserEmail + "," + colUserPass  + " FROM " + userTable;
        Cursor c = db.rawQuery(selectQuery, null);
        List<User> users = new ArrayList<>();
        if(c!= null){
            c.moveToFirst();
            do {
                String email = c.getString(c.getColumnIndex(colUserEmail));
                String pass = c.getString(c.getColumnIndex(colUserPass));
                User user = new User(email, pass,0);
                users.add(user);
            }while(c.moveToNext());
        }
        return users;
    }
}
