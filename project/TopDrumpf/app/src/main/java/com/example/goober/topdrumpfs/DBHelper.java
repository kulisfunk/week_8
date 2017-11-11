package com.example.goober.topdrumpfs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;



/**
 * Created by goober on 10/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "trumps.db";
    public static final String PLANES_TABLE_NAME = "planes";
    public static final String PLANES_COLUMN_ID = "id";
    public static final String PLANES_COLUMN_NAME = "name";
    public static final String PLANES_COLUMN_NICKNAME = "nickname";
    public static final String PLANES_COLUMN_YEAR = "year";
    public static final String PLANES_COLUMN_COUNTRY = "plane_country";

    public static final String CARS_TABLE_NAME = "cars";
    public static final String CARS_COLUMN_ID = "id";
    public static final String CARS_COLUMN_MAKE = "make";
    public static final String CARS_COLUMN_MODEL = "model";
    public static final String CARS_COLUMN_YEAR = "year";
    public static final String CARS_COLUMN_COUNTRY = "car_country";

    public static final String PLANESTATS_TABLE_NAME = "planestats";
    public static final String PLANESTATS_COLUMN_ID = "id";
    public static final String PLANESTATS_COLUMN_PLANEID = "plane_id";
    public static final String PLANESTATS_COLUMN_SPEED = "speed";
    public static final String PLANESTATS_COLUMN_HEIGHT = "height";
    public static final String PLANESTATS_COLUMN_RANGE = "range";
    public static final String PLANESTATS_COLUMN_MAXTAKEOFF = "max_takeoff";
    public static final String PLANESTATS_COLUMN_WING = "wing";
    public static final String PLANESTATS_COLUMN_FIREPOWER = "firepower";
    public static final String PLANESTATS_COLUMN_WEIGHT1 = "weight1";
    public static final String PLANESTATS_COLUMN_WEIGHT2 = "weight2";
    public static final String PLANESTATS_COLUMN_WEIGHT3 = "weight3";
    public static final String PLANESTATS_COLUMN_WEIGHT4 = "weight4";
    public static final String PLANESTATS_COLUMN_WEIGHT5 = "weight5";
    public static final String PLANESTATS_COLUMN_WEIGHT6 = "weight6";

    public static final String CARSTATS_TABLE_NAME = "carstats";
    public static final String CARSTATS_COLUMN_ID = "id";
    public static final String CARSTATS_COLUMN_CARID = "car_id";
    public static final String CARSTATS_COLUMN_SPEED = "speed";
    public static final String CARSTATS_COLUMN_ACCEL = "accel";
    public static final String CARSTATS_COLUMN_POWER = "power";
    public static final String CARSTATS_COLUMN_CAPACITY = "capacity";
    public static final String CARSTATS_COLUMN_CYLINDERS = "cylinders";
    public static final String CARSTATS_COLUMN_LENGTH = "length";
    public static final String CARSTATS_COLUMN_WEIGHT1 = "weight1";
    public static final String CARSTATS_COLUMN_WEIGHT2 = "weight2";
    public static final String CARSTATS_COLUMN_WEIGHT3 = "weight3";
    public static final String CARSTATS_COLUMN_WEIGHT4 = "weight4";
    public static final String CARSTATS_COLUMN_WEIGHT5 = "weight5";
    public static final String CARSTATS_COLUMN_WEIGHT6 = "weight6";






    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    public ArrayList<Cursor> getData(String Query) throws SQLException {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "message" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(Exception ex){
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+ex.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PLANES_TABLE_NAME + "(id INTEGER primary key autoincrement, name TEXT, nickname TEXT, year TEXT, plane_country TEXT)");
        db.execSQL("CREATE TABLE " + CARS_TABLE_NAME + "(id INTEGER primary key autoincrement, make TEXT, model TEXT, year TEXT, car_country TEXT)");
        db.execSQL("CREATE TABLE " + PLANESTATS_TABLE_NAME + "(id INTEGER primary key autoincrement,  plane_id INTEGER, speed INTEGER, height INTEGER, range INTEGER, max_takeoff INTEGER, wing INTEGER, firepower INTEGER, weight1 INTEGER, weight2 INTEGER, weight3 INTEGER, weight4 INTEGER, weight5 INTEGER, weight6 INTEGER, FOREIGN KEY (plane_id) REFERENCES planes (id) ON DELETE CASCADE ON UPDATE NO ACTION)");
        db.execSQL("CREATE TABLE " + CARSTATS_TABLE_NAME + "(id INTEGER primary key autoincrement, car_id INTEGER, speed INTEGER, accel INTEGER, power INTEGER, capacity INTEGER, cylinders INTEGER, length INTEGER, weight1 INTEGER, weight2 INTEGER, weight3 INTEGER, weight4 INTEGER, weight5 INTEGER, weight6 INTEGER, FOREIGN KEY (car_id) REFERENCES cars (id) ON DELETE CASCADE ON UPDATE NO ACTION)");
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CARSTATS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PLANESTATS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PLANES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CARS_TABLE_NAME);
        onCreate(db);
    }

    public boolean savePlane(String name, String nickname, String year, String plane_country) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLANES_COLUMN_NAME, name);
        contentValues.put(PLANES_COLUMN_NICKNAME, nickname);
        contentValues.put(PLANES_COLUMN_YEAR, year);
        contentValues.put(PLANES_COLUMN_COUNTRY, plane_country);
        db.insert(PLANES_TABLE_NAME, null, contentValues);

        return true;
    }

    public boolean savePlanestats(Integer plane_id, Integer speed, Integer height, Integer range, Integer max_takeoff, Integer wing, Integer firepower, Integer weight1, Integer weight2, Integer weight3, Integer weight4, Integer weight5, Integer weight6){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLANESTATS_COLUMN_PLANEID, plane_id);
        contentValues.put(PLANESTATS_COLUMN_SPEED, speed);
        contentValues.put(PLANESTATS_COLUMN_HEIGHT, height);
        contentValues.put(PLANESTATS_COLUMN_RANGE, range);
        contentValues.put(PLANESTATS_COLUMN_MAXTAKEOFF, max_takeoff);
        contentValues.put(PLANESTATS_COLUMN_WING, wing);
        contentValues.put(PLANESTATS_COLUMN_FIREPOWER, firepower);
        contentValues.put(PLANESTATS_COLUMN_WEIGHT1, weight1);
        contentValues.put(PLANESTATS_COLUMN_WEIGHT2, weight2);
        contentValues.put(PLANESTATS_COLUMN_WEIGHT3, weight3);
        contentValues.put(PLANESTATS_COLUMN_WEIGHT4, weight4);
        contentValues.put(PLANESTATS_COLUMN_WEIGHT5, weight5);
        contentValues.put(PLANESTATS_COLUMN_WEIGHT6, weight6);
        db.insert(PLANESTATS_TABLE_NAME, null, contentValues);

        return true;
    }

    public boolean saveCar(String make, String model, String year, String car_country) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CARS_COLUMN_MAKE, make);
        contentValues.put(CARS_COLUMN_MODEL, model);
        contentValues.put(CARS_COLUMN_YEAR, year);
        contentValues.put(CARS_COLUMN_COUNTRY, car_country);
        db.insert(CARS_TABLE_NAME, null, contentValues);

        return true;
    }

    public boolean saveCarstats(Integer plane_id, Integer speed, Integer accel, Integer power, Integer capacity, Integer cylinders, Integer length, Integer weight1, Integer weight2, Integer weight3, Integer weight4, Integer weight5, Integer weight6){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CARSTATS_COLUMN_CARID, plane_id);
        contentValues.put(CARSTATS_COLUMN_SPEED, speed);
        contentValues.put(CARSTATS_COLUMN_ACCEL, accel);
        contentValues.put(CARSTATS_COLUMN_POWER, power);
        contentValues.put(CARSTATS_COLUMN_CAPACITY, capacity);
        contentValues.put(CARSTATS_COLUMN_CYLINDERS, cylinders);
        contentValues.put(CARSTATS_COLUMN_LENGTH, length);
        contentValues.put(CARSTATS_COLUMN_WEIGHT1, weight1);
        contentValues.put(CARSTATS_COLUMN_WEIGHT2, weight2);
        contentValues.put(CARSTATS_COLUMN_WEIGHT3, weight3);
        contentValues.put(CARSTATS_COLUMN_WEIGHT4, weight4);
        contentValues.put(CARSTATS_COLUMN_WEIGHT5, weight5);
        contentValues.put(CARSTATS_COLUMN_WEIGHT6, weight6);
        db.insert(CARSTATS_TABLE_NAME, null, contentValues);

        return true;
    }

    public ArrayList<Plane> allPlanes() {
        ArrayList<Plane> cards = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT planes.*, planestats.* FROM " + PLANESTATS_TABLE_NAME + " INNER JOIN " + PLANES_TABLE_NAME + " ON planestats.plane_id = planes.id", null);
        while (cursor.moveToNext()) {
            Integer id = cursor.getInt(cursor.getColumnIndex(PLANES_COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(PLANES_COLUMN_NAME));
            String nickname = cursor.getString(cursor.getColumnIndex(PLANES_COLUMN_NICKNAME));
            String year = cursor.getString(cursor.getColumnIndex(PLANES_COLUMN_YEAR));
            String plane_country = cursor.getString(cursor.getColumnIndex(PLANES_COLUMN_COUNTRY));
            Integer speed = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_SPEED));
            Integer height = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_HEIGHT));
            Integer range = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_RANGE));
            Integer takeoff = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_MAXTAKEOFF));
            Integer wing = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_WING));
            Integer firepower = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_FIREPOWER));
            Integer weight1 = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_WEIGHT1));
            Integer weight2 = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_WEIGHT2));
            Integer weight3 = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_WEIGHT3));
            Integer weight4 = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_WEIGHT4));
            Integer weight5 = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_WEIGHT5));
            Integer weight6 = cursor.getInt(cursor.getColumnIndex(PLANESTATS_COLUMN_WEIGHT6));

            Plane plane = new Plane(id, name , nickname, year, plane_country, speed, height, range, takeoff, wing, firepower, weight1, weight2, weight3, weight4, weight5, weight6) {
            };
            cards.add(plane);
        }
            cursor.close();
        return cards;
    }

    public ArrayList<Car> allCars() {
        ArrayList<Car> cards = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + CARS_TABLE_NAME + " ORDER BY " + CARS_COLUMN_MAKE, null);
        while (cursor.moveToNext()) {
            Integer id = cursor.getInt(cursor.getColumnIndex(CARS_COLUMN_ID));
            String make = cursor.getString(cursor.getColumnIndex(CARS_COLUMN_MAKE));
            String model = cursor.getString(cursor.getColumnIndex(CARS_COLUMN_MODEL));
            String year = cursor.getString(cursor.getColumnIndex(CARS_COLUMN_YEAR));
            String car_country = cursor.getString(cursor.getColumnIndex(CARS_COLUMN_COUNTRY));

            Car car = new Car(id, make, model, year, car_country);
            cards.add(car);
        }
        cursor.close();
        return cards;
    }

    public void delete(Integer id) {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = " id = ?";
            String[] values = {id.toString()};
            db.delete(PLANES_TABLE_NAME, sql, values);
        }

    public void checkPlaneDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM planes";
        Cursor cursor = db.rawQuery(count, null);
        cursor.moveToFirst();
        int icount = cursor.getInt(0);
        if (icount == 0) {

            this.savePlane("f4", "Phantom", "1966", "usa");
            this.savePlanestats(1, 1600, 2448, 60000, 27900, 12, 8, 4, 3, 1, 5, 6, 2);
//            this.savePlane("f14", "Tomcat", "1970", "usa");
//            this.savePlane("f15", "Eagle", "1986", "usa");
//            this.savePlane("fa18", "Hornet", "1995", "usa");
//            this.savePlane("f3", "Tornado", "1974", "uk");
//            this.savePlane("su27", "Flanker", "1977", "russia");
//            this.savePlane("f1", "Lightning", "1954", "uk");
//            this.savePlane("mig29", "Fulcrum", "1977", "russia");
//            this.savePlane("c16", "Typhoon", "1994", "uk");
//            this.savePlane("gr7", "Harrier", "1985", "uk");
//            this.savePlane("mig25", "Foxbat", "1970", "russia");
//            this.savePlane("gr1", "Jaguar", "1968", "uk");
//            this.savePlane("s2b", "Buccaneer", "1958", "uk");
        }
        cursor.close();

    }
    public void checkPlanestatsDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String count = "SELECT count(*) FROM planestats";
        Cursor cursor = db.rawQuery(count, null);
        cursor.moveToFirst();
        int icount = cursor.getInt(0);
        if (icount == 0) {

//            this.savePlane("f4", "Phantom", "1966", "usa");
            this.savePlanestats(1, 1600, 2448, 60000, 27900, 12, 8, 4, 3, 1, 5, 6, 2);
//            this.savePlane("f14", "Tomcat", "1970", "usa");
//            this.savePlane("f15", "Eagle", "1986", "usa");
//            this.savePlane("fa18", "Hornet", "1995", "usa");
//            this.savePlane("f3", "Tornado", "1974", "uk");
//            this.savePlane("su27", "Flanker", "1977", "russia");
//            this.savePlane("f1", "Lightning", "1954", "uk");
//            this.savePlane("mig29", "Fulcrum", "1977", "russia");
//            this.savePlane("c16", "Typhoon", "1994", "uk");
//            this.savePlane("gr7", "Harrier", "1985", "uk");
//            this.savePlane("mig25", "Foxbat", "1970", "russia");
//            this.savePlane("gr1", "Jaguar", "1968", "uk");
//            this.savePlane("s2b", "Buccaneer", "1958", "uk");
        }
        cursor.close();

    }




}


