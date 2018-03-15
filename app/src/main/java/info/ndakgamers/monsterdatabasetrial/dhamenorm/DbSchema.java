package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import android.provider.BaseColumns;

public class DbSchema {
    private static final String TAG = "DbSchema";

    public static final String DATABASE_NAME = "MHWResearchData.db";
    public static final int DATABASE_VERSION = 1;
    public static final String SORT_ASC = " ASC";
    public static final String SORT_DESC = " DESC";
    public static final String[] ORDERS = {SORT_ASC,SORT_DESC};
    public static final int OFF = 0;
    public static final int ON = 1;

    public static final class Table_Large_Monsters implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "large_monsters";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_MONSTERNAME = "monstername";
        public static final String COL_ELEMENT = "element";
        public static final String COL_AILMENTS = "ailments";
        public static final String COL_WEAKNESS = "weakness";
        public static final String COL_RESISTANCES = "resistances";
        public static final String COL_LOCATIONS = "locations";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS large_monsters ( " + 
            COL__ID + " INTEGER," + 
            COL_MONSTERNAME + " TEXT," + 
            COL_ELEMENT + " TEXT," + 
            COL_AILMENTS + " TEXT," + 
            COL_WEAKNESS + " TEXT," + 
            COL_RESISTANCES + " TEXT," + 
            COL_LOCATIONS + " TEXT );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS large_monsters;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_MONSTERNAME,
            COL_ELEMENT,
            COL_AILMENTS,
            COL_WEAKNESS,
            COL_RESISTANCES,
            COL_LOCATIONS };
    }

    public static final class Table_Armor_Sets implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "armor_sets";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_SETNAME = "setname";
        public static final String COL_DEFENSE = "defense";
        public static final String COL_VSFIRE = "vsfire";
        public static final String COL_VSWATER = "vswater";
        public static final String COL_VSTHUNDER = "vsthunder";
        public static final String COL_VSICE = "vsice";
        public static final String COL_VSDRAGON = "vsdragon";
        public static final String COL_SETBONUS = "setbonus";
        public static final String COL_SETSKILL = "setskill";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS armor_sets ( " + 
            COL__ID + " INTEGER," + 
            COL_SETNAME + " TEXT," + 
            COL_DEFENSE + " TEXT," + 
            COL_VSFIRE + " INTEGER," + 
            COL_VSWATER + " INTEGER," + 
            COL_VSTHUNDER + " INTEGER," + 
            COL_VSICE + " INTEGER," + 
            COL_VSDRAGON + " INTEGER," + 
            COL_SETBONUS + " TEXT," + 
            COL_SETSKILL + " TEXT );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS armor_sets;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_SETNAME,
            COL_DEFENSE,
            COL_VSFIRE,
            COL_VSWATER,
            COL_VSTHUNDER,
            COL_VSICE,
            COL_VSDRAGON,
            COL_SETBONUS,
            COL_SETSKILL };
    }

    public static final class Table_Charms implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "charms";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_RARITY = "rarity";
        public static final String COL_NAME = "name";
        public static final String COL_EFFECT = "effect";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS charms ( " + 
            COL__ID + " TEXT," + 
            COL_RARITY + " TEXT," + 
            COL_NAME + " TEXT," + 
            COL_EFFECT + " TEXT );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS charms;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_RARITY,
            COL_NAME,
            COL_EFFECT };
    }

    public static final class Table_Mantles1 implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "mantles1";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_NAME = "name";
        public static final String COL_DESCRIPTION = "description";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS mantles1 ( " + 
            COL__ID + " TEXT," + 
            COL_NAME + " TEXT," + 
            COL_DESCRIPTION + " TEXT );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS mantles1;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_NAME,
            COL_DESCRIPTION };
    }

    public static final class Table_Materials1 implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "materials1";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_MATERIALNAME = "materialname";
        public static final String COL_LOCATIONS = "locations";
        public static final String COL_RARITY = "rarity";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS materials1 ( " + 
            COL__ID + " TEXT," + 
            COL_MATERIALNAME + " TEXT," + 
            COL_LOCATIONS + " TEXT," + 
            COL_RARITY + " TEXT );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS materials1;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_MATERIALNAME,
            COL_LOCATIONS,
            COL_RARITY };
    }

    public static final class Table_Palico_Armor implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "palico_armor";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_SETNAME = "setname";
        public static final String COL_DEFENSE = "defense";
        public static final String COL_VSFIRE = "vsfire";
        public static final String COL_VSWATER = "vswater";
        public static final String COL_VSTHUNDER = "vsthunder";
        public static final String COL_VSICE = "vsice";
        public static final String COL_VSDRAGON = "vsdragon";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS palico_armor ( " + 
            COL__ID + " INTEGER," + 
            COL_SETNAME + " TEXT," + 
            COL_DEFENSE + " INTEGER," + 
            COL_VSFIRE + " INTEGER," + 
            COL_VSWATER + " INTEGER," + 
            COL_VSTHUNDER + " INTEGER," + 
            COL_VSICE + " INTEGER," + 
            COL_VSDRAGON + " INTEGER );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS palico_armor;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_SETNAME,
            COL_DEFENSE,
            COL_VSFIRE,
            COL_VSWATER,
            COL_VSTHUNDER,
            COL_VSICE,
            COL_VSDRAGON };
    }

    public static final class Table_Palico_Gadgets implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "palico_gadgets";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_NAME = "name";
        public static final String COL_PROFICIENCY = "proficiency";
        public static final String COL_EFFECTS = "effects";
        public static final String COL_HOWTOGET = "howtoget";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS palico_gadgets ( " + 
            COL__ID + " INTEGER," + 
            COL_NAME + " TEXT," + 
            COL_PROFICIENCY + " TEXT," + 
            COL_EFFECTS + " TEXT," + 
            COL_HOWTOGET + " TEXT );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS palico_gadgets;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_NAME,
            COL_PROFICIENCY,
            COL_EFFECTS,
            COL_HOWTOGET };
    }

    public static final class Table_Palico_Helms implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "palico_helms";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_SETNAME = "setName";
        public static final String COL_DEFENSE = "defense";
        public static final String COL_VSFIRE = "vsfire";
        public static final String COL_VSWATER = "vswater";
        public static final String COL_VSTHUNDER = "vsthunder";
        public static final String COL_VSICE = "vsice";
        public static final String COL_VSDRAGON = "vsdragon";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS palico_helms ( " + 
            COL__ID + " INTEGER," + 
            COL_SETNAME + " TEXT," + 
            COL_DEFENSE + " INTEGER," + 
            COL_VSFIRE + " INTEGER," + 
            COL_VSWATER + " INTEGER," + 
            COL_VSTHUNDER + " INTEGER," + 
            COL_VSICE + " INTEGER," + 
            COL_VSDRAGON + " INTEGER );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS palico_helms;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_SETNAME,
            COL_DEFENSE,
            COL_VSFIRE,
            COL_VSWATER,
            COL_VSTHUNDER,
            COL_VSICE,
            COL_VSDRAGON };
    }

    public static final class Table_Palico_Weapons implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "palico_weapons";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_SETNAME = "setname";
        public static final String COL_DEFENSE = "defense";
        public static final String COL_VSFIRE = "vsfire";
        public static final String COL_VSWATER = "vswater";
        public static final String COL_VSTHUNDER = "vsthunder";
        public static final String COL_VSICE = "vsice";
        public static final String COL_VSDRAGON = "vsdragon";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS palico_weapons ( " + 
            COL__ID + " INTEGER," + 
            COL_SETNAME + " TEXT," + 
            COL_DEFENSE + " INTEGER," + 
            COL_VSFIRE + " INTEGER," + 
            COL_VSWATER + " INTEGER," + 
            COL_VSTHUNDER + " INTEGER," + 
            COL_VSICE + " INTEGER," + 
            COL_VSDRAGON + " INTEGER );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS palico_weapons;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_SETNAME,
            COL_DEFENSE,
            COL_VSFIRE,
            COL_VSWATER,
            COL_VSTHUNDER,
            COL_VSICE,
            COL_VSDRAGON };
    }

    public static final class Table_Smlmonsters1 implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "SmlMonsters1";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_MONSTERNAME = "monstername";
        public static final String COL_ELEMENT = "element";
        public static final String COL_AILMENTS = "ailments";
        public static final String COL_WEAKNESS = "weakness";
        public static final String COL_RESISTANCES = "resistances";
        public static final String COL_LOCATIONS = "locations";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS SmlMonsters1 ( " + 
            COL__ID + " TEXT," + 
            COL_MONSTERNAME + " TEXT," + 
            COL_ELEMENT + " TEXT," + 
            COL_AILMENTS + " TEXT," + 
            COL_WEAKNESS + " TEXT," + 
            COL_RESISTANCES + " TEXT," + 
            COL_LOCATIONS + " TEXT );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS SmlMonsters1;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_MONSTERNAME,
            COL_ELEMENT,
            COL_AILMENTS,
            COL_WEAKNESS,
            COL_RESISTANCES,
            COL_LOCATIONS };
    }

    public static final class Table_Smokers1 implements BaseColumns  { 
        // Table Name
        public static final String TABLE_NAME = "Smokers1";

        // Table Columns
        public static final String COL__ID = "_id";
        public static final String COL_NAME = "name";
        public static final String COL_DESCRIPTION = "description";

        // Create Table Statement
        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS Smokers1 ( " + 
            COL__ID + " TEXT," + 
            COL_NAME + " TEXT," + 
            COL_DESCRIPTION + " TEXT );";

        // Drop table statement
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS Smokers1;";

        // Columns list array
        public static final String[] allColumns = {
            COL__ID,
            COL_NAME,
            COL_DESCRIPTION };
    }

}
