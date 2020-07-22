package com.example.registerapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

public class SharedPrefsFactory {
    private static SharedPrefsFactory mInstance;
    private SharedPreferences mSharedPreferences;


    private SharedPrefsFactory() {
        // No-op
    }

    public static SharedPrefsFactory getInstance() {
        if (mInstance == null) {
            mInstance = new SharedPrefsFactory();
        }
        return mInstance;
    }

    public void initConfig(@NonNull Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass) {
        if (mSharedPreferences == null) {
            throw new RuntimeException("Please int Shared Preferences first!");
        }
        if (anonymousClass == String.class) {
            return (T) mSharedPreferences.getString(key, "");
        } else if (anonymousClass == Boolean.class) {
            return (T) Boolean.valueOf(mSharedPreferences.getBoolean(key, false));
        } else if (anonymousClass == Float.class) {
            return (T) Float.valueOf(mSharedPreferences.getFloat(key, 0));
        } else if (anonymousClass == Integer.class) {
            return (T) Integer.valueOf(mSharedPreferences.getInt(key, 0));
        } else if (anonymousClass == Long.class) {
            return (T) Long.valueOf(mSharedPreferences.getLong(key, 0));
        }
        return null;
    }

    public <T> void put(String key, T data) {
        if (mSharedPreferences == null) {
            throw new RuntimeException("Please int Shared Preferences first!");
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (data instanceof String) {
            editor.putString(key, (String) data);
        } else if (data instanceof Boolean) {
            editor.putBoolean(key, (Boolean) data);
        } else if (data instanceof Float) {
            editor.putFloat(key, (Float) data);
        } else if (data instanceof Integer) {
            editor.putInt(key, (Integer) data);
        } else if (data instanceof Long) {
            editor.putLong(key, (Long) data);
        }
        editor.apply();
    }

    public void clear() {
        if (mSharedPreferences == null) {
            throw new RuntimeException("Please int Shared Preferences first!");
        }
        mSharedPreferences.edit().clear().apply();
    }

    public boolean contain(String key) {
        return mSharedPreferences != null && mSharedPreferences.contains(key);
    }
}
