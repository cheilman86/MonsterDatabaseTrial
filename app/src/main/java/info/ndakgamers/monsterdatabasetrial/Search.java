package info.ndakgamers.monsterdatabasetrial;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FilterQueryProvider;

import java.lang.reflect.Array;

import info.ndakgamers.monsterdatabasetrial.dhamenorm.DbManager;
import info.ndakgamers.monsterdatabasetrial.dhamenorm.Large_Monsters;
import info.ndakgamers.monsterdatabasetrial.dhamenorm.Large_MonstersDao;

public class Search extends AppCompatActivity {

    AutoCompleteTextView autoTextView;
    String[] MonsterNames  = new String[] {Large_Monsters.COL_MONSTERNAME};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        DbManager.setConfig(this);



        autoTextView = (AutoCompleteTextView) findViewById(R.id.acTextView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item,MonsterNames);

        autoTextView.setThreshold(1);
        autoTextView.setAdapter(adapter);

    }

    private void initializeDescription() {
        _descriptionText = (AutoCompleteTextView) findViewById(R.id.description);
        final int[] to = new int[]{android.R.id.text1};
        final String[] from = new String[]{VehicleDescriptionsTable.DESCRIPTION};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_dropdown_item_1line,
                null,
                from,
                to);

        // This will provide the labels for the choices to be displayed in the AutoCompleteTextView
        adapter.setCursorToStringConverter(new SimpleCursorAdapter.CursorToStringConverter() {
            @Override
            public CharSequence convertToString(Cursor cursor) {
                final int colIndex = cursor.getColumnIndexOrThrow(Large_Monsters.COL_MONSTERNAME);
                return cursor.getString(colIndex);
            }
        });

        // This will run a query to find the descriptions for a given vehicle.
        adapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence description) {
                String vehicle = DbManager.setConfig().open();
                Cursor managedCursor = _helper.getDescriptionsFor(vehicle, description.toString());
                Log.d(TAG, "Query has " + managedCursor.getCount() + " rows of description for " + vehicle);
                return managedCursor;
            }
        });

        _descriptionText.setAdapter(adapter);
    }

    private void populateAutoTextView() {
//        Cursor sCursor = Large_MonstersDao.LoadAllRecords();
//
//        int[] toViewLocation = new int[] {R.id.}
    }
}
