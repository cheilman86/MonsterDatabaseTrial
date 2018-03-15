    package info.ndakgamers.monsterdatabasetrial;

    import android.database.Cursor;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.widget.ListView;
    import android.widget.TextView;

    import java.util.List;

    import info.ndakgamers.monsterdatabasetrial.dhamenorm.DbManager;
    import info.ndakgamers.monsterdatabasetrial.dhamenorm.Large_Monsters;
    import info.ndakgamers.monsterdatabasetrial.dhamenorm.Large_MonstersDao;

    public class Anjanath extends AppCompatActivity {

        private ListView listView;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anjanath);
            DbManager.setConfig(this);

            // Calling our data into a list

            List<Large_Monsters> lrgmonsterList = Large_MonstersDao.LoadAllRecords();

            String lrgMon = "";
            for (Large_Monsters monsterItem : lrgmonsterList){
                lrgMon = "";
                lrgMon += monsterItem.getMonstername();
                lrgMon += monsterItem.getLocations() + "\n";
            }

           TextView anjaText = (TextView) findViewById(R.id.tvAnja);
            anjaText.setText(lrgMon);

        }


    }
