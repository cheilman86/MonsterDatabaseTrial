package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class Smokers1Dao extends DbManager {
    private static final String TAG = "Smokers1Dao";

    protected static SQLiteDatabase database;
    protected static DbManager mDbManager;
    protected static  String[] allColumns = DbSchema.Table_Smokers1.allColumns;


    protected Smokers1Dao() {
    }

    protected static void database_open() throws SQLException {
        mDbManager = DbManager.getsInstance();
        database = mDbManager.getDatabase();
    }

    protected static void database_close() {
        mDbManager = DbManager.getsInstance();
        mDbManager.close();
    }

    public static Smokers1 LoadRecordById(int m_id)  { 
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Smokers1.TABLE_NAME,allColumns,  "_id = ?" , new String[] { String.valueOf(m_id) } , null, null, null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Smokers1 smokers1 = new Smokers1();
        smokers1 = cursorToSmokers1(cursor);

        cursor.close();
        database_close();

        return smokers1;
    }

    public static ArrayList<Smokers1> LoadAllRecords() {
        ArrayList<Smokers1> smokers1List = new ArrayList<Smokers1>();
        database_open();
        Cursor cursor = database.query(DbSchema.Table_Smokers1.TABLE_NAME,allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Smokers1 smokers1 = cursorToSmokers1(cursor);
            smokers1List.add(smokers1);
            cursor.moveToNext();
        }
        cursor.close();
        database_close();
        return smokers1List;
    }

    public static long insertRecord(Smokers1 smokers1) {
        ContentValues values = new ContentValues();
        values = getSmokers1Values(smokers1);
        database_open();
        long insertId = database.insert(DbSchema.Table_Smokers1.TABLE_NAME , null, values);
        database_close();
        return insertId;
    }

    public static int updateRecord(Smokers1 smokers1) { 
        ContentValues values = new ContentValues();
        values = getSmokers1Values(smokers1);
        database_open();
        String[] where = new String[] { String.valueOf(smokers1.get_Id()) }; 
        int updatedId = database.update(DbSchema.Table_Smokers1.TABLE_NAME , values, DbSchema.Table_Smokers1.COL__ID + " = ? ",where );
        database_close();
        return updatedId;
    }

    public static int deleteRecord(Smokers1 smokers1) { 
        database_open();
        String[] where = new String[] { String.valueOf(smokers1.get_Id()) }; 
        int deletedCount = database.delete(DbSchema.Table_Smokers1.TABLE_NAME , DbSchema.Table_Smokers1.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    public static int deleteRecord(String id) {
        database_open();
        String[] where = new String[] { id }; 
        int deletedCount = database.delete(DbSchema.Table_Smokers1.TABLE_NAME , DbSchema.Table_Smokers1.COL__ID + " = ? ",where );
        database_close();
        return deletedCount;
    }

    protected static ContentValues getSmokers1Values(Smokers1 smokers1) {
        ContentValues values = new ContentValues();

        values.put(DbSchema.Table_Smokers1.COL__ID, smokers1.get_Id());
        values.put(DbSchema.Table_Smokers1.COL_NAME, smokers1.getName());
        values.put(DbSchema.Table_Smokers1.COL_DESCRIPTION, smokers1.getDescription());

        return values;
    }

    protected static Smokers1 cursorToSmokers1(Cursor cursor)  {
        Smokers1 smokers1 = new Smokers1();

        smokers1.set_Id(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smokers1.COL__ID)));
        smokers1.setName(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smokers1.COL_NAME)));
        smokers1.setDescription(cursor.getString(cursor.getColumnIndex(DbSchema.Table_Smokers1.COL_DESCRIPTION)));

        return smokers1;
    }

    

}

