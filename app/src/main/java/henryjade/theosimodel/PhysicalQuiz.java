package henryjade.theosimodel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

public class PhysicalQuiz extends AppCompatActivity {


    //declare all variables
    List<Question> questionList;
    int attemptscore = 0;
    int cProgress = 1;
    int quid = 0;
    Question currentQuestion;

    TextView qsID;
    TextView ansDetail;
    TextView txtQuestion;
    RadioButton rda,rdb,rdc;
    Button butCheck;
    Button butNext;
    CardView cv;

    ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        //db helper , get all questions via a method in the dbhelper class. Questions are shuffled to randomsie the question bank
        DbHelper dbHelper = new DbHelper(this);
        questionList = dbHelper.getAllQuestionsP();
        Collections.shuffle(questionList);
        currentQuestion = questionList.get(quid);

        //Setting up numerous elements of the page
        ansDetail = findViewById(R.id.answerDetail);
        txtQuestion = findViewById(R.id.question);
        rda = findViewById(R.id.radio0);
        rdb = findViewById(R.id.radio1);
        rdc = findViewById(R.id.radio2);
        butCheck = findViewById(R.id.button2);
        butNext = findViewById(R.id.button1);
        cv = findViewById(R.id.answer);
        qsID = findViewById(R.id.QuestionID);

        RadioGroup grp = findViewById(R.id.radioGroup1);
        RadioButton answer = findViewById(grp.getCheckedRadioButtonId());

        mProgress= findViewById(R.id.progressBar);
        mProgress.setProgress(cProgress);
        qsID.setText("Question: "+cProgress);


        //Clear radio button check and set the questions and Check button (check button is swapped out with CONTINUE)
        grp.clearCheck();
        butCheck.setVisibility(View.VISIBLE);
        setQuestionView();

    }
// Set the questions, using the new 'current question' and the standard getter methods to get the new set of texts
    private void setQuestionView(){
        txtQuestion.setText(currentQuestion.getQuestion());
        rda.setText(currentQuestion.getOptA());
        rdb.setText(currentQuestion.getOptB());
        rdc.setText(currentQuestion.getOptC());
        quid++;
    }
//Button to handle check
    public void btCheckClick (View view) {
        RadioGroup grp = findViewById(R.id.radioGroup1);
        RadioButton answer = findViewById(grp.getCheckedRadioButtonId());
//Check to ensure a radio button is clicked otherwise toast
        if(grp.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this, "Please select an answer.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            //Toast.makeText(this, "Please select an answer.", Toast.LENGTH_SHORT).show();
            //Where radio buttons do exist, check the answer, if an answer exits, scores increased
            butCheck.setVisibility(View.GONE);
            butNext.setVisibility(View.VISIBLE);
            cv.setVisibility(View.VISIBLE);
            if(currentQuestion.getAnswer().equals(answer.getText())){
                attemptscore++;

                ansDetail.setText("Your answer is correct.\n\nThat is one extra point!");

            } else {
//handle incorrect answer
                ansDetail.setText("Your answer is incorrect.\n\nThe correct answer is: " +currentQuestion.getAnswer());
            }
        }
    }

    //2nd phase of two button clicking
    public void btClick(View view){
        RadioGroup grp = findViewById(R.id.radioGroup1);
        RadioButton answer = findViewById(grp.getCheckedRadioButtonId());

        //clears the radio button and increase the progress tracker
        grp.clearCheck();
        cProgress++;
        mProgress.setProgress(cProgress);

// for 5 question counts
        if(quid<5){
            currentQuestion = questionList.get(quid);
            setQuestionView();
            butCheck.setVisibility(View.VISIBLE);
            butNext.setVisibility(View.GONE);
            cv.setVisibility(View.GONE);
            qsID.setText("Question: "+cProgress);
        }else{
            //After 5 questions, intent into results
            Intent intent = new Intent(PhysicalQuiz.this, ResultActivity.class);
            intent.putExtra("attemptscore",attemptscore);
            intent.putExtra("category","Physical");
            startActivity(intent);
            finish();
        }

    }


}

