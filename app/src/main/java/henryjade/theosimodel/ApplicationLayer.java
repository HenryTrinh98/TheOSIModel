package henryjade.theosimodel;

import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ApplicationLayer extends AppCompatActivity {


    @Override

    //Populate the application lesson module with content (html text) and youtube api

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_layer);

        TextView title = findViewById(R.id.textViewTitle);
        title.setText(Html.fromHtml(getString(R.string.Title)));
        title.setTypeface(null, Typeface.BOLD);

        TextView intro = findViewById(R.id.textViewIntroduction);
        intro.setText(Html.fromHtml(getString(R.string.AppIntro)));

        TextView intro2 = findViewById(R.id.textViewIntroduction2);
        intro.setText(Html.fromHtml(getString(R.string.AppIntro2)));

        TextView title2 = findViewById(R.id.appTitle);
        title2.setText(Html.fromHtml(getString(R.string.AppTitle)));

        TextView body = findViewById(R.id.textViewBody);
        body.setText(Html.fromHtml(getString(R.string.AppBody)));

        YoutubeFragment fragment = new YoutubeFragment();

        FragmentManager manager = getSupportFragmentManager();

        manager.beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .addToBackStack(null)
                .commit();
    }
}