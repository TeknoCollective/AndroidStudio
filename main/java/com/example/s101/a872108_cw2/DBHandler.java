package com.example.s101.a872108_cw2;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "meetingsDB.db";
    public static final String TABLE_MEETINGS = "meetings";
    public static final String COLUMN_TIME = "time";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_MEETINGS + "(" +
                COLUMN_TIME + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEETINGS);
        onCreate(db);

    }

    //Add row.
    public void addMeeting (Meetings meetings){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TIME, meetings.get_meetingTime());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MEETINGS, null, values);
        db.close();
    }

    //Delete.
    public void deleteMeeting (String timeColumn){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MEETINGS + " WHERE " + COLUMN_TIME + "=\"" + timeColumn + "\";");
    }

    // this is goint in record_TextView in the Main activity.
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_MEETINGS + " WHERE 1";// why not leave out the WHERE  clause?

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        recordSet.moveToFirst();

        while (!recordSet.isAfterLast()) {
            if (recordSet.getString(recordSet.getColumnIndex("time")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("time"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }
}