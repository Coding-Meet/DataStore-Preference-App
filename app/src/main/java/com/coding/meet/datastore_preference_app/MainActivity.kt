package com.coding.meet.datastore_preference_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edName = findViewById<EditText>(R.id.edName)
        val edAge = findViewById<EditText>(R.id.edAge)
        val btnSet = findViewById<Button>(R.id.btnSet)
        val btnGet = findViewById<Button>(R.id.btnGet)
        val btnClear = findViewById<Button>(R.id.btnClear)

        btnClear.setOnClickListener {
            edName.text = null
            edAge.text = null
        }

        val dataStorePreferenceManger = DataStorePreferenceManger(this)
        btnGet.setOnClickListener {
            edName.setText(dataStorePreferenceManger.name)
            edAge.setText(dataStorePreferenceManger.age.toString())
        }


        btnSet.setOnClickListener {
            if (edName.text.toString().isEmpty()){
                edName.error = "Required"
            }else if (edAge.text.toString().isEmpty()){
                edAge.error = "Required"
            }else{
                dataStorePreferenceManger.name = edName.text.toString()
                dataStorePreferenceManger.age = edAge.text.toString().toInt()
            }
        }

    }
}