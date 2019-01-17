package com.example.quintin.myfianancer;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quintin.myfianancer.Objects.DatePickerFragment;
import com.example.quintin.myfianancer.Objects.DbHelper;
import com.example.quintin.myfianancer.Objects.Item;

import java.text.DateFormat;
import java.util.Calendar;

public class AddItemActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    public static final String TAG = "tag";
    private ImageView dateButton;
    private TextView date;
    private EditText price;
    private EditText name;
    private Button addBtn;
    DbHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        initialize();
        registerDateButton();
        registerAddButton();

    }

    private void initialize() {
        name = findViewById(R.id.answer_name);
        price = findViewById(R.id.answer_price);
        date = findViewById(R.id.answer_date);
        addBtn = findViewById(R.id.addNewItemBtn);
        mDatabaseHelper = new DbHelper(this);
    }


    private boolean validate() {
        boolean valid = true;
        Log.d(TAG, "validating? _----------------------");
        if(name.getText().toString().isEmpty()) {
            name.setError("Enter the name of the item");
            valid = false;
        }
        if(price.getText().toString().isEmpty()) {
            price.setError("Enter the price of the item");
            valid = false;
        }
        if(date.getText().toString().isEmpty()) {
            date.setError("Enter the date");
            valid = false;
        }
        return valid;
    }

    private void registerAddButton() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    String tempName = name.getText().toString();
                    String tempPrice = price.getText().toString();
                    String tempDate = date.getText().toString();
                    int price = Integer.parseInt(tempPrice);
                    addData(tempName, price, tempDate);
//                    Toast.makeText(AddItemActivity.this, tempName + tempPrice + tempDate, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registerDateButton() {
        dateButton = findViewById(R.id.calendar);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String dateFormat = DateFormat.getDateInstance().format(c.getTime());

        TextView tv = findViewById(R.id.answer_date);
        tv.setText(dateFormat);

    }

    private void addData(String name, int price, String date) {
        boolean insertData = mDatabaseHelper.insertData(name, price, date);

        if(insertData) {
            Toast.makeText(this,"Added new expense", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddItemActivity.this, FinanceActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Failed to add new expense", Toast.LENGTH_SHORT).show();
        }
    }

}
