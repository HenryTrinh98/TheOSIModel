package henryjade.theosimodel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Lesson extends AppCompatActivity {

    @Override

    //Creating a cardview for each learning module (one for every layer in the OSI model) and associating it with an intent to launch the respective contents for each module
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        CardView appLesson = findViewById(R.id.applicationCard);
        appLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson.this, ApplicationLayer.class);
                startActivity(intent);
            }
        });

        CardView physicalLesson = findViewById(R.id.physicalCard);
        physicalLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson.this, PhysicalLayer.class);
                startActivity(intent);
            }
        });


        CardView presLesson = findViewById(R.id.presentationCard);
        presLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Lesson.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });

        CardView sessionLesson = findViewById(R.id.sessionCard);
        sessionLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Lesson.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });

        CardView networkLesson = findViewById(R.id.networkCard);
        networkLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Lesson.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });

        CardView transportLesson = findViewById(R.id.transportCard);
        transportLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Lesson.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });


        CardView datalinkLesson = findViewById(R.id.datalinkCard);
        datalinkLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Lesson.this, "This module is currently unavailable.", Toast.LENGTH_SHORT).show();

            }
        });




    }
}
