package com.example.quintin.myfianancer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quintin.myfianancer.Objects.Item;

public class FinanceActivity extends AppCompatActivity {
    private Button addExpensesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

        registerButtons();
        setupButtons();
    }

    private void setupButtons() {
        addExpensesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinanceActivity.this, AddItemActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerButtons() {
        addExpensesBtn = findViewById(R.id.add_expense);
    }


}
