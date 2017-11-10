package com.example.goober.planes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.example.goober.planes.R.id.year;

/**
 * Created by goober on 09/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "planes.db";
    public static final String PLANES_TABLE_NAME = "planes";
    public static final String PLANES_COLUMN_ID = "id";
    public static final String PLANES_COLUMN_NAME = "name";
    public static final String PLANES_COLUMN_NICKNAME = "nickname";
    public static final String PLANES_COLUMN_YEAR = "year";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PLANES_TABLE_NAME + "(id INTEGER primary key autoincrement, name TEXT, nickname TEXT, year TEXT)");
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PLANES_TABLE_NAME);
        onCreate(db);
    }

    public boolean save(String name, String nickname, String year) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLANES_COLUMN_NAME, name);
        contentValues.put(PLANES_COLUMN_NICKNAME, nickname);
        contentValues.put(PLANES_COLUMN_YEAR, year);
        db.insert(PLANES_TABLE_NAME, null, contentValues);
        return true;
    }

    public ArrayList<Plane> all() {
        ArrayList<Plane> planes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + PLANES_TABLE_NAME + " ORDER BY " + PLANES_COLUMN_NAME, null);
        while (cursor.moveToNext()) {
            Integer id = cursor.getInt(cursor.getColumnIndex(PLANES_COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(PLANES_COLUMN_NAME));
            String nickname = cursor.getString(cursor.getColumnIndex(PLANES_COLUMN_NICKNAME));
            String year = cursor.getString(cursor.getColumnIndex(PLANES_COLUMN_YEAR));
            Plane plane = new Plane(id, name, nickname, year);
            planes.add(plane);
        }
        cursor.close();
        return planes;
    }

    public void delete(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = " id = ?";
        String[] values = {id.toString()};
        db.delete(PLANES_TABLE_NAME, sql, values);
    }


    public void checkDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM planes";
        Cursor cursor = db.rawQuery(count, null);
        cursor.moveToFirst();
        int icount = cursor.getInt(0);
        if (icount == 0) {

            this.save("f4", "Phantom", "1966");
            this.save("f14", "Tomcat", "1970");
            this.save("f15", "Eagle", "1986");
            this.save("fa18", "Hornet", "1995");
            this.save("f3", "Tornado", "1974");
            this.save("c130", "Hercules", "1954");
            this.save("su27", "Flanker", "1977");
            this.save("f1", "Lightning", "1954");
            this.save("mig29", "Fulcrum", "1977");
            this.save("c16", "Typhoon", "1994");
            this.save("gr7", "Harrier", "1985");
            this.save("mig25", "Foxbat", "1970");
            this.save("gr1", "Jaguar", "1968");
            this.save("s2b", "Buccaneer", "1958");
        }
        cursor.close();

    }
}







