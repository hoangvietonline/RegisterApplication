package com.example.registerapplication

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registerapplication.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnRegister.setOnClickListener {
            if (edtPwRegister.text.toString() == edtConfirmRegister.text.toString()) {
                SharedPreferencesUtils.userName = editUserNameRegister.text.toString()
                SharedPreferencesUtils.passWord = edtPwRegister.text.toString()
                setResult(Activity.RESULT_OK)
                finish()
            } else {
                Toast.makeText(this, "Confirm fail!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}