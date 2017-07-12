package com.alfredobejarano.expenses.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.alfredobejarano.expenses.R;
import com.alfredobejarano.expenses.model.Expense;
import com.alfredobejarano.expenses.presenter.ExpensesPresenter;
import com.alfredobejarano.expenses.view.activity.ExpensesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This dialog shows up when a expense is going to be added.
 *
 * @author @AlfredoBejarano
 * @version 1.0
 * @since 10/07/2017.
 */

public class AddExpenseDialog extends AlertDialog implements DialogInterface.OnClickListener {
    @BindView(R.id.add_expense_cost)
    EditText mExpenseCost;
    @BindView(R.id.add_expense_name)
    EditText mExpenseName;
    private ExpensesActivity mActivity;

    public AddExpenseDialog(@NonNull Context context, ExpensesActivity activity) {
        super(context);
        View root = LayoutInflater.from(context).inflate(R.layout.dialog_add_expense, null);
        ButterKnife.bind(this, root);
        setView(root);
        mActivity = activity;
        setTitle(context.getString(R.string.add_expense));
        setButton(BUTTON_POSITIVE, context.getString(R.string.add_expense), this);
        setButton(BUTTON_NEGATIVE, context.getString(R.string.close), this);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int button) {
        if (button == BUTTON_POSITIVE) {
            ExpensesPresenter.storeExpense(new Expense(mExpenseName.getText().toString(), mExpenseCost.getText().toString()));
            mActivity.refreshExpenses();
        } else {
            dismiss();
        }
    }
}
