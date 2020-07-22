package com.example.registerapplication.utils

object SharedPreferencesUtils {
    private const val USER_NAME = "user_name_key"
    private const val PASSWORD = "quick_recording"
    var userName: String
        get() = SharedPrefsFactory.getInstance()
            .get(USER_NAME, String::class.java)
        set(value) {
            SharedPrefsFactory.getInstance().put(USER_NAME, value)
        }
    var passWord: String
        get() = SharedPrefsFactory.getInstance()
            .get(PASSWORD, String::class.java)
        set(value) {
            SharedPrefsFactory.getInstance().put(PASSWORD, value)
        }
}