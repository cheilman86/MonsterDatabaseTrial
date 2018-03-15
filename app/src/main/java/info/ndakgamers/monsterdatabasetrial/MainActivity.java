    package info.ndakgamers.monsterdatabasetrial;


    import android.app.Dialog;
    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    import info.ndakgamers.monsterdatabasetrial.dhamenorm.DbManager;


    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button anjabtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbManager.setConfig(this);

        anjabtn = (Button) findViewById(R.id.anjabtn);
        anjabtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View myview) {
        switch (myview.getId()) {
            case R.id.anjabtn:

                    Intent anjIntent = new Intent("info.ndakgamers.monsterdatabasetrial.Search");
                    startActivity(anjIntent);

        }


    }
    }
