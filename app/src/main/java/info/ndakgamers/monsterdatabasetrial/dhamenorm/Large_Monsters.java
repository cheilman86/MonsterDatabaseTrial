package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import android.os.Bundle;
import java.util.Date;

public class Large_Monsters {

    public static final String COL__ID = "_id";
    public static final String COL_MONSTERNAME = "monstername";
    public static final String COL_ELEMENT = "element";
    public static final String COL_AILMENTS = "ailments";
    public static final String COL_WEAKNESS = "weakness";
    public static final String COL_RESISTANCES = "resistances";
    public static final String COL_LOCATIONS = "locations";

    private Integer m_Id;
    private String mMonstername;
    private String mElement;
    private String mAilments;
    private String mWeakness;
    private String mResistances;
    private String mLocations;

    public Large_Monsters() {
    }

    public Large_Monsters(Integer _id, String monstername, String element, String ailments, String weakness, String resistances, String locations) {
        this.m_Id = _id;
        this.mMonstername = monstername;
        this.mElement = element;
        this.mAilments = ailments;
        this.mWeakness = weakness;
        this.mResistances = resistances;
        this.mLocations = locations;
    }

    public Integer get_Id() {
        return m_Id;
    }

    public void set_Id(Integer _id) {
        this.m_Id = _id;
    }

    public String getMonstername() {
        return mMonstername;
    }

    public void setMonstername(String monstername) {
        this.mMonstername = monstername;
    }

    public String getElement() {
        return mElement;
    }

    public void setElement(String element) {
        this.mElement = element;
    }

    public String getAilments() {
        return mAilments;
    }

    public void setAilments(String ailments) {
        this.mAilments = ailments;
    }

    public String getWeakness() {
        return mWeakness;
    }

    public void setWeakness(String weakness) {
        this.mWeakness = weakness;
    }

    public String getResistances() {
        return mResistances;
    }

    public void setResistances(String resistances) {
        this.mResistances = resistances;
    }

    public String getLocations() {
        return mLocations;
    }

    public void setLocations(String locations) {
        this.mLocations = locations;
    }


    public Bundle toBundle() { 
        Bundle b = new Bundle();
        b.putInt(COL__ID, this.m_Id);
        b.putString(COL_MONSTERNAME, this.mMonstername);
        b.putString(COL_ELEMENT, this.mElement);
        b.putString(COL_AILMENTS, this.mAilments);
        b.putString(COL_WEAKNESS, this.mWeakness);
        b.putString(COL_RESISTANCES, this.mResistances);
        b.putString(COL_LOCATIONS, this.mLocations);
        return b;
    }

    public Large_Monsters(Bundle b) {
        if (b != null) {
            this.m_Id = b.getInt(COL__ID);
            this.mMonstername = b.getString(COL_MONSTERNAME);
            this.mElement = b.getString(COL_ELEMENT);
            this.mAilments = b.getString(COL_AILMENTS);
            this.mWeakness = b.getString(COL_WEAKNESS);
            this.mResistances = b.getString(COL_RESISTANCES);
            this.mLocations = b.getString(COL_LOCATIONS);
        }
    }

}
