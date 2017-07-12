package com.alfredobejarano.expenses.model;

import io.realm.RealmObject;

/**
 * This class serves as the expense DTO for saving it into Realm.
 *
 * @author @AlfredoBejarano
 * @version 1.0
 * @since 10/07/2017.
 */

public class Expense extends RealmObject {
    private int id;
    private String name;
    private String cost;

    public Expense() {
    }

    public Expense(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
