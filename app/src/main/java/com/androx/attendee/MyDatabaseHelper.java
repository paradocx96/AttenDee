package com.androx.attendee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "attendee";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "attendance";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PNAME = "person_name";
    private static final String COLUMN_DATE_TIME = "date_time";
    private static final String COLUMN_REMARKS = "remarks";

    private static final String EVENT_TABLE_NAME = "event";
    private static final String COLUMN_EVNT_ID = "id";
    private static final String COLUMN_EVNT_NAME = "event_name";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_EVENT_REMARKS = "remarks";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PNAME + " TEXT, "
                + COLUMN_DATE_TIME + " TEXT, "
                + COLUMN_REMARKS + " TEXT,"
                + COLUMN_EVNT_ID + " INTEGER" +
                ");";

        String eventQuery = "CREATE TABLE " + EVENT_TABLE_NAME + " " +
                "("
                + COLUMN_EVNT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EVNT_NAME + " TEXT, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_EVENT_REMARKS + " TEXT" +
                ");";

        db.execSQL(eventQuery);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + EVENT_TABLE_NAME);
        onCreate(db);
    }

    public void addAttendence(Attendance attendance) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PNAME, attendance.getName());
        cv.put(COLUMN_DATE_TIME, attendance.getDateTime());
        cv.put(COLUMN_REMARKS, attendance.getRemarks());

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    Cursor getAllAttendance() { // IT19180526

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = null;
        SQLiteDatabase db = this.getReadableDatabase();

        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public Attendance getSingleAttendance(int id){

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_ID,COLUMN_PNAME,COLUMN_DATE_TIME,COLUMN_REMARKS},
                COLUMN_ID + "= ?",new String[]{String.valueOf(id)},
                null,null,null);

        Attendance attendance;

        if(cursor != null ){
            cursor.moveToFirst();
            attendance = new Attendance(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            return attendance;
        }

        return null;
    }

    public int updateAttendance(Attendance attendance){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_PNAME, attendance.getName());
        contentValues.put(COLUMN_DATE_TIME, attendance.getDateTime());
        contentValues.put(COLUMN_REMARKS, attendance.getRemarks());

        int result = db.update(TABLE_NAME, contentValues,COLUMN_ID+"=?",
                new String[]{String.valueOf(attendance.getId())});

        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

        db.close();
        return result;

    }

    void deleteSingleAttendee(String row_id) { // IT19180526
        SQLiteDatabase db =  this.getWritableDatabase();
        long result = db.delete(TABLE_NAME," id=?", new String[]{String.valueOf(row_id)});

        if (result == -1) {
            Toast.makeText(context,"Failed to Delete!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context,"Successfully Delete!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllAttendee() { // IT19180526
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

    //IT19136820------------------------------------------------------------------------------------------------------------------
    public void addEvent(Event event) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_EVNT_NAME, event.getName());
        contentValues.put(COLUMN_DATE, event.getDate());
        contentValues.put(COLUMN_EVENT_REMARKS, event.getRemarks());

        long result = sqLiteDatabase.insert(EVENT_TABLE_NAME, null, contentValues);
        if (result == -1) {
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added!", Toast.LENGTH_SHORT).show();
        }
        sqLiteDatabase.close();
    }

    Cursor getAllEvents() {

        String query = "SELECT * FROM " + EVENT_TABLE_NAME;
        Cursor cursor = null;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        if (sqLiteDatabase != null) {
            cursor = sqLiteDatabase.rawQuery(query, null);
        }
        return cursor;
    }

    public Event getSingleEvent(int id){

        SQLiteDatabase sQLiteDatabase = getWritableDatabase();

        Cursor cursor = sQLiteDatabase.query(EVENT_TABLE_NAME, new String[]{COLUMN_EVNT_ID,COLUMN_EVNT_NAME,COLUMN_DATE,COLUMN_EVENT_REMARKS},
                COLUMN_ID + "= ?",new String[]{String.valueOf(id)},
                null,null,null);

        Event event;

        if(cursor != null ){
            cursor.moveToFirst();
            event = new Event(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            return event;
        }

        return null;
    }

    public int updateEvent(Event event){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_EVNT_NAME, event.getName());
        contentValues.put(COLUMN_DATE, event.getDate());
        contentValues.put(COLUMN_EVENT_REMARKS, event.getRemarks());

        int result = sqLiteDatabase.update(EVENT_TABLE_NAME, contentValues,COLUMN_EVNT_ID+"=?",
                new String[]{String.valueOf(event.getId())});

        if(result == -1){
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated!", Toast.LENGTH_SHORT).show();
        }

        sqLiteDatabase.close();
        return result;

    }

    void deleteSingleEvent(String row_id) {
        SQLiteDatabase sqLiteDatabase =  this.getWritableDatabase();
        long result = sqLiteDatabase.delete(EVENT_TABLE_NAME," id=?", new String[]{String.valueOf(row_id)});

        if (result == -1) {
            Toast.makeText(context,"Failed!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context,"Deleted!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllEvents() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_NAME);
}
}