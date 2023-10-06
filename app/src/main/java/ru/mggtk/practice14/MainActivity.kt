package ru.mggtk.practice14

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    companion object{
        const val AGE_KEY: String = "age"
        const val EMAIL_KEY: String = "email"
        const val NAME_KEY: String = "name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailEditText: EditText = findViewById(R.id.editTextTextEmailAddress)
        emailEditText.requestFocus()
        val nameEditText: EditText = findViewById(R.id.editTextText)
        val ageEditText: EditText = findViewById(R.id.editTextNumber)
        val data: Bundle? = intent.extras

        if (data != null) {
            val name: String = data.getString(NAME_KEY).toString()
            val email: String? = data.getString(EMAIL_KEY).toString()
            val age: Int = data.getInt(AGE_KEY)

            nameEditText.setText("$name")
            ageEditText.setText("$age")
            emailEditText.setText("$email")
        }
    }

    fun sendDataToNextActivityButton(view: View) {
        val emailEditText: EditText = findViewById(R.id.editTextTextEmailAddress)
        val nameEditText: EditText = findViewById(R.id.editTextText)
        val ageEditText: EditText = findViewById(R.id.editTextNumber)
        val name: String?;
        val age: Int?;
        val email: String?

        if (emailEditText.text.toString() == "") {
            Toast.makeText(this, "Введите ваш E-mail!", Toast.LENGTH_SHORT).show()
            emailEditText.requestFocus()
        }
        else if (nameEditText.text.toString() == "") {
            Toast.makeText(this, "Введите ваше имя!", Toast.LENGTH_SHORT).show()
            nameEditText.requestFocus()
        }
        else if (ageEditText.text.toString() == "") {
            Toast.makeText(this, "Введите ваш возраст!", Toast.LENGTH_SHORT).show()
            ageEditText.requestFocus()
        }
        else if (true) {
            name = nameEditText.text.toString()
            age = ageEditText.text.toString().toInt()
            email = emailEditText.text.toString()
            val intent: Intent = Intent(this@MainActivity, edit_info::class.java)

            intent.putExtra(NAME_KEY, name)
            intent.putExtra(AGE_KEY, age)
            intent.putExtra(EMAIL_KEY, email)
            startActivity(intent)
        }
        else {
            if (nameEditText.text.toString() == "")
                nameEditText.setText("null")
            if (emailEditText.text.toString() == "")
                emailEditText.setText("null")
            if (ageEditText.text.toString() == "")
                ageEditText.setText("0")
        }
    }
}