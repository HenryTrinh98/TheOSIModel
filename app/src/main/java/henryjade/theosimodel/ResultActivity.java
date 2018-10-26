package henryjade.theosimodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class  ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scoreTxtView = findViewById(R.id.score);

        Calendar d = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        final String cd = df.format(d.getTime());

        // grab intent values passed (vlaue keys)
        Intent intent = getIntent();
        final int attemptscore = intent.getExtras().getInt("attemptscore");
        scoreTxtView.setText(String.valueOf(attemptscore));
        final String cat = intent.getExtras().getString("category");

// db helper as db will be used to save scores
        final DbHelper dbHelper = new DbHelper(this);
        //save score
        Button savebttn = findViewById(R.id.button3);

        View.OnClickListener sa1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Scores newScore = new Scores(attemptscore,cd,cat);
                //using the addscoretodb method in the db helper, create an instance of a "score" to input into the db
                dbHelper.addScoresToDB(newScore);

                Intent intent = new Intent(ResultActivity.this, HomePage.class);
                startActivity(intent);
                finish();


            }
        };
        savebttn.setOnClickListener(sa1);

//Returns users to the Quiz menu to redo quiz!
        Button redo = findViewById(R.id.redoquiz);

        View.OnClickListener re = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           Intent intent3 = new Intent(ResultActivity.this, Quiz.class);
           startActivity(intent3);
           finish();


            }
        };
        redo.setOnClickListener(re);

//Intent to return home
        Button hom = findViewById(R.id.homebutt);

        View.OnClickListener ho = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(ResultActivity.this, HomePage.class);
                    startActivity(intent);
                    finish();

            }
        };
        hom.setOnClickListener(ho);

    }
}