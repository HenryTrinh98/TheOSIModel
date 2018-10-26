package henryjade.theosimodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class About extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override

    //Create an expandable listview and set to an adapter. Reference: https://www.youtube.com/watch?v=jZxZIFnJ9jE
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        listView = findViewById(R.id.lessonsList);
        initData();
        listAdapter = new henryjade.theosimodel.ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
    }

    //Populate the expandable listview with data. Reference: https://www.youtube.com/watch?v=jZxZIFnJ9jE

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();
        listDataHeader.add("About Us");
        listDataHeader.add("About This Course");
        listDataHeader.add("Support");
        listDataHeader.add("Contact Us");
        listDataHeader.add("Terms");
        listDataHeader.add("Copyright and Disclaimer");

        List<String> aboutUs = new ArrayList<>();
        aboutUs.add("We launched in October 2018 to be a free and interactive initiate to IT, networking and cyber security learning");

        List<String> aboutCourse = new ArrayList<>();
        aboutCourse.add("You will learn to extend your knowledge of OSI");
        aboutCourse.add("The format of the course is through a series of lessons followed by quizzes to consolidate learning");

        List<String> support = new ArrayList<>();
        support.add("Frequently Asked Questions");
        support.add("Select a topic to search for help");
        support.add("Report an issue");

        List<String> contact = new ArrayList<>();
        contact.add("Address: Sydney NSW 2052");
        contact.add("P: 9385 1000");
        contact.add("E: name@unsw.edu.au");

        List<String> terms = new ArrayList<>();
        terms.add("Our mission is to improve lives through learning. We need rules to keep our platform and services safe for you, us and our student and instructor community");

        List<String> copyright = new ArrayList<>();
        copyright.add("This site contains a variety of copyright material.");


        listHash.put(listDataHeader.get(0), aboutUs);
        listHash.put(listDataHeader.get(1), aboutCourse);
        listHash.put(listDataHeader.get(2), support);
        listHash.put(listDataHeader.get(3), contact);
        listHash.put(listDataHeader.get(4), terms);
        listHash.put(listDataHeader.get(5), copyright);

    }
}
