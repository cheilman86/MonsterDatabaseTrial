package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import android.os.Bundle;
import java.util.Date;

public class Charms {

    public static final String COL__ID = "_id";
    public static final String COL_RARITY = "rarity";
    public static final String COL_NAME = "name";
    public static final String COL_EFFECT = "effect";

    private String m_Id;
    private String mRarity;
    private String mName;
    private String mEffect;

    public Charms() {
    }

    public Charms(String _id, String rarity, String name, String effect) {
        this.m_Id = _id;
        this.mRarity = rarity;
        this.mName = name;
        this.mEffect = effect;
    }

    public String get_Id() {
        return m_Id;
    }

    public void set_Id(String _id) {
        this.m_Id = _id;
    }

    public String getRarity() {
        return mRarity;
    }

    public void setRarity(String rarity) {
        this.mRarity = rarity;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getEffect() {
        return mEffect;
    }

    public void setEffect(String effect) {
        this.mEffect = effect;
    }


    public Bundle toBundle() { 
        Bundle b = new Bundle();
        b.putString(COL__ID, this.m_Id);
        b.putString(COL_RARITY, this.mRarity);
        b.putString(COL_NAME, this.mName);
        b.putString(COL_EFFECT, this.mEffect);
        return b;
    }

    public Charms(Bundle b) {
        if (b != null) {
            this.m_Id = b.getString(COL__ID);
            this.mRarity = b.getString(COL_RARITY);
            this.mName = b.getString(COL_NAME);
            this.mEffect = b.getString(COL_EFFECT);
        }
    }

}
