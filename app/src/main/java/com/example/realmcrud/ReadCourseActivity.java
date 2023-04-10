package com.example.realmcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import io.realm.Realm;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;


public class ReadCourseActivity extends AppCompatActivity {

    List<DataModel> dataModals;
    private Realm realm;
    private RecyclerView coursesRV;
    private CourseRVAdapter courseRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_course);

        coursesRV = findViewById(R.id.idRVCourses);
        realm = Realm.getDefaultInstance();
        dataModals = new ArrayList<>();

        // calling a method to load
        // our recycler view with data.
        prepareRecyclerView();
    }

    private void prepareRecyclerView() {
        // on below line we are getting data from realm database in our list.
        dataModals = realm.where(DataModel.class).findAll();
        // on below line we are adding our list to our adapter class.
        courseRVAdapter = new CourseRVAdapter(dataModals, this);
        // on below line we are setting layout manager to our recycler view.
        coursesRV.setLayoutManager(new LinearLayoutManager(this));
        // at last we are setting adapter to our recycler view.
        coursesRV.setAdapter(courseRVAdapter);
    }
}