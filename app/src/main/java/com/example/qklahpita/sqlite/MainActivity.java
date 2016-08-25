package com.example.qklahpita.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MathWord> list;
    private DBContext dbContext;
    private ListQuestionAdapter listQuestionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
        fillDataToRecyclerView();
    }

    private void init() {
        list = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        dbContext = DBContext.getInst(this);
    }

    private void getData() {
        dbContext.openConnection();
        list = dbContext.getAllMathWord();
        dbContext.closeConnection();
        listQuestionAdapter = new ListQuestionAdapter(list, this);

    }

    private void fillDataToRecyclerView() {
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listQuestionAdapter);
    }
}
