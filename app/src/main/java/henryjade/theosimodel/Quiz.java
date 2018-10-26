package henryjade.theosimodel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    @Override

    //Creating a cardview for each quiz module (one for every layer in the OSI model) and associating it with an intent to launch the respective contents for each module

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        CardView appQuiz = findViewById(R.id.applicationCard);
        appQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, ApplicationQuiz.class);
                startActivity(intent);
            }
        });

        CardView physicalQuiz = findViewById(R.id.physicalCard);
        physicalQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, PhysicalQuiz.class);
                startActivity(intent);
            }
        });


        CardView presQuiz = findViewById(R.id.presentationCard);
        presQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Quiz.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });

        CardView sessionQuiz = findViewById(R.id.sessionCard);
        sessionQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Quiz.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });

        CardView networkQuiz = findViewById(R.id.networkCard);
        networkQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Quiz.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });

        CardView transportQuiz = findViewById(R.id.transportCard);
        transportQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Quiz.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });


        CardView datalinkQuiz = findViewById(R.id.datalinkCard);
        datalinkQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Quiz.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
