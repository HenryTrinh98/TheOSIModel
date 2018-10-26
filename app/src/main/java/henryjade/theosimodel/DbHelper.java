package henryjade.theosimodel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    //DB version, table and database name
    private static final int DB_VERSION = 3;
    private static final String DB_NAME = "quizdb";
    private static final String DB_TABLE = "quiztable";
    private static final String DB2_TABLE = "scoretable";

    //table column names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "optA";
    private static final String KEY_OPTB = "optB";
    private static final String KEY_OPTC = "optC";
    private static final String KEY_LAY = "layer";

    // table 2 columns
    private static final String KEY2_ID = "_id";
    private static final String KEY2_score = "score";
    private static final String KEY2_playdate = "playdate";
    private static final String KEY2_category = "category";

    private SQLiteDatabase dbase;
    private int rowCount = 0;

    //Constructor for a DatabaseHelper.
    public DbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        //First table
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT )", DB_TABLE, KEY_ID, KEY_QUES, KEY_ANSWER, KEY_OPTA, KEY_OPTB, KEY_OPTC, KEY_LAY);
        db.execSQL(sqlQuery);
        //Second table
        String sqlQuery1 = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT)", DB2_TABLE, KEY2_ID, KEY2_score, KEY2_playdate, KEY2_category);
        db.execSQL(sqlQuery1);
        //debugging log only
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery1);

        addQuestionsA();
        addQuestionsP();
        addDummyScores();
    }

    //Blank Method
    public void blankMethod(){

    }

    //Add Question Bank for Layer Application
    private void addQuestionsA() {
        Question q1 = new Question("Which of the following statements regarding the application layer is false?", "It is the top most layer", "It is included in the OSI model but not the TCP/IP model", "It sits on top of the presentation layer", "It is included in the OSI model but not the TCP/IP model", "Application");
        this.addQuestionToDB(q1);
        Question q2 = new Question("What are the 2 processes by which a client-server model can interact", "Socket, Remote Procedure Calls", "HTTP Protocol, Socket", "Peer-to-peer, Simple Main Transfer Protocol", "Socket, Remote Procedure Calls", "Application");
        this.addQuestionToDB(q2);
        Question q3 = new Question("Which of the following are application protocols?", "Domain Name System", "File Transfer Protocol", "All of the above", "All of the above", "Application");
        this.addQuestionToDB(q3);
        Question q4 = new Question("Which of the following is NOT an example of directory services", "Accounting", "Authentication", "Email", "Email", "Application");
        this.addQuestionToDB(q4);
        Question q5 = new Question("In a client-server model, both remote processes are executing at the same level and exchange data using shared resource", "True", "False", "This is true sometimes", "False", "Application");
        this.addQuestionToDB(q5);
        Question q6 = new Question("How many versions of an object can be sent over a single TCP connection in HTTP 1.1", "One", "Multiple", "None", "Multiple", "Application");
        this.addQuestionToDB(q6);
        Question q7 = new Question("The application layer serves all the other layers", "It only serves the Transport layer", "It serves the Presentation and Session Layer", "None of the above", "None of the above", "Application");
        this.addQuestionToDB(q7);
    }

    //Add Question Bank for Layer Physical

    private void addQuestionsP() {
        Question q1 = new Question("The order of Multiplexing requires system hardware called multiplexer and de-multiplexer, however what other element is required to allow data to be sent?", "The Coaxial Cable", "The medium", "The internet", "The medium", "Physical");
        this.addQuestionToDB(q1);
        Question q2 = new Question("At a broad level, one of the categories of switching could be described as \"Data is sent, no response expected.\" the other could be \"Data is sent, awaiting response.\". The below categories were described in which order?", "Connectionless, Connection Oriented", "Connection Oriented, Connectionless", "Connectionless, Connectionless", "Connectionless, Connection Oriented", "Physical");
        this.addQuestionToDB(q2);
        Question q3 = new Question("Some common reasons for transmission impairements may include: ", "Attenuation, Dispersion and Intermodulation", "Crosstalk, Double Speak and Impulse", "Load Music, Terrorism and Kanye West", "Attenuation, Dispersion and Intermodulation", "Physical");
        this.addQuestionToDB(q3);
        Question q4 = new Question("What layer can interact with the physical connectivity of stations?", "Physical", "Data Link", "Application", "Physical", "Physical");
        this.addQuestionToDB(q4);
        Question q5 = new Question("Signals are part of the Data Link layer as it does not physically link devices as opposed to cables.", "True, signals are a higher level as they are not physical", "True, signals are inherently classified as a data link layer technology", "False, the physical layer covers all technologies regarding the connection of stations/devices, inclusive of signals", "False, the physical layer covers all technologies regarding the connection of stations/devices, inclusive of signals", "Physical");
        this.addQuestionToDB(q5);
       // Question q6 = new Question("Question 6 Physical - Answer is C", "A", "B", "C", "C", "Physical");
       // this.addQuestionToDB(q6);
       // Question q7 = new Question("Question 7 Physical - Answer is A", "A", "B", "C", "A", "Physical");
       // this.addQuestionToDB(q7);
    }

    //Add Dummy Scores (as a test case)
    private void addDummyScores() {
        Scores s1 = new Scores(3,"21-10-2018","Session");
        this.addScoresToDBInitial(s1);
        Scores s2 = new Scores(4,"22-10-2018","Transport");
        this.addScoresToDBInitial(s2);
        Scores s3 = new Scores(4,"23-10-2018","Transport");
        this.addScoresToDBInitial(s3);
        Scores s4 = new Scores(5,"24-10-2018","Network");
        this.addScoresToDBInitial(s4);
        Scores s5 = new Scores(2,"25-10-2018","Presentation");
        this.addScoresToDBInitial(s5);
    }

    //method to add scores into the DB | Initial only - does not have the getWritable (As a single instance already uses the database, requesting to 'get' database will lock it.
    public void addScoresToDBInitial(Scores s){
        ContentValues values = new ContentValues();
        values.put(KEY2_score, s.getScore());
        values.put(KEY2_playdate, s.getPlaydate());
        values.put(KEY2_category, s.getCategory());
        dbase.insert(DB2_TABLE, null, values);
    }


