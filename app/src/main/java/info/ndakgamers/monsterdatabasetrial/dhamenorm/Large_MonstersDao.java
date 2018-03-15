package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Large_MonstersDao extends DbManager {
    private static final String TAG = "Large_MonstersDao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Large_Monsters.allColumns;


    protected Large_MonstersDao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Large_Monsters LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Large_Monsters.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Large_Monsters large_monsters = new Large_Monsters();
        large_monsters = cursorToLarge_Monsters(cursor);

        cursor.close();
        database_close();

        return large_monsters;
    }

    public static ArrayList<Large_Monsters> LoadAllRecords() {
        ArrayList<Large_Monsters> large_monstersList = new ArrayList<Large_Monsters>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Large_Monsters.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Large_Monsters large_monsters = cursorToLarge_Monsters(cursor);
            large_monstersList.add(large_monsters);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return large_monstersList;
    }

    public static long insertRecord(Large_Monsters large_monsters) {
        ContentValues values = new ContentValues();
        values = getLarge_MonstersValues(large_monsters);
        database_open();
        long insertId = database.insert(DbSchema.Table_Large_Monsters.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Large_Monsters large_monsters) { 
        ContentValues values = new ContentValues();
        values = getLarge_MonstersValues(large_monsters);
        database_open();
        String[] where = new String[] { String.valueOf(large_monsters.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Large_Monsters.TABLE_NAME , values, DbSchema.Table_Large_Monsters.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Large_Monsters large_monsters) { 
        database_open();
        String[] where = new String[] { String.valueOf(large_monsters.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Large_Monsters.TABLE_NAME , DbSchema.Table_Large_Monsters.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Large_Monsters.TABLE_NAME , DbSchema.Table_Large_Monsters.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getLarge_MonstersValues(Large_Monsters large_monsters) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Large_Monsters.COL__ID, large_monsters.get_Id());
        values.put(DbSchema.Table_Large_Monsters.COL_MONSTERNAME, large_monsters.getMonstername());
        values.put(DbSchema.Table_Large_Monsters.COL_ELEMENT, large_monsters.getElement());
        values.put(DbSchema.Table_Large_Monsters.COL_AILMENTS, large_monsters.getAilments());
        values.put(DbSchema.Table_Large_Monsters.COL_WEAKNESS, large_monsters.getWeakness());
        values.put(DbSchema.Table_Large_Monsters.COL_RESISTANCES, large_monsters.getResistances());
        values.put(DbSchema.Table_Large_Monsters.COL_LOCATIONS, large_monsters.getLocations());

        return values;
    }

    protected static Large_Monsters cursorToLarge_Monsters(Cursor cursor)  {
        Large_Monsters large_monsters = new Large_Monsters();

        large_monsters.set_Id(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Large_Monsters.COL__ID)));
        large_monsters.setMonstername(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Large_Monsters.COL_MONSTERNAME)));
        large_monsters.setElement(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Large_Monsters.COL_ELEMENT)));
        large_monsters.setAilments(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Large_Monsters.COL_AILMENTS)));
        large_monsters.setWeakness(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Large_Monsters.COL_WEAKNESS)));
        large_monsters.setResistances(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Large_Monsters.COL_RESISTANCES)));
        large_monsters.setLocations(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Large_Monsters.COL_LOCATIONS)));

        return large_monsters;
    }

    

}

