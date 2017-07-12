package com.alfredobejarano.expenses.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alfredobejarano.expenses.R;
import com.alfredobejarano.expenses.model.Expense;
import com.alfredobejarano.expenses.presenter.ExpensesPresenter;
import com.alfredobejarano.expenses.view.activity.ExpensesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * This class handles the rendering of each expense in the list.
 *
 * @author @AlfredoBejarano
 * @version 1.0
 * @since 10/07/2017.
 */

public class ExpensesViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.expense_name)
    TextView mExpenseName;
    @BindView(R.id.expense_cost)
    TextView mExpenseCost;
    private Expense mExpense;
    private ExpensesActivity mActivity;

    public ExpensesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void render(Expense expense, ExpensesActivity activity) {
        mExpense = expense;
        mActivity = activity;
        mExpenseCost.setText("$" + mExpense.getCost());
        mExpenseName.setText(mExpense.getName());
    }

    @OnClick(R.id.item_expense_root)
    public void deleteExpense() {
        ExpensesPresenter.deleteExpense(mExpense.getId());
        mActivity.refreshExpenses();
    }
}