//method to add scores into the DB - makes the database writeable
    public void addScoresToDB(Scores s){
        dbase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY2_score, s.getScore());
        values.put(KEY2_playdate, s.getPlaydate());
        values.put(KEY2_category, s.getCategory());
        dbase.insert(DB2_TABLE, null, values);
    }




// method to add questions to db
    public void addQuestionToDB(Question q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, q.getQuestion());
        values.put(KEY_ANSWER,q.getAnswer());
        values.put(KEY_OPTA,q.getOptA());
        values.put(KEY_OPTB,q.getOptB());
        values.put(KEY_OPTC,q.getOptC());
        values.put(KEY_LAY,q.getLayer());
        dbase.insert(DB_TABLE, null, values);
    }


    // gets all questions for "Application" layer
    public List <Question> getAllQuestionsA(){
        List <Question> questionList = new ArrayList<Question>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE layer = 'Application'";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptA(cursor.getString(3));
                q.setOptB(cursor.getString(4));
                q.setOptC(cursor.getString(5));
                questionList.add(q);

            }while (cursor.moveToNext());
        }
        return questionList;
    }


//method to grab most played category (raw sql used)
    public String getMostPlayedCat(){
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT *\n" +
                "FROM scoretable\n" +
                "GROUP By category\n" +
                "Having Count(*) = (\n" +
                "SELECT MAX(Cnt) FROM(\n" +
                "SELECT COUNT(*) as Cnt\n" +
                "FROM scoretable\n" +
                "GROUP BY category) tmp)\n" +
                "limit 1";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
            cursor.moveToFirst();
            String x = cursor.getString(3);
        return x;
    }

    //method to grab most played category and the # of times played for that category
    public String getMostPlayedCnt(){
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT MAX(Cnt) FROM(\n" +
                "SELECT COUNT(*) as Cnt\n" +
                "FROM scoretable\n" +
                "GROUP BY category)";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        String x = cursor.getString(0);
        return x;
    }


    //Get last played - as _id increases in decending order (auto-increments) this should logically work
    public String getLastPlayedCat(){
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * from scoretable order by _id DESC limit 1";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        String x = cursor.getString(3);
        return x;
    }

    //Get last played and grabs the play date instead (cursor id 2)
    public String getLastPlayedDay(){
        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * from scoretable order by _id DESC limit 1";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        String x = cursor.getString(2);
        return x;
    }


    // List last 5 scores
    public List <Scores> getLastScores() {
        List<Scores> sList = new ArrayList<>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * from scoretable order by _id DESC limit 5";
        Cursor cursor = dbase.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                Scores s = new Scores();
                s.setScore(cursor.getInt(1));
                s.setPlaydate(cursor.getString(2));
                s.setCategory(cursor.getString(3));
                sList.add(s);

            }while (cursor.moveToNext());
        }
        return sList;

    }

// Get array of questions for Physical Layer
    public List <Question> getAllQuestionsP(){
        List <Question> questionList = new ArrayList<Question>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE+" WHERE layer = 'Physical'";
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptA(cursor.getString(3));
                q.setOptB(cursor.getString(4));
                q.setOptC(cursor.getString(5));
                questionList.add(q);

            }while (cursor.moveToNext());
        }
        return questionList;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
        onCreate(db);
    }

    public int getRowCount(){
        return rowCount;
    }
}