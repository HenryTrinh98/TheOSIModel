package henryjade.theosimodel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity  {

    TextView tvbigday;
    TextView tvlast;
    TextView tvmost;

    CursorAdapter test;
    String mostcat;
    String mostcnt;
    String lastcat;
    String lastday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvbigday = findViewById(R.id.tvbigday);
        tvlast = findViewById(R.id.tvlast);
        tvmost = findViewById(R.id.tvmost);


        // Calls on all the methods stored in the DB helper
        DbHelper dbHelper = new DbHelper(this);
        mostcat = dbHelper.getMostPlayedCat();
        mostcnt = dbHelper.getMostPlayedCnt();
        lastcat = dbHelper.getLastPlayedCat();
        lastday = dbHelper.getLastPlayedDay();

       // final ArrayAdapter<Scores> itemAdapter =
        //        new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dbHelper.getLastScores());

        SQLiteDatabase db = dbHelper.getWritableDatabase();


        //SQL to get the last 5 scores (method not yet in dbhelper unfortunately)
        Cursor getLastScores = db.rawQuery("SELECT * from scoretable order by _id DESC limit 5",null);


        //gets the result of the cursors (raw db query) and uses the adapter to manager the cursors - Adapter binds data to a view (3 text views)
        ProfileCursorAdapter PCA = new ProfileCursorAdapter(this, getLastScores);

        final ListView listView = findViewById(R.id.listView);

        //set list view with the Cursor adapter values
        listView.setAdapter(PCA);

        setProfileView();

    }

    //Set profile scores (values provided by db helper methods
    public void setProfileView(){
        tvbigday.setText(lastday);
        tvlast.setText(lastcat);
        tvmost.setText(mostcat+"\n"+mostcnt+" times");

    }
}
