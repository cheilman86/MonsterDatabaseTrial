package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import android.os.Bundle;
import java.util.Date;

public class Materials1 {

    public static final String COL__ID = "_id";
    public static final String COL_MATERIALNAME = "materialname";
    public static final String COL_LOCATIONS = "locations";
    public static final String COL_RARITY = "rarity";

    private String m_Id;
    private String mMaterialname;
    private String mLocations;
    private String mRarity;

    public Materials1() {
    }

    public Materials1(String _id, String materialname, String locations, String rarity) {
        this.m_Id = _id;
        this.mMaterialname = materialname;
        this.mLocations = locations;
        this.mRarity = rarity;
    }

    public String get_Id() {
        return m_Id;
    }

    public void set_Id(String _id) {
        this.m_Id = _id;
    }

    public String getMaterialname() {
        return mMaterialname;
    }

    public void setMaterialname(String materialname) {
        this.mMaterialname = materialname;
    }

    public String getLocations() {
        return mLocations;
    }

    public void setLocations(String locations) {
        this.mLocations = locations;
    }

    public String getRarity() {
        return mRarity;
    }

    public void setRarity(String rarity) {
        this.mRarity = rarity;
    }


    public Bundle toBundle() { 
        Bundle b = new Bundle();
        b.putString(COL__ID, this.m_Id);
        b.putString(COL_MATERIALNAME, this.mMaterialname);
        b.putString(COL_LOCATIONS, this.mLocations);
        b.putString(COL_RARITY, this.mRarity);
        return b;
    }

    public Materials1(Bundle b) {
        if (b != null) {
            this.m_Id = b.getString(COL__ID);
            this.mMaterialname = b.getString(COL_MATERIALNAME);
            this.mLocations = b.getString(COL_LOCATIONS);
            this.mRarity = b.getString(COL_RARITY);
        }
    }

}
