package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Palico_ArmorDao extends DbManager {
    private static final String TAG = "Palico_ArmorDao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Palico_Armor.allColumns;


    protected Palico_ArmorDao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Palico_Armor LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Palico_Armor.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Palico_Armor palico_armor = new Palico_Armor();
        palico_armor = cursorToPalico_Armor(cursor);

        cursor.close();
        database_close();

        return palico_armor;
    }

    public static ArrayList<Palico_Armor> LoadAllRecords() {
        ArrayList<Palico_Armor> palico_armorList = new ArrayList<Palico_Armor>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Palico_Armor.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Palico_Armor palico_armor = cursorToPalico_Armor(cursor);
            palico_armorList.add(palico_armor);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return palico_armorList;
    }

    public static long insertRecord(Palico_Armor palico_armor) {
        ContentValues values = new ContentValues();
        values = getPalico_ArmorValues(palico_armor);
        database_open();
        long insertId = database.insert(DbSchema.Table_Palico_Armor.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Palico_Armor palico_armor) { 
        ContentValues values = new ContentValues();
        values = getPalico_ArmorValues(palico_armor);
        database_open();
        String[] where = new String[] { String.valueOf(palico_armor.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Palico_Armor.TABLE_NAME , values, DbSchema.Table_Palico_Armor.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Palico_Armor palico_armor) { 
        database_open();
        String[] where = new String[] { String.valueOf(palico_armor.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Palico_Armor.TABLE_NAME , DbSchema.Table_Palico_Armor.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Palico_Armor.TABLE_NAME , DbSchema.Table_Palico_Armor.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getPalico_ArmorValues(Palico_Armor palico_armor) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Palico_Armor.COL__ID, palico_armor.get_Id());
        values.put(DbSchema.Table_Palico_Armor.COL_SETNAME, palico_armor.getSetname());
        values.put(DbSchema.Table_Palico_Armor.COL_DEFENSE, palico_armor.getDefense());
        values.put(DbSchema.Table_Palico_Armor.COL_VSFIRE, palico_armor.getVsfire());
        values.put(DbSchema.Table_Palico_Armor.COL_VSWATER, palico_armor.getVswater());
        values.put(DbSchema.Table_Palico_Armor.COL_VSTHUNDER, palico_armor.getVsthunder());
        values.put(DbSchema.Table_Palico_Armor.COL_VSICE, palico_armor.getVsice());
        values.put(DbSchema.Table_Palico_Armor.COL_VSDRAGON, palico_armor.getVsdragon());

        return values;
    }

    protected static Palico_Armor cursorToPalico_Armor(Cursor cursor)  {
        Palico_Armor palico_armor = new Palico_Armor();

        palico_armor.set_Id(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Armor.COL__ID)));
        palico_armor.setSetname(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Palico_Armor.COL_SETNAME)));
        palico_armor.setDefense(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Armor.COL_DEFENSE)));
        palico_armor.setVsfire(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Armor.COL_VSFIRE)));
        palico_armor.setVswater(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Armor.COL_VSWATER)));
        palico_armor.setVsthunder(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Armor.COL_VSTHUNDER)));
        palico_armor.setVsice(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Armor.COL_VSICE)));
        palico_armor.setVsdragon(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Armor.COL_VSDRAGON)));

        return palico_armor;
    }

    

}

