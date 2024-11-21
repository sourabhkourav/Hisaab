package com.example.hisaab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    // Database Info
    private static final String DATABASE_NAME = "MyDatabase";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_HISAAB = "Hisaab";

    // Hisaab Table Columns
    private static final String FARMER_NAME = "farmerName";
    private static final String DATE = "date";
    private static final String TROLI_WEIGHT = "troliWeight";
    private static final String FACTORY_RATE = "factoryRate";
    private static final String TOTAL_MONEY = "totalMoney";
    private static final String LABOUR_RATE = "labourRate";
    private static final String LABOUR_NAME = "labourName";
    private static final String LABOUR_TOTAL_MONEY = "labourTotalMoney";
    private static final String VEHICLE_NAME = "vehicleName";
    private static final String VEHICLE_DRIVER_NAME = "vehicleDriverName";
    private static final String VEHICLE_RATE = "vehicleRate";
    private static final String VEHICLE_TOTAL_MONEY = "vehicleTotalMoney";

    private static MyDatabaseHelper sInstance;

    public static synchronized MyDatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new MyDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     */
    private MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_HISAAB +
                "(" +
                DATE + " TEXT," +
                FARMER_NAME + " TEXT," +
                TROLI_WEIGHT + " TEXT," +
                FACTORY_RATE + " TEXT," +
                TOTAL_MONEY + " TEXT," +
                LABOUR_NAME + " TEXT," +
                LABOUR_RATE + " TEXT," +
                LABOUR_TOTAL_MONEY + " TEXT," +
                VEHICLE_NAME + " TEXT," +
                VEHICLE_DRIVER_NAME + " TEXT," +
                VEHICLE_RATE + " TEXT," +
                VEHICLE_TOTAL_MONEY + " TEXT" +
                ")";

        db.execSQL(CREATE_USERS_TABLE);
    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISAAB);
            onCreate(db);
        }
    }

    // Insert a FullData into the database
    public void addFullData(FullData data) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(DATE, data.date);
            values.put(FARMER_NAME, data.farmerName);
            values.put(TROLI_WEIGHT, data.troliWeight);
            values.put(FACTORY_RATE, data.factoryRate);
            values.put(TOTAL_MONEY, data.totalMoney);
            values.put(LABOUR_NAME, data.labourName);
            values.put(LABOUR_RATE, data.labourRate);
            values.put(LABOUR_TOTAL_MONEY, data.labourTotalMoney);
            values.put(VEHICLE_NAME, data.vehicle);
            values.put(VEHICLE_DRIVER_NAME, data.driverName);
            values.put(VEHICLE_RATE, data.vehicleRate);
            values.put(VEHICLE_TOTAL_MONEY, data.vehicleTotalMoney);

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_HISAAB, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("insertData", "Error while trying to add FullData to database");
        } finally {
            db.endTransaction();
        }
    }


    // Get all data as FullData from the database
    public List<FullData> getFullData() {
        List<FullData> fullDataArrayList = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String POSTS_SELECT_QUERY =
                String.format("SELECT * FROM %s ",
                        TABLE_HISAAB);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(POSTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    FullData data = new FullData();
                    data.date = cursor.getString(cursor.getColumnIndex(DATE));
                    data.farmerName = cursor.getString(cursor.getColumnIndex(FARMER_NAME));
                    data.troliWeight = cursor.getString(cursor.getColumnIndex(TROLI_WEIGHT));
                    data.factoryRate = cursor.getString(cursor.getColumnIndex(FACTORY_RATE));
                    data.totalMoney = cursor.getString(cursor.getColumnIndex(TOTAL_MONEY));
                    data.labourName = cursor.getString(cursor.getColumnIndex(LABOUR_NAME));
                    data.labourRate = cursor.getString(cursor.getColumnIndex(LABOUR_RATE));
                    data.labourTotalMoney = cursor.getString(cursor.getColumnIndex(LABOUR_TOTAL_MONEY));
                    data.vehicle = cursor.getString(cursor.getColumnIndex(VEHICLE_NAME));
                    data.driverName = cursor.getString(cursor.getColumnIndex(VEHICLE_DRIVER_NAME));
                    data.vehicleRate = cursor.getString(cursor.getColumnIndex(VEHICLE_RATE));
                    data.vehicleTotalMoney = cursor.getString(cursor.getColumnIndex(VEHICLE_TOTAL_MONEY));
                    fullDataArrayList.add(data);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d("output", "Error while trying to get FullData from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return fullDataArrayList;
    }

//    // Update the user's profile picture url
//    public int updateUserProfilePicture(User user) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_USER_PROFILE_PICTURE_URL, user.profilePictureUrl);
//
//        // Updating profile picture url for user with that userName
//        return db.update(TABLE_USERS, values, KEY_USER_NAME + " = ?",
//                new String[] { String.valueOf(user.userName) });
//    }

    // Delete all posts and users in the database
    public void deleteAllData() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            // Order of deletions is important when foreign key relationships exist.
            db.delete(TABLE_HISAAB, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("delete", "Error while trying to delete all Data ");
        } finally {
            db.endTransaction();
        }
    }
}
