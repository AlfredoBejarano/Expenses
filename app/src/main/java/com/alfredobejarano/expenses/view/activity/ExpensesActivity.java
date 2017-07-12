package com.alfredobejarano.expenses.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alfredobejarano.expenses.R;
import com.alfredobejarano.expenses.presenter.ExpensesAdapter;
import com.alfredobejarano.expenses.presenter.ExpensesPresenter;
import com.alfredobejarano.expenses.view.dialog.AddExpenseDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExpensesActivity extends AppCompatActivity {
    @BindView(R.id.add_expense)
    FloatingActionButton mFab;
    @BindView(R.id.expenses_list)
    RecyclerView mExpensesList;
    @BindView(R.id.balance)
    TextView mBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mExpensesList.setLayoutManager(new LinearLayoutManager(this));
        refreshExpenses();
    }

    public void refreshExpenses() {
        mExpensesList.setAdapter(new ExpensesAdapter(ExpensesPresenter.retrieveExpenses(), this));
        mExpensesList.invalidate();
        mBalance.setText(ExpensesPresenter.sumExpenses());
    }

    @OnClick(R.id.add_expense)
    public void addExpense() {
        new AddExpenseDialog(this, this).show();
    }
}
