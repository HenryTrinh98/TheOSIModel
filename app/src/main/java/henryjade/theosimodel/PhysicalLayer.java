package henryjade.theosimodel;

import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class PhysicalLayer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_layer);

        TextView title = findViewById(R.id.textViewTitle);
        title.setText(Html.fromHtml(getString(R.string.Title)));
        title.setTypeface(null, Typeface.BOLD);

        TextView intro = findViewById(R.id.textViewIntroduction);
        intro.setText(Html.fromHtml(getString(R.string.PhyIntro)));

        TextView tv = findViewById(R.id.phyTitle);
        tv.setText(Html.fromHtml(getString(R.string.PStringTitle)));

        TextView body = findViewById(R.id.textViewBody);
        body.setText(Html.fromHtml(getString(R.string.PhyBody)));

        TextView title3 = findViewById(R.id.phyTitle2);
        title3.setText(Html.fromHtml(getString(R.string.PhyTitle2)));

        TextView body2 = findViewById(R.id.textViewBody2);
        body2.setText(Html.fromHtml(getString(R.string.PhyBody2)));

        TextView title4 = findViewById(R.id.phyTitle3);
        title4.setText(Html.fromHtml(getString(R.string.PhyTitle3)));

        TextView body3 = findViewById(R.id.textViewBody3);
        body3.setText(Html.fromHtml(getString(R.string.PhyBody3)));

    }
}