package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Armor_SetsDao extends DbManager {
    private static final String TAG = "Armor_SetsDao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Armor_Sets.allColumns;


    protected Armor_SetsDao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Armor_Sets LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Armor_Sets.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Armor_Sets armor_sets = new Armor_Sets();
        armor_sets = cursorToArmor_Sets(cursor);

        cursor.close();
        database_close();

        return armor_sets;
    }

    public static ArrayList<Armor_Sets> LoadAllRecords() {
        ArrayList<Armor_Sets> armor_setsList = new ArrayList<Armor_Sets>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Armor_Sets.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Armor_Sets armor_sets = cursorToArmor_Sets(cursor);
            armor_setsList.add(armor_sets);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return armor_setsList;
    }

    public static long insertRecord(Armor_Sets armor_sets) {
        ContentValues values = new ContentValues();
        values = getArmor_SetsValues(armor_sets);
        database_open();
        long insertId = database.insert(DbSchema.Table_Armor_Sets.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Armor_Sets armor_sets) { 
        ContentValues values = new ContentValues();
        values = getArmor_SetsValues(armor_sets);
        database_open();
        String[] where = new String[] { String.valueOf(armor_sets.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Armor_Sets.TABLE_NAME , values, DbSchema.Table_Armor_Sets.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Armor_Sets armor_sets) { 
        database_open();
        String[] where = new String[] { String.valueOf(armor_sets.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Armor_Sets.TABLE_NAME , DbSchema.Table_Armor_Sets.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Armor_Sets.TABLE_NAME , DbSchema.Table_Armor_Sets.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getArmor_SetsValues(Armor_Sets armor_sets) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Armor_Sets.COL__ID, armor_sets.get_Id());
        values.put(DbSchema.Table_Armor_Sets.COL_SETNAME, armor_sets.getSetname());
        values.put(DbSchema.Table_Armor_Sets.COL_DEFENSE, armor_sets.getDefense());
        values.put(DbSchema.Table_Armor_Sets.COL_VSFIRE, armor_sets.getVsfire());
        values.put(DbSchema.Table_Armor_Sets.COL_VSWATER, armor_sets.getVswater());
        values.put(DbSchema.Table_Armor_Sets.COL_VSTHUNDER, armor_sets.getVsthunder());
        values.put(DbSchema.Table_Armor_Sets.COL_VSICE, armor_sets.getVsice());
        values.put(DbSchema.Table_Armor_Sets.COL_VSDRAGON, armor_sets.getVsdragon());
        values.put(DbSchema.Table_Armor_Sets.COL_SETBONUS, armor_sets.getSetbonus());
        values.put(DbSchema.Table_Armor_Sets.COL_SETSKILL, armor_sets.getSetskill());

        return values;
    }

    protected static Armor_Sets cursorToArmor_Sets(Cursor cursor)  {
        Armor_Sets armor_sets = new Armor_Sets();

        armor_sets.set_Id(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL__ID)));
        armor_sets.setSetname(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL_SETNAME)));
        armor_sets.setDefense(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL_DEFENSE)));
        armor_sets.setVsfire(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL_VSFIRE)));
        armor_sets.setVswater(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL_VSWATER)));
        armor_sets.setVsthunder(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL_VSTHUNDER)));
        armor_sets.setVsice(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL_VSICE)));
        armor_sets.setVsdragon(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL_VSDRAGON)));
        armor_sets.setSetbonus(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL_SETBONUS)));
        armor_sets.setSetskill(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Armor_Sets.COL_SETSKILL)));

        return armor_sets;
    }

    

}

