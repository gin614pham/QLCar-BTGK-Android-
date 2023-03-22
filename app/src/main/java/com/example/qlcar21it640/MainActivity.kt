package com.example.qlcar21it640

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // set OnClick Listener for button "Add"
        findViewById<Button>(R.id.btnInsert).setOnClickListener {
            // Create an Intent to launch the second Activity
            val intent = Intent(this, InsertActivity21IT640::class.java)
            // Start the new Activity
            startActivity(intent)
        }
        // set OnClick Listener for button "List"
        findViewById<Button>(R.id.btnList).setOnClickListener {
            // Create an Intent to launch the second Activity
            val intent = Intent(this, ListCarActivity21IT640::class.java)
            // Start the new Activity
            startActivity(intent)
        }
    }
}