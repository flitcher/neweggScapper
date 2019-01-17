package com.example.quintin.myfianancer.Objects;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quintin.myfianancer.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ItemViewHolder> {
    private ArrayList<Item> mExpenseList;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView frag_name;
        public TextView frag_price;
        public TextView frag_date;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            frag_name = itemView.findViewById(R.id.recycler_name);
            frag_price = itemView.findViewById(R.id.recycler_price);
            frag_date = itemView.findViewById(R.id.recycler_date);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(v);
        return viewHolder;
    }

    // constructor to receive list of expenses for recycler view to process
    public ExpenseAdapter(ArrayList<Item> expenseList) {
         mExpenseList = expenseList;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        Item currItem = mExpenseList.get(i);

        itemViewHolder.frag_name.setText(currItem.getName());
        itemViewHolder.frag_price.setText(Integer.toString(currItem.getPrice()));
        itemViewHolder.frag_date.setText(currItem.getDatePurhase());
    }

    @Override
    public int getItemCount() {
        return mExpenseList.size();
    }
}
