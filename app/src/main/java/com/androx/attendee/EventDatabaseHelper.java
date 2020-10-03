package com.androx.attendee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class EventDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "attendee";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "event";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EVNT_NAME = "event_name";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_REMARKS = "remarks";

    EventDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EVNT_NAME + " TEXT, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_REMARKS + " TEXT" +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public void addEvent(Event event) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_EVNT_NAME, event.getName());
        contentValues.put(COLUMN_DATE, event.getDate());
        contentValues.put(COLUMN_REMARKS, event.getRemarks());

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
        sqLiteDatabase.close();
    }
}
