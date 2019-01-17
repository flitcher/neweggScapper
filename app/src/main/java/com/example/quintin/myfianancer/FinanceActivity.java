package com.example.quintin.myfianancer;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quintin.myfianancer.Objects.DbHelper;
import com.example.quintin.myfianancer.Objects.ExpenseAdapter;
import com.example.quintin.myfianancer.Objects.Item;

import java.util.ArrayList;
import java.util.List;

public class FinanceActivity extends AppCompatActivity {

    public static final String TAG = "tag";
    private Button addExpensesBtn;
    private TextView totalExpense;
    private DbHelper mDatabaseHelper;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

        initialize();
        setupButtons();
    }

    private void initialize() {
        addExpensesBtn = findViewById(R.id.add_expense);
        totalExpense = findViewById(R.id.totalExpense);
        mDatabaseHelper = new DbHelper(this);
        retrieveData();

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExpenseAdapter(items);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void retrieveData() {
        Cursor data = mDatabaseHelper.getData();

        // get data of each expense (in rows) from data
        // iterate through each rows
        // store into ArrayList of items
        int total = 0;
        while(data.moveToNext()) {
            Item newItem = new Item(data.getString(1), data.getInt(2), data.getString(3));
            items.add(newItem);
            total += newItem.getPrice();
            Log.d(TAG, "item" + newItem.getName());
        }
        if(total != 0) {
            totalExpense.setText(Integer.toString(total));
        }
    }

    private void setupButtons() {
        addExpensesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinanceActivity.this, AddItemActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
