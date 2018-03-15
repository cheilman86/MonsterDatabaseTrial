package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbManager {
    private static final String TAG = "DBMANAGER";

    private static DbManager sInstance;

    private static final String LOG_TAG = "DbStocks";
    private static long errorId = 0;

    private Context mCtx;
    private DbHelper mDbHelper;
    private SQLiteDatabase mDb;


    public static DbManager setConfig(Context context) {
        if (sInstance==null){
            sInstance = new DbManager(context);}
        return sInstance;
    }


    protected static DbManager getsInstance() {
        return sInstance;
    }


    private DbManager(Context ctx) {
        this.mCtx = ctx;
    }

    protected DbManager() {}

    public DbManager open() {
        mDbHelper = new DbHelper(this);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public SQLiteDatabase getDatabase() {
        mDbHelper = new DbHelper(this);
        mDb = mDbHelper.getWritableDatabase();
        return mDb;
    }

    private static class DbHelper extends SQLiteOpenHelper {
        private static DbHelper sInstance;

        private static final String LOG_TAG = "DbHelper";
        private DbManager mDbManager;

        public static DbHelper getInstance(DbManager manager) {
            if (sInstance == null) {
                sInstance = new DbHelper(manager);
            }
            return sInstance;
        }


        private DbHelper(DbManager dbmanger) {
            super(dbmanger.mCtx, DbSchema.DATABASE_NAME, null, DbSchema.DATABASE_VERSION);
            mDbManager = dbmanger;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DbSchema.Table_Large_Monsters.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Armor_Sets.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Charms.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Mantles1.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Materials1.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Palico_Armor.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Palico_Gadgets.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Palico_Helms.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Palico_Weapons.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Smlmonsters1.CREATE_TABLE);
            db.execSQL(DbSchema.Table_Smokers1.CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DbSchema.Table_Large_Monsters.DROP_TABLE);
            db.execSQL(DbSchema.Table_Armor_Sets.DROP_TABLE);
            db.execSQL(DbSchema.Table_Charms.DROP_TABLE);
            db.execSQL(DbSchema.Table_Mantles1.DROP_TABLE);
            db.execSQL(DbSchema.Table_Materials1.DROP_TABLE);
            db.execSQL(DbSchema.Table_Palico_Armor.DROP_TABLE);
            db.execSQL(DbSchema.Table_Palico_Gadgets.DROP_TABLE);
            db.execSQL(DbSchema.Table_Palico_Helms.DROP_TABLE);
            db.execSQL(DbSchema.Table_Palico_Weapons.DROP_TABLE);
            db.execSQL(DbSchema.Table_Smlmonsters1.DROP_TABLE);
            db.execSQL(DbSchema.Table_Smokers1.DROP_TABLE);
            this.onCreate(db);
        }

    }
}
