package com.example.registerapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registerapplication.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val REQUEST_CODE_REGISTER = 123
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            if (edtUserName.text.toString() == SharedPreferencesUtils.userName && edtPwLogin.text.toString() == SharedPreferencesUtils.passWord) {
                Toast.makeText(this, "Login Success!!", Toast.LENGTH_SHORT).show()
            }
        }
        btnRegisterLogin.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_REGISTER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_REGISTER && resultCode == Activity.RESULT_OK) {

        }
    }
}