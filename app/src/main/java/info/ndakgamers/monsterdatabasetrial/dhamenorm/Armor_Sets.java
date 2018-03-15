package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import android.os.Bundle;
import java.util.Date;

public class Armor_Sets {

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

    private Integer m_Id;
    private String mSetname;
    private String mDefense;
    private Integer mVsfire;
    private Integer mVswater;
    private Integer mVsthunder;
    private Integer mVsice;
    private Integer mVsdragon;
    private String mSetbonus;
    private String mSetskill;

    public Armor_Sets() {
    }

    public Armor_Sets(Integer _id, String setname, String defense, Integer vsfire, Integer vswater, Integer vsthunder, Integer vsice, Integer vsdragon, String setbonus, String setskill) {
        this.m_Id = _id;
        this.mSetname = setname;
        this.mDefense = defense;
        this.mVsfire = vsfire;
        this.mVswater = vswater;
        this.mVsthunder = vsthunder;
        this.mVsice = vsice;
        this.mVsdragon = vsdragon;
        this.mSetbonus = setbonus;
        this.mSetskill = setskill;
    }

    public Integer get_Id() {
        return m_Id;
    }

    public void set_Id(Integer _id) {
        this.m_Id = _id;
    }

    public String getSetname() {
        return mSetname;
    }

    public void setSetname(String setname) {
        this.mSetname = setname;
    }

    public String getDefense() {
        return mDefense;
    }

    public void setDefense(String defense) {
        this.mDefense = defense;
    }

    public Integer getVsfire() {
        return mVsfire;
    }

    public void setVsfire(Integer vsfire) {
        this.mVsfire = vsfire;
    }

    public Integer getVswater() {
        return mVswater;
    }

    public void setVswater(Integer vswater) {
        this.mVswater = vswater;
    }

    public Integer getVsthunder() {
        return mVsthunder;
    }

    public void setVsthunder(Integer vsthunder) {
        this.mVsthunder = vsthunder;
    }

    public Integer getVsice() {
        return mVsice;
    }

    public void setVsice(Integer vsice) {
        this.mVsice = vsice;
    }

    public Integer getVsdragon() {
        return mVsdragon;
    }

    public void setVsdragon(Integer vsdragon) {
        this.mVsdragon = vsdragon;
    }

    public String getSetbonus() {
        return mSetbonus;
    }

    public void setSetbonus(String setbonus) {
        this.mSetbonus = setbonus;
    }

    public String getSetskill() {
        return mSetskill;
    }

    public void setSetskill(String setskill) {
        this.mSetskill = setskill;
    }


    public Bundle toBundle() { 
        Bundle b = new Bundle();
        b.putInt(COL__ID, this.m_Id);
        b.putString(COL_SETNAME, this.mSetname);
        b.putString(COL_DEFENSE, this.mDefense);
        b.putInt(COL_VSFIRE, this.mVsfire);
        b.putInt(COL_VSWATER, this.mVswater);
        b.putInt(COL_VSTHUNDER, this.mVsthunder);
        b.putInt(COL_VSICE, this.mVsice);
        b.putInt(COL_VSDRAGON, this.mVsdragon);
        b.putString(COL_SETBONUS, this.mSetbonus);
        b.putString(COL_SETSKILL, this.mSetskill);
        return b;
    }

    public Armor_Sets(Bundle b) {
        if (b != null) {
            this.m_Id = b.getInt(COL__ID);
            this.mSetname = b.getString(COL_SETNAME);
            this.mDefense = b.getString(COL_DEFENSE);
            this.mVsfire = b.getInt(COL_VSFIRE);
            this.mVswater = b.getInt(COL_VSWATER);
            this.mVsthunder = b.getInt(COL_VSTHUNDER);
            this.mVsice = b.getInt(COL_VSICE);
            this.mVsdragon = b.getInt(COL_VSDRAGON);
            this.mSetbonus = b.getString(COL_SETBONUS);
            this.mSetskill = b.getString(COL_SETSKILL);
        }
    }

}
