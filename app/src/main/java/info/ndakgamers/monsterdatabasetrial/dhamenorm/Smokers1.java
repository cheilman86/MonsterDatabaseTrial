package info.ndakgamers.monsterdatabasetrial.dhamenorm;

import android.os.Bundle;
import java.util.Date;

public class Smokers1 {

    public static final String COL__ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_DESCRIPTION = "description";

    private String m_Id;
    private String mName;
    private String mDescription;

    public Smokers1() {
    }

    public Smokers1(String _id, String name, String description) {
        this.m_Id = _id;
        this.mName = name;
        this.mDescription = description;
    }

    public String get_Id() {
        return m_Id;
    }

    public void set_Id(String _id) {
        this.m_Id = _id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }


    public Bundle toBundle() { 
        Bundle b = new Bundle();
        b.putString(COL__ID, this.m_Id);
        b.putString(COL_NAME, this.mName);
        b.putString(COL_DESCRIPTION, this.mDescription);
        return b;
    }

    public Smokers1(Bundle b) {
        if (b != null) {
            this.m_Id = b.getString(COL__ID);
            this.mName = b.getString(COL_NAME);
            this.mDescription = b.getString(COL_DESCRIPTION);
        }
    }

}
