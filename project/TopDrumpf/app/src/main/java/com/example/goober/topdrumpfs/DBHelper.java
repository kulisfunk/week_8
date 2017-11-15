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

import static com.example.goober.topdrumpfs.AndroidDatabaseManager.indexInfo.index;
import static com.example.goober.topdrumpfs.R.id.firepower;
import static com.example.goober.topdrumpfs.R.id.range;
import static com.example.goober.topdrumpfs.R.id.speed;
import static com.example.goober.topdrumpfs.R.id.wing;


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
        super(context, DATABASE_NAME, null, 4);
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
//        Cursor cursor = db.rawQuery("SELECT * FROM " + PLANES_TABLE_NAME, null);
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

//            Plane plane = new Plane(id, name , nickname, year, plane_country) {

            Plane plane = new Plane(id, name , nickname, year, plane_country, speed, height, range, takeoff, wing, firepower, weight1, weight2, weight3, weight4, weight5, weight6) {
            };
            cards.add(plane);
        }
            cursor.close();
        return cards;
    }
    public ArrayList<Plane> singlePlane(Integer index) {
        ArrayList<Plane> card = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + PLANES_TABLE_NAME, null);
        Cursor cursor = db.rawQuery("SELECT planes.*, planestats.* FROM " + PLANESTATS_TABLE_NAME + " INNER JOIN " + PLANES_TABLE_NAME + " ON planestats.plane_id = planes.id WHERE planes.id = " + index, null);
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
            card.add(plane);
        }
        cursor.close();
        return card;
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
            this.savePlane("f14", "Tomcat", "1970", "usa");
            this.savePlane("f15", "Eagle", "1986", "usa");
            this.savePlane("fa18", "Hornet", "1995", "usa");
            this.savePlane("f3", "Tornado", "1974", "uk");
            this.savePlane("su27", "Flanker", "1977", "russia");
            this.savePlane("f1", "Lightning", "1954", "uk");
            this.savePlane("mig29", "Fulcrum", "1977", "russia");
            this.savePlane("fgr4", "Typhoon", "1994", "uk");
            this.savePlane("gr7", "Harrier", "1985", "uk");
            this.savePlane("mig25", "Foxbat", "1970", "russia");
            this.savePlane("gr1", "Jaguar", "1968", "uk");
            this.savePlane("s2b", "Buccaneer", "1958", "uk");
            this.savePlane("su57", "Flatfish", "2010", "russia");
            this.savePlane("f22", "Raptor", "1997", "usa");
            this.savePlane("f35", "Lightning II", "2006", "usa");
            this.savePlane("j10", "Firebird", "1998", "china");
            this.savePlane("a10", "Thunderbolt", "1972", "usa");
            this.savePlane("d", "Rafale", "1991", "france");
            this.savePlane("mig23", "Flogger", "1967", "russia");
            this.savePlane("jas39", "Gripen", "1978", "sweden");
            this.savePlane("f117a", "Nighthawk", "1981", "usa");
            this.savePlane("yf23", "Blackwidow II", "1990", "usa");
            this.savePlane("mig35", "Fulcrum-F", "2007", "russia");
            this.savePlane("t38", "Talon", "1959", "usa");
            this.savePlane("f16", "Falcon", "1974", "usa");
            this.savePlane("ba167", "Strikemaster", "1967", "uk");
            this.savePlane("g8", "Mirage G", "1967", "france");
            this.savePlane("aj37", "Viggen", "1967", "sweden");
            this.savePlane("fiat", "G.91", "1956", "italy");
            this.savePlane("a7", "Corsair II", "1965", "usa");
            this.savePlane("f104", "Starfighter", "1956", "usa");
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

            this.savePlanestats(1, 1600, 60000, 2448, 27900, 1170, 80, 3, 0, 0, 0, 0, 0);
            this.savePlanestats(2, 1544, 50000, 1840, 33720, 1955, 60, 5, 0, 0, 0, 0, 0);
            this.savePlanestats(3, 1650, 64900, 3450, 30845, 1305, 81, 3, 0, 0, 0, 0, 0);
            this.savePlanestats(4, 1190, 51000, 2071, 23541, 1230, 91, 6, 0, 0, 0, 0, 0);
            this.savePlanestats(5, 1490, 49000, 2650, 27986, 1391, 61, 3, 0, 0, 0, 0, 0);
            this.savePlanestats(6, 1550, 62523, 2193, 30450, 1470, 82, 4, 0, 0, 0, 0, 0);
            this.savePlanestats(7, 1300, 54000, 1270, 20752, 1060, 62, 2, 0, 0, 0, 0, 0);
            this.savePlanestats(8, 1490, 59100, 1300, 18000, 1136, 70, 1, 0, 0, 0, 0, 0);
            this.savePlanestats(9, 1550, 65000, 2350, 23500, 1095, 99, 6, 0, 0, 0, 0, 0);
            this.savePlanestats(10, 662, 50500, 2015, 14061, 925, 9, 30, 0, 0, 0, 0, 0);
            this.savePlanestats(11, 2170, 67915, 1390, 36720, 1401, 59, 1, 0, 0, 0, 0, 0);
            this.savePlanestats(12, 1056, 45900, 2190, 15700, 868, 69, 3, 0, 0, 0, 0, 0);
            this.savePlanestats(13, 667, 40000, 2300, 28000, 1341, 58, 3, 0, 0, 0, 0, 0);
            this.savePlanestats(14, 1320, 65100, 2175, 35000, 1395, 93, 4, 0, 0, 0, 0, 0);
            this.savePlanestats(15, 1500, 65000, 2000, 38000, 1356, 85, 4, 0, 0, 0, 0, 0);
            this.savePlanestats(16, 1200, 49300, 1379, 31800, 1070, 100, 6, 0, 0, 0, 0, 0);
            this.savePlanestats(17, 1492, 59055, 1150, 19277, 975, 76, 1, 0, 0, 0, 0, 0);
            this.savePlanestats(18, 439, 45000, 2580, 23000, 1753, 98, 6, 0, 0, 0, 0, 0);
            this.savePlanestats(19, 1188, 50200, 2000, 24500, 1080, 110, 6, 0, 0, 0, 0, 0);
            this.savePlanestats(20, 1168, 60695, 1750, 17800, 1396, 63, 2, 0, 0, 0, 0, 0);
            this.savePlanestats(21, 1370, 50300, 1983, 14000, 840, 83, 1, 0, 0, 0, 0, 0);
            this.savePlanestats(22, 617, 45100, 1720, 23800, 1321, 109, 6, 0, 0, 0, 0, 0);
            this.savePlanestats(23, 1450, 64800, 2790, 29000, 1330, 63, 2, 0, 0, 0, 0, 0);
            this.savePlanestats(24, 1490, 62340, 1930, 29700, 1200, 90, 1, 0, 0, 0, 0, 0);
            this.savePlanestats(25, 858, 50600, 1140, 5485, 770, 41, 2, 0, 0, 0, 0, 0);
            this.savePlanestats(26, 1320, 50150, 2620, 19200, 996, 82, 3 ,0 ,0, 0, 0, 0);
            this.savePlanestats(27, 481, 40400, 1382, 5215, 1123, 51, 3, 0, 0, 0, 0, 0);
            this.savePlanestats(28, 1492, 60700, 2392, 20000, 1540, 73, 1, 0, 0, 0, 0, 0);
            this.savePlanestats(29, 1386, 59100, 1242, 20000, 1060, 65, 1, 0, 0, 0, 0, 0);
            this.savePlanestats(30, 668, 43000, 715, 5500, 856, 66, 2, 0 , 0, 0, 0, 0);
            this.savePlanestats(31, 690, 42000, 1544, 19050, 1180, 87, 6, 0, 0, 0, 0, 0);
            this.savePlanestats(32, 1528, 49990, 1630, 13166, 663, 65, 1, 0, 0, 0, 0, 0);
        }
        cursor.close();

    }




}


