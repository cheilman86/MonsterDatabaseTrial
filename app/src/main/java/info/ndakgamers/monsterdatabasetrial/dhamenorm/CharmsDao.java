package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CharmsDao extends DbManager {
    private static final String TAG = "CharmsDao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Charms.allColumns;


    protected CharmsDao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Charms LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Charms.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Charms charms = new Charms();
        charms = cursorToCharms(cursor);

        cursor.close();
        database_close();

        return charms;
    }

    public static ArrayList<Charms> LoadAllRecords() {
        ArrayList<Charms> charmsList = new ArrayList<Charms>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Charms.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Charms charms = cursorToCharms(cursor);
            charmsList.add(charms);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return charmsList;
    }

    public static long insertRecord(Charms charms) {
        ContentValues values = new ContentValues();
        values = getCharmsValues(charms);
        database_open();
        long insertId = database.insert(DbSchema.Table_Charms.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Charms charms) { 
        ContentValues values = new ContentValues();
        values = getCharmsValues(charms);
        database_open();
        String[] where = new String[] { String.valueOf(charms.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Charms.TABLE_NAME , values, DbSchema.Table_Charms.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Charms charms) { 
        database_open();
        String[] where = new String[] { String.valueOf(charms.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Charms.TABLE_NAME , DbSchema.Table_Charms.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Charms.TABLE_NAME , DbSchema.Table_Charms.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getCharmsValues(Charms charms) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Charms.COL__ID, charms.get_Id());
        values.put(DbSchema.Table_Charms.COL_RARITY, charms.getRarity());
        values.put(DbSchema.Table_Charms.COL_NAME, charms.getName());
        values.put(DbSchema.Table_Charms.COL_EFFECT, charms.getEffect());

        return values;
    }

    protected static Charms cursorToCharms(Cursor cursor)  {
        Charms charms = new Charms();

        charms.set_Id(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Charms.COL__ID)));
        charms.setRarity(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Charms.COL_RARITY)));
        charms.setName(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Charms.COL_NAME)));
        charms.setEffect(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Charms.COL_EFFECT)));

        return charms;
    }

    

}

