package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Palico_GadgetsDao extends DbManager {
    private static final String TAG = "Palico_GadgetsDao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Palico_Gadgets.allColumns;


    protected Palico_GadgetsDao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Palico_Gadgets LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Palico_Gadgets.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Palico_Gadgets palico_gadgets = new Palico_Gadgets();
        palico_gadgets = cursorToPalico_Gadgets(cursor);

        cursor.close();
        database_close();

        return palico_gadgets;
    }

    public static ArrayList<Palico_Gadgets> LoadAllRecords() {
        ArrayList<Palico_Gadgets> palico_gadgetsList = new ArrayList<Palico_Gadgets>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Palico_Gadgets.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Palico_Gadgets palico_gadgets = cursorToPalico_Gadgets(cursor);
            palico_gadgetsList.add(palico_gadgets);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return palico_gadgetsList;
    }

    public static long insertRecord(Palico_Gadgets palico_gadgets) {
        ContentValues values = new ContentValues();
        values = getPalico_GadgetsValues(palico_gadgets);
        database_open();
        long insertId = database.insert(DbSchema.Table_Palico_Gadgets.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Palico_Gadgets palico_gadgets) { 
        ContentValues values = new ContentValues();
        values = getPalico_GadgetsValues(palico_gadgets);
        database_open();
        String[] where = new String[] { String.valueOf(palico_gadgets.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Palico_Gadgets.TABLE_NAME , values, DbSchema.Table_Palico_Gadgets.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Palico_Gadgets palico_gadgets) { 
        database_open();
        String[] where = new String[] { String.valueOf(palico_gadgets.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Palico_Gadgets.TABLE_NAME , DbSchema.Table_Palico_Gadgets.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Palico_Gadgets.TABLE_NAME , DbSchema.Table_Palico_Gadgets.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getPalico_GadgetsValues(Palico_Gadgets palico_gadgets) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Palico_Gadgets.COL__ID, palico_gadgets.get_Id());
        values.put(DbSchema.Table_Palico_Gadgets.COL_NAME, palico_gadgets.getName());
        values.put(DbSchema.Table_Palico_Gadgets.COL_PROFICIENCY, palico_gadgets.getProficiency());
        values.put(DbSchema.Table_Palico_Gadgets.COL_EFFECTS, palico_gadgets.getEffects());
        values.put(DbSchema.Table_Palico_Gadgets.COL_HOWTOGET, palico_gadgets.getHowtoget());

        return values;
    }

    protected static Palico_Gadgets cursorToPalico_Gadgets(Cursor cursor)  {
        Palico_Gadgets palico_gadgets = new Palico_Gadgets();

        palico_gadgets.set_Id(cursor.getInt(cursor.getColumnIndex(DbSchema.Table_Palico_Gadgets.COL__ID)));
        palico_gadgets.setName(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Palico_Gadgets.COL_NAME)));
        palico_gadgets.setProficiency(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Palico_Gadgets.COL_PROFICIENCY)));
        palico_gadgets.setEffects(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Palico_Gadgets.COL_EFFECTS)));
        palico_gadgets.setHowtoget(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Palico_Gadgets.COL_HOWTOGET)));

        return palico_gadgets;
    }

    

}

