package com.example.datereminder.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.datereminder.Fragments.SearchFragment;
import com.example.datereminder.MainActivity;

import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CATEGORIES_TABLE = "Categories";
    private static final String DATEITEM_TABLE = "DateItem";
    //columns in Categories
    private static final String CATEGORIES_TABLE_1 = "categories_id";
    private static final String CATEGORIES_TABLE_2 = "name";
    private static final String CATEGORIES_TABLE_3 = "description";
    private static final String CATEGORIES_TABLE_4 = "remindTime";
    private static final String CATEGORIES_TABLE_5 = "notificationDate";
    private static final String CATEGORIES_TABLE_6 = "color";
    //columns in DateItem
    private static final String DATEITEM_TABLE_1 = "id";
    private static final String DATEITEM_TABLE_2 = "name";
    private static final String DATEITEM_TABLE_3 = "description";
    private static final String DATEITEM_TABLE_4 = "datetimelong";
    private static final String DATEITEM_TABLE_5 = "categories_id";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    private static SQLiteDatabase db;
    private static Context mContext;


    public DatabaseHelper(Context context) {
        super(context, DATEITEM_TABLE, null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + CATEGORIES_TABLE + "(" + CATEGORIES_TABLE_1 + " INTEGER NOT NULL, " + CATEGORIES_TABLE_2 + " TEXT, " + CATEGORIES_TABLE_3 + " TEXT, " + CATEGORIES_TABLE_4 + " INTEGER, " + CATEGORIES_TABLE_5 + " INTEGER, " + CATEGORIES_TABLE_6 + " TEXT); ";
        //String createTable2= "CREATE TABLE " + DATEITEM_TABLE + "(" + SCOL1 + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + SCOL2 + " TEXT ); ";
        db.execSQL(createTable);
        //db.execSQL(createTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String asd = "DROP IF TABLE EXISTS ";
        db.execSQL(asd + CATEGORIES_TABLE);
        db.execSQL(asd + DATEITEM_TABLE);
        onCreate(db);
    }

    public void createDatabase() {
        db = SQLiteDatabase.openDatabase(mContext.getApplicationContext().getFilesDir().getAbsolutePath() + "/DATABASE.db", null, SQLiteDatabase.OPEN_READWRITE);
    }

    public ArrayList<DateItem> readDateItem() {
        ArrayList<DateItem> results = new ArrayList<>();
        //SQLiteDatabase db = this.getReadableDatabase();

        // Select All Query
        String selectQuery = "SELECT * FROM " + DATEITEM_TABLE + ";";
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                try {
                    int DATA1 = cursor.getInt(cursor.getColumnIndex(DATEITEM_TABLE_1));
                    String DATA2 = cursor.getString(cursor.getColumnIndex(DATEITEM_TABLE_2));
                    String DATA3 = cursor.getString(cursor.getColumnIndex(DATEITEM_TABLE_3));
                    long DATA4 = cursor.getLong(cursor.getColumnIndex(DATEITEM_TABLE_4));
                    int DATA5 = cursor.getInt(cursor.getColumnIndex(DATEITEM_TABLE_5));

                    results.add(new DateItem(DATA1, DATA2, DATA3, DATA4, DATA5));
                } catch (Exception e) {
                    Log.e("Error", "Error");
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        if (results.size() == 0)
            return null;
        else {
            return results;
        }
    }

    public ArrayList<DateItem> SearchDateItemTable(String value) {

        // Search Query

        String searchQuery = "SELECT * FROM " + DATEITEM_TABLE + " WHERE " + DATEITEM_TABLE_2 + " LIKE " + "'%" + value + "%' OR " + DATEITEM_TABLE_3 + " LIKE " + "'%" + value + "%';";
        Cursor cursor = db.rawQuery(searchQuery, null);
        return DateItemCursorParser(cursor);
    }

    public ArrayList<DateItem> ReturnDateItemByID(String value) {

        // Search Query

        String searchQuery = "SELECT * FROM " + DATEITEM_TABLE + " WHERE " + DATEITEM_TABLE_1 + " = " + "'" + value + "'" + ";";
        Cursor cursor = db.rawQuery(searchQuery, null);
        return DateItemCursorParser(cursor);
    }

    public ArrayList<Categories> readCategoriesTable() {

        // Select All Query
        String selectQuery = "SELECT * FROM " + CATEGORIES_TABLE + ";";
        Cursor cursor = db.rawQuery(selectQuery, null);
        return CategoriesCursorParser(cursor);


    }

    public ArrayList<Categories> SearchCategoriesTable(String value) {

        // Search Query

        String searchQuery = "SELECT * FROM " + CATEGORIES_TABLE + " WHERE " + CATEGORIES_TABLE_2 + " LIKE " + "'%" + value + "%'" + ";";
        Cursor cursor = db.rawQuery(searchQuery, null);
        return CategoriesCursorParser(cursor);
    }

    public ArrayList<Categories> ReturnCategoryByID(String value) {

        // Search Query

        String searchQuery = "SELECT * FROM " + CATEGORIES_TABLE + " WHERE " + CATEGORIES_TABLE_1 + " = " + "'" + value + "'" + ";";
        Cursor cursor = db.rawQuery(searchQuery, null);
        return CategoriesCursorParser(cursor);
    }

    private ArrayList<Categories> CategoriesCursorParser(Cursor cursor) {

        ArrayList<Categories> results = new ArrayList<>();

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                try {
                    int DATA1 = cursor.getInt(cursor.getColumnIndex(CATEGORIES_TABLE_1));
                    String DATA2 = cursor.getString(cursor.getColumnIndex(CATEGORIES_TABLE_2));
                    String DATA3 = cursor.getString(cursor.getColumnIndex(CATEGORIES_TABLE_3));
                    int DATA4 = cursor.getInt(cursor.getColumnIndex(CATEGORIES_TABLE_4));
                    int DATA5 = cursor.getInt(cursor.getColumnIndex(CATEGORIES_TABLE_5));
                    String DATA6 = cursor.getString(cursor.getColumnIndex(CATEGORIES_TABLE_6));


                    results.add(new Categories(DATA1, DATA2, DATA3, DATA4, DATA5, DATA6));
                } catch (Exception e) {
                    Log.e("Error", "Error");
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        if (results.size() == 0)
            return null;
        else {
            return results;
        }

    }

    private ArrayList<DateItem> DateItemCursorParser(Cursor cursor) {

        ArrayList<DateItem> results = new ArrayList<>();

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                try {
                    int DATA1 = cursor.getInt(cursor.getColumnIndex(DATEITEM_TABLE_1));
                    String DATA2 = cursor.getString(cursor.getColumnIndex(DATEITEM_TABLE_2));
                    String DATA3 = cursor.getString(cursor.getColumnIndex(DATEITEM_TABLE_3));
                    long DATA4 = cursor.getLong(cursor.getColumnIndex(DATEITEM_TABLE_4));
                    int DATA5 = cursor.getInt(cursor.getColumnIndex(DATEITEM_TABLE_5));


                    results.add(new DateItem(DATA1, DATA2, DATA3, DATA4, DATA5));
                } catch (Exception e) {
                    Log.e("Error", "Error");
                }

            } while (cursor.moveToNext());
        }
        cursor.close();
        if (results.size() == 0)
            return null;
        else {
            return results;
        }

    }


}
