package vn.e.demoloadmore;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout srLayout;
    private RecyclerView lvList;

    private List<Student> students;

    private StudentAdapter studentAdapter;

    private EndlessRecyclerViewScrollListener scrollListener;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);

        //swipe to refresh
        // keo de f5 du lieu


        srLayout = findViewById(R.id.srLayout);
        lvList = findViewById(R.id.lvList);

        students = new ArrayList<>();


        for (int i = 0; i < 50; i++) {
            Student student = new Student();

            student.name = "Huy Nguyen " + System.currentTimeMillis();

            student.classID = "" + System.currentTimeMillis();

            students.add(student);
        }


        studentAdapter = new StudentAdapter(students, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lvList.setLayoutManager(linearLayoutManager);
        lvList.setAdapter(studentAdapter);


        srLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                students.clear();

                for (int i = 0; i < 10; i++) {
                    Student student = new Student();

                    student.name = "Quynh Nguyen " + System.currentTimeMillis();

                    student.classID = "" + System.currentTimeMillis();

                    students.add(student);
                }

                studentAdapter.notifyDataSetChanged();

                // tat trang thai loading
                srLayout.setRefreshing(false);


            }
        });



        // EndlessLove

        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Toast.makeText(MainActivity.this, "Item cuoi cung", Toast.LENGTH_LONG).show();

                progressDialog.show();
                for (int i = 0; i < 10; i++) {
                    Student student = new Student();

                    student.name = "Minh Nguyen " + System.currentTimeMillis();

                    student.classID = "" + System.currentTimeMillis();

                    students.add(student);
                }
                studentAdapter.notifyDataSetChanged();


                progressDialog.hide();

            }
        };

        lvList.addOnScrollListener(scrollListener);


    }
}
