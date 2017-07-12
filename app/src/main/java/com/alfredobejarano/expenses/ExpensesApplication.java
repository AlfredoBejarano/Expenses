package com.alfredobejarano.expenses;

import android.app.Application;

import io.realm.Realm;

/**
 * This class handles all the global configurations for the app.
 *
 * @author @AlfredoBejarano
 * @version 1.0
 * @since 10/07/2017.
 */

public class ExpensesApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
