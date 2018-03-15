package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Palico_HelmsDao extends DbManager {
    private static final String TAG = "Palico_HelmsDao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Palico_Helms.allColumns;


    protected Palico_HelmsDao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Palico_Helms LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Palico_Helms.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Palico_Helms palico_helms = new Palico_Helms();
        palico_helms = cursorToPalico_Helms(cursor);

        cursor.close();
        database_close();

        return palico_helms;
    }

    public static ArrayList<Palico_Helms> LoadAllRecords() {
        ArrayList<Palico_Helms> palico_helmsList = new ArrayList<Palico_Helms>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Palico_Helms.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Palico_Helms palico_helms = cursorToPalico_Helms(cursor);
            palico_helmsList.add(palico_helms);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return palico_helmsList;
    }

    public static long insertRecord(Palico_Helms palico_helms) {
        ContentValues values = new ContentValues();
        values = getPalico_HelmsValues(palico_helms);
        database_open();
        long insertId = database.insert(DbSchema.Table_Palico_Helms.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Palico_Helms palico_helms) { 
        ContentValues values = new ContentValues();
        values = getPalico_HelmsValues(palico_helms);
        database_open();
        String[] where = new String[] { String.valueOf(palico_helms.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Palico_Helms.TABLE_NAME , values, DbSchema.Table_Palico_Helms.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Palico_Helms palico_helms) { 
        database_open();
        String[] where = new String[] { String.valueOf(palico_helms.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Palico_Helms.TABLE_NAME , DbSchema.Table_Palico_Helms.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Palico_Helms.TABLE_NAME , DbSchema.Table_Palico_Helms.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getPalico_HelmsValues(Palico_Helms palico_helms) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Palico_Helms.COL__ID, palico_helms.get_Id());
        values.put(DbSchema.Table_Palico_Helms.COL_SETNAME, palico_helms.getSetname());
        values.put(DbSchema.Table_Palico_Helms.COL_DEFENSE, palico_helms.getDefense());
        values.put(DbSchema.Table_Palico_Helms.COL_VSFIRE, palico_helms.getVsfire());
        values.put(DbSchema.Table_Palico_Helms.COL_VSWATER, palico_helms.getVswater());
        values.put(DbSchema.Table_Palico_Helms.COL_VSTHUNDER, palico_helms.getVsthunder());
        values.put(DbSchema.Table_Palico_Helms.COL_VSICE, palico_helms.getVsice());
        values.put(DbSchema.Table_Palico_Helms.COL_VSDRAGON, palico_helms.getVsdragon());

        return values;
    }

    protected static Palico_Helms cursorToPalico_Helms(Cursor cursor)  {
        Palico_Helms palico_helms = new Palico_Helms();

        palico_helms.set_Id(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Helms.COL__ID)));
        palico_helms.setSetname(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Palico_Helms.COL_SETNAME)));
        palico_helms.setDefense(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Helms.COL_DEFENSE)));
        palico_helms.setVsfire(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Helms.COL_VSFIRE)));
        palico_helms.setVswater(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Helms.COL_VSWATER)));
        palico_helms.setVsthunder(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Helms.COL_VSTHUNDER)));
        palico_helms.setVsice(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Helms.COL_VSICE)));
        palico_helms.setVsdragon(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Helms.COL_VSDRAGON)));

        return palico_helms;
    }

    

}

