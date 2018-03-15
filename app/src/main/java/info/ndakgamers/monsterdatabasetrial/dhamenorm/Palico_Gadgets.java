package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import android.os.Bundle;
import java.util.Date;

public class Palico_Gadgets {

    public static final String COL__ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_PROFICIENCY = "proficiency";
    public static final String COL_EFFECTS = "effects";
    public static final String COL_HOWTOGET = "howtoget";

    private Integer m_Id;
    private String mName;
    private String mProficiency;
    private String mEffects;
    private String mHowtoget;

    public Palico_Gadgets() {
    }

    public Palico_Gadgets(Integer _id, String name, String proficiency, String effects, String howtoget) {
        this.m_Id = _id;
        this.mName = name;
        this.mProficiency = proficiency;
        this.mEffects = effects;
        this.mHowtoget = howtoget;
    }

    public Integer get_Id() {
        return m_Id;
    }

    public void set_Id(Integer _id) {
        this.m_Id = _id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getProficiency() {
        return mProficiency;
    }

    public void setProficiency(String proficiency) {
        this.mProficiency = proficiency;
    }

    public String getEffects() {
        return mEffects;
    }

    public void setEffects(String effects) {
        this.mEffects = effects;
    }

    public String getHowtoget() {
        return mHowtoget;
    }

    public void setHowtoget(String howtoget) {
        this.mHowtoget = howtoget;
    }


    public Bundle toBundle() { 
        Bundle b = new Bundle();
        b.putInt(COL__ID, this.m_Id);
        b.putString(COL_NAME, this.mName);
        b.putString(COL_PROFICIENCY, this.mProficiency);
        b.putString(COL_EFFECTS, this.mEffects);
        b.putString(COL_HOWTOGET, this.mHowtoget);
        return b;
    }

    public Palico_Gadgets(Bundle b) {
        if (b != null) {
            this.m_Id = b.getInt(COL__ID);
            this.mName = b.getString(COL_NAME);
            this.mProficiency = b.getString(COL_PROFICIENCY);
            this.mEffects = b.getString(COL_EFFECTS);
            this.mHowtoget = b.getString(COL_HOWTOGET);
        }
    }

}
