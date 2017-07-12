package com.alfredobejarano.expenses.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alfredobejarano.expenses.R;
import com.alfredobejarano.expenses.model.Expense;
import com.alfredobejarano.expenses.view.activity.ExpensesActivity;
import com.alfredobejarano.expenses.view.viewholder.ExpensesViewHolder;

import java.util.List;

/**
 * This class handles all the Expenses list filling.
 *
 * @author @AlfredoBejarano
 * @version 1.0
 * @since 10/07/2017.
 */

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesViewHolder> {
    private List<Expense> mExpenses;
    private ExpensesActivity mView;

    public ExpensesAdapter(List<Expense> expenses, ExpensesActivity view) {
        mExpenses = expenses;
        mView = view;
    }

    @Override
    public ExpensesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExpensesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false));
    }

    @Override
    public void onBindViewHolder(ExpensesViewHolder holder, int position) {
        holder.render(mExpenses.get(position), mView);
    }

    @Override
    public int getItemCount() {
        return mExpenses.size();
    }
}
