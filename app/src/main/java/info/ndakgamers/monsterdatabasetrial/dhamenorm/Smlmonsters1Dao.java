package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Smlmonsters1Dao extends DbManager {
    private static final String TAG = "Smlmonsters1Dao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Smlmonsters1.allColumns;


    protected Smlmonsters1Dao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Smlmonsters1 LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Smlmonsters1.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Smlmonsters1 smlmonsters1 = new Smlmonsters1();
        smlmonsters1 = cursorToSmlmonsters1(cursor);

        cursor.close();
        database_close();

        return smlmonsters1;
    }

    public static ArrayList<Smlmonsters1> LoadAllRecords() {
        ArrayList<Smlmonsters1> smlmonsters1List = new ArrayList<Smlmonsters1>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Smlmonsters1.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Smlmonsters1 smlmonsters1 = cursorToSmlmonsters1(cursor);
            smlmonsters1List.add(smlmonsters1);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return smlmonsters1List;
    }

    public static long insertRecord(Smlmonsters1 smlmonsters1) {
        ContentValues values = new ContentValues();
        values = getSmlmonsters1Values(smlmonsters1);
        database_open();
        long insertId = database.insert(DbSchema.Table_Smlmonsters1.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Smlmonsters1 smlmonsters1) { 
        ContentValues values = new ContentValues();
        values = getSmlmonsters1Values(smlmonsters1);
        database_open();
        String[] where = new String[] { String.valueOf(smlmonsters1.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Smlmonsters1.TABLE_NAME , values, DbSchema.Table_Smlmonsters1.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Smlmonsters1 smlmonsters1) { 
        database_open();
        String[] where = new String[] { String.valueOf(smlmonsters1.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Smlmonsters1.TABLE_NAME , DbSchema.Table_Smlmonsters1.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Smlmonsters1.TABLE_NAME , DbSchema.Table_Smlmonsters1.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getSmlmonsters1Values(Smlmonsters1 smlmonsters1) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Smlmonsters1.COL__ID, smlmonsters1.get_Id());
        values.put(DbSchema.Table_Smlmonsters1.COL_MONSTERNAME, smlmonsters1.getMonstername());
        values.put(DbSchema.Table_Smlmonsters1.COL_ELEMENT, smlmonsters1.getElement());
        values.put(DbSchema.Table_Smlmonsters1.COL_AILMENTS, smlmonsters1.getAilments());
        values.put(DbSchema.Table_Smlmonsters1.COL_WEAKNESS, smlmonsters1.getWeakness());
        values.put(DbSchema.Table_Smlmonsters1.COL_RESISTANCES, smlmonsters1.getResistances());
        values.put(DbSchema.Table_Smlmonsters1.COL_LOCATIONS, smlmonsters1.getLocations());

        return values;
    }

    protected static Smlmonsters1 cursorToSmlmonsters1(Cursor cursor)  {
        Smlmonsters1 smlmonsters1 = new Smlmonsters1();

        smlmonsters1.set_Id(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smlmonsters1.COL__ID)));
        smlmonsters1.setMonstername(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smlmonsters1.COL_MONSTERNAME)));
        smlmonsters1.setElement(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smlmonsters1.COL_ELEMENT)));
        smlmonsters1.setAilments(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smlmonsters1.COL_AILMENTS)));
        smlmonsters1.setWeakness(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smlmonsters1.COL_WEAKNESS)));
        smlmonsters1.setResistances(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smlmonsters1.COL_RESISTANCES)));
        smlmonsters1.setLocations(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smlmonsters1.COL_LOCATIONS)));

        return smlmonsters1;
    }

    

}

