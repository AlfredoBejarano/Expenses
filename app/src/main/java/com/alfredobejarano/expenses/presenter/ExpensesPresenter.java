package com.alfredobejarano.expenses.presenter;

import com.alfredobejarano.expenses.model.Expense;

import java.util.List;

import io.realm.Realm;
import io.realm.Realm.Transaction;
import io.realm.RealmResults;

/**
 * This class handles the storage of expenses.
 *
 * @author @AlfredoBejarano
 * @version 1.0
 * @since 10/07/2017.
 */

public class ExpensesPresenter {

    private ExpensesPresenter() {
    }

    public static String sumExpenses() {
        float total = 0.0f;
        for (Expense expense : retrieveExpenses()) {
            total = Float.parseFloat(expense.getCost()) + total;
        }
        return "$" + String.valueOf(total);
    }

    public static List<Expense> retrieveExpenses() {
        Realm mRealm = Realm.getDefaultInstance();
        mRealm.beginTransaction();
        List<Expense> expenses = mRealm.where(Expense.class).findAll();
        mRealm.commitTransaction();
        return expenses;
    }

    /**
     * Stores an expense to the local database.
     *
     * @param expense The expense
     */
    public static void storeExpense(final Expense expense) {
        Realm mRealm = Realm.getDefaultInstance();
        expense.setId(countExpensesStored() + 1);
        mRealm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(expense);
            }
        });
    }

    /**
     * Retrieves a single expense.
     *
     * @param id The expense id.
     * @return The expense.
     */
    public static Expense retrieveExpenseById(int id) {
        Realm mRealm = Realm.getDefaultInstance();
        mRealm.beginTransaction();
        Expense expense = mRealm.where(Expense.class).equalTo("id", id).findFirst();
        mRealm.commitTransaction();
        return expense;
    }

    /**
     * Deletes an expense.
     *
     * @param id The expense id.
     */
    public static void deleteExpense(int id) {
        Realm mRealm = Realm.getDefaultInstance();
        Expense expense = retrieveExpenseById(id);
        mRealm.beginTransaction();
        expense.deleteFromRealm();
        mRealm.commitTransaction();
    }

    /**
     * Counts all the expenses stored.
     *
     * @return The quantity of expenses stored.
     */
    private static int countExpensesStored() {
        Realm mRealm = Realm.getDefaultInstance();
        mRealm.beginTransaction();
        RealmResults<Expense> expenses = mRealm.where(Expense.class).findAll();
        mRealm.commitTransaction();
        return expenses.size();
    }
}
