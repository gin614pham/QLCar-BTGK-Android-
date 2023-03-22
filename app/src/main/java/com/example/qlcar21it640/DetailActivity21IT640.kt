package com.example.qlcar21it640

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase

class DetailActivity21IT640 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_activity21_it640)
        // get data
        val carID = intent.getStringExtra("carID")
        val carName = intent.getStringExtra("carName")
        val carNum = intent.getIntExtra("carNum", 0)
        val carType = intent.getStringExtra("carType")
        // set data
        findViewById<TextView>(R.id.textViewID).text = carID
        findViewById<TextView>(R.id.textView3).text = carName
        findViewById<TextView>(R.id.textViewNum).text = carNum.toString()
        findViewById<TextView>(R.id.textView5).text = carType
        // set on click listener for button "Back"
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            // return to main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        // set OnClik Listener for button "Delete"
        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            // delete data and notify user
            val dbRef = FirebaseDatabase.getInstance().getReference("Cars")
            dbRef.child(carID!!).removeValue()
            // return to main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}