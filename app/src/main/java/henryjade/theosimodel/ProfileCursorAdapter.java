package henryjade.theosimodel;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class ProfileCursorAdapter extends CursorAdapter {


    public ProfileCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // Used to inflate a new view and return it,
    @Override

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.profilelist_item, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView tvPL0 = view.findViewById(R.id.tvPL0);
        TextView tvPLA = view.findViewById(R.id.tvPLA);
        TextView tvPLB = view.findViewById(R.id.tvPLB);
        TextView tvPLC = view.findViewById(R.id.tvPLC);

        // Extract properties from cursor
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        int score = cursor.getInt(cursor.getColumnIndexOrThrow("score"));
        String playdate = cursor.getString(cursor.getColumnIndexOrThrow("playdate"));
        String playcat = cursor.getString(cursor.getColumnIndexOrThrow("category"));
        // Populate fields with extracted properties
        tvPL0.setText(String.valueOf(id));
        tvPLA.setText(String.valueOf(score));
        tvPLB.setText(playdate);
        tvPLC.setText(playcat);
    }

}
