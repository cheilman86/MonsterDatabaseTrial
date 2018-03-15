package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Mantles1Dao extends DbManager {
    private static final String TAG = "Mantles1Dao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Mantles1.allColumns;


    protected Mantles1Dao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Mantles1 LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Mantles1.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Mantles1 mantles1 = new Mantles1();
        mantles1 = cursorToMantles1(cursor);

        cursor.close();
        database_close();

        return mantles1;
    }

    public static ArrayList<Mantles1> LoadAllRecords() {
        ArrayList<Mantles1> mantles1List = new ArrayList<Mantles1>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Mantles1.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Mantles1 mantles1 = cursorToMantles1(cursor);
            mantles1List.add(mantles1);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return mantles1List;
    }

    public static long insertRecord(Mantles1 mantles1) {
        ContentValues values = new ContentValues();
        values = getMantles1Values(mantles1);
        database_open();
        long insertId = database.insert(DbSchema.Table_Mantles1.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Mantles1 mantles1) { 
        ContentValues values = new ContentValues();
        values = getMantles1Values(mantles1);
        database_open();
        String[] where = new String[] { String.valueOf(mantles1.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Mantles1.TABLE_NAME , values, DbSchema.Table_Mantles1.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Mantles1 mantles1) { 
        database_open();
        String[] where = new String[] { String.valueOf(mantles1.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Mantles1.TABLE_NAME , DbSchema.Table_Mantles1.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Mantles1.TABLE_NAME , DbSchema.Table_Mantles1.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getMantles1Values(Mantles1 mantles1) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Mantles1.COL__ID, mantles1.get_Id());
        values.put(DbSchema.Table_Mantles1.COL_NAME, mantles1.getName());
        values.put(DbSchema.Table_Mantles1.COL_DESCRIPTION, mantles1.getDescription());

        return values;
    }

    protected static Mantles1 cursorToMantles1(Cursor cursor)  {
        Mantles1 mantles1 = new Mantles1();

        mantles1.set_Id(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Mantles1.COL__ID)));
        mantles1.setName(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Mantles1.COL_NAME)));
        mantles1.setDescription(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Mantles1.COL_DESCRIPTION)));

        return mantles1;
    }

    

}

