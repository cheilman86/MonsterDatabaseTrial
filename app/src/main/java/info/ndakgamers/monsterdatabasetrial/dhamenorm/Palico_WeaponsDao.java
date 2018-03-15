package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Palico_WeaponsDao extends DbManager {
    private static final String TAG = "Palico_WeaponsDao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Palico_Weapons.allColumns;


    protected Palico_WeaponsDao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Palico_Weapons LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Palico_Weapons.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Palico_Weapons palico_weapons = new Palico_Weapons();
        palico_weapons = cursorToPalico_Weapons(cursor);

        cursor.close();
        database_close();

        return palico_weapons;
    }

    public static ArrayList<Palico_Weapons> LoadAllRecords() {
        ArrayList<Palico_Weapons> palico_weaponsList = new ArrayList<Palico_Weapons>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Palico_Weapons.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Palico_Weapons palico_weapons = cursorToPalico_Weapons(cursor);
            palico_weaponsList.add(palico_weapons);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return palico_weaponsList;
    }

    public static long insertRecord(Palico_Weapons palico_weapons) {
        ContentValues values = new ContentValues();
        values = getPalico_WeaponsValues(palico_weapons);
        database_open();
        long insertId = database.insert(DbSchema.Table_Palico_Weapons.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Palico_Weapons palico_weapons) { 
        ContentValues values = new ContentValues();
        values = getPalico_WeaponsValues(palico_weapons);
        database_open();
        String[] where = new String[] { String.valueOf(palico_weapons.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Palico_Weapons.TABLE_NAME , values, DbSchema.Table_Palico_Weapons.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Palico_Weapons palico_weapons) { 
        database_open();
        String[] where = new String[] { String.valueOf(palico_weapons.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Palico_Weapons.TABLE_NAME , DbSchema.Table_Palico_Weapons.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Palico_Weapons.TABLE_NAME , DbSchema.Table_Palico_Weapons.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getPalico_WeaponsValues(Palico_Weapons palico_weapons) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Palico_Weapons.COL__ID, palico_weapons.get_Id());
        values.put(DbSchema.Table_Palico_Weapons.COL_SETNAME, palico_weapons.getSetname());
        values.put(DbSchema.Table_Palico_Weapons.COL_DEFENSE, palico_weapons.getDefense());
        values.put(DbSchema.Table_Palico_Weapons.COL_VSFIRE, palico_weapons.getVsfire());
        values.put(DbSchema.Table_Palico_Weapons.COL_VSWATER, palico_weapons.getVswater());
        values.put(DbSchema.Table_Palico_Weapons.COL_VSTHUNDER, palico_weapons.getVsthunder());
        values.put(DbSchema.Table_Palico_Weapons.COL_VSICE, palico_weapons.getVsice());
        values.put(DbSchema.Table_Palico_Weapons.COL_VSDRAGON, palico_weapons.getVsdragon());

        return values;
    }

    protected static Palico_Weapons cursorToPalico_Weapons(Cursor cursor)  {
        Palico_Weapons palico_weapons = new Palico_Weapons();

        palico_weapons.set_Id(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Weapons.COL__ID)));
        palico_weapons.setSetname(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Palico_Weapons.COL_SETNAME)));
        palico_weapons.setDefense(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Weapons.COL_DEFENSE)));
        palico_weapons.setVsfire(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Weapons.COL_VSFIRE)));
        palico_weapons.setVswater(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Weapons.COL_VSWATER)));
        palico_weapons.setVsthunder(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Weapons.COL_VSTHUNDER)));
        palico_weapons.setVsice(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Weapons.COL_VSICE)));
        palico_weapons.setVsdragon(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Weapons.COL_VSDRAGON)));

        return palico_weapons;
    }

    

}

