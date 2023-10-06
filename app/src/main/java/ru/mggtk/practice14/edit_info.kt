package ru.mggtk.practice14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class edit_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_info)
        val emailEditText: EditText = findViewById(R.id.editTextTextEmailAddress)
        val nameEditText: EditText = findViewById(R.id.editTextText)
        val ageEditText: EditText = findViewById(R.id.editTextNumber)
        val data: Bundle? = intent.extras

        if (data != null) {
            val name: String = data.getString(MainActivity.NAME_KEY).toString()
            val email: String? = data.getString(MainActivity.EMAIL_KEY).toString()
            val age: Int = data.getInt(MainActivity.AGE_KEY)

            nameEditText.setText("$name")
            ageEditText.setText("$age")
            emailEditText.setText("$email")
        }
    }

    fun sendChangedData(view: View) {
        val emailEditText: EditText = findViewById(R.id.editTextTextEmailAddress)
        val nameEditText: EditText = findViewById(R.id.editTextText)
        val ageEditText: EditText = findViewById(R.id.editTextNumber)
        val name: String?;
        val age: Int?;
        val email: String?
        if(nameEditText.text.toString()!=""&&ageEditText.text.toString()!=""&&emailEditText.text.toString()!="")
        {
            name = nameEditText.text.toString()
            age = ageEditText.text.toString().toInt()
            email = emailEditText.text.toString()
            val intent: Intent = Intent(this@edit_info, MainActivity::class.java)

            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("email", email)

            startActivity(intent)
        }
        else
        {
            if(nameEditText.text.toString()=="")
                nameEditText.setText("Van")
            if(emailEditText.text.toString()=="")
                emailEditText.setText("vanDarkholme@example.com")
            if(ageEditText.text.toString()=="")
                ageEditText.setText("30")
        }

    }
}