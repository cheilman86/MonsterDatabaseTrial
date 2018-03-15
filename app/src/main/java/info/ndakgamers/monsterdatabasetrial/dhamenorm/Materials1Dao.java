package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Materials1Dao extends DbManager {
    private static final String TAG = "Materials1Dao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Materials1.allColumns;


    protected Materials1Dao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Materials1 LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Materials1.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Materials1 materials1 = new Materials1();
        materials1 = cursorToMaterials1(cursor);

        cursor.close();
        database_close();

        return materials1;
    }

    public static ArrayList<Materials1> LoadAllRecords() {
        ArrayList<Materials1> materials1List = new ArrayList<Materials1>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Materials1.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Materials1 materials1 = cursorToMaterials1(cursor);
            materials1List.add(materials1);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return materials1List;
    }

    public static long insertRecord(Materials1 materials1) {
        ContentValues values = new ContentValues();
        values = getMaterials1Values(materials1);
        database_open();
        long insertId = database.insert(DbSchema.Table_Materials1.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Materials1 materials1) { 
        ContentValues values = new ContentValues();
        values = getMaterials1Values(materials1);
        database_open();
        String[] where = new String[] { String.valueOf(materials1.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Materials1.TABLE_NAME , values, DbSchema.Table_Materials1.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Materials1 materials1) { 
        database_open();
        String[] where = new String[] { String.valueOf(materials1.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Materials1.TABLE_NAME , DbSchema.Table_Materials1.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Materials1.TABLE_NAME , DbSchema.Table_Materials1.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getMaterials1Values(Materials1 materials1) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Materials1.COL__ID, materials1.get_Id());
        values.put(DbSchema.Table_Materials1.COL_MATERIALNAME, materials1.getMaterialname());
        values.put(DbSchema.Table_Materials1.COL_LOCATIONS, materials1.getLocations());
        values.put(DbSchema.Table_Materials1.COL_RARITY, materials1.getRarity());

        return values;
    }

    protected static Materials1 cursorToMaterials1(Cursor cursor)  {
        Materials1 materials1 = new Materials1();

        materials1.set_Id(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Materials1.COL__ID)));
        materials1.setMaterialname(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Materials1.COL_MATERIALNAME)));
        materials1.setLocations(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Materials1.COL_LOCATIONS)));
        materials1.setRarity(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Materials1.COL_RARITY)));

        return materials1;
    }

    

}

