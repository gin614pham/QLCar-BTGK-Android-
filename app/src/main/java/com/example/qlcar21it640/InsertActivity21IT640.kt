package com.example.qlcar21it640

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertActivity21IT640 : AppCompatActivity() {
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_activity21_it640)
        //get refernce to database
        dbRef = FirebaseDatabase.getInstance().getReference("Cars")
        // set OnClick Listener for button "Add"
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            // check data
            if (checkData()) {
                // get data
                val carID = findViewById<EditText>(R.id.eTCarID).text.toString()
                val carName = findViewById<EditText>(R.id.eTCarName).text.toString()
                val carNum = findViewById<EditText>(R.id.eTCarNum).text.toString().toInt()
                var carType = ""
                // if radio button is "Mới" then set carType = "Mới"
                if (findViewById<RadioButton>(R.id.rBNew).isChecked) {
                    carType = "Mới"
                } else {
                    carType = "Cũ"
                }
                // create object
                val carModel = CarModel(
                    carID = carID,
                    carName = carName,
                    carNum = carNum,
                    carType = carType
                )
                // add data to database and check for errors
                dbRef.push().setValue(carModel).addOnCompleteListener{
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show()
                        // clear data
                        findViewById<EditText>(R.id.eTCarID).setText("")
                        findViewById<EditText>(R.id.eTCarName).setText("")
                        findViewById<EditText>(R.id.eTCarNum).setText("")
                    }
                }



            }
        }
    }

    // check data
    private fun checkData(): Boolean {
            // check if the EditTexts "eTCarID" are not empty
        if (findViewById<EditText>(R.id.eTCarID).text.isEmpty()) {
            // notify the user that the carID is not empty
            Toast.makeText(this, "Mã xe không được để trống", Toast.LENGTH_SHORT).show()
            return false
        }

        // check if the EditText "eTCarNAme" are not empty
        if (findViewById<EditText>(R.id.eTCarName).text.isEmpty()) {
            // notify the user that the carName is not empty
            Toast.makeText(this, "Tên xe không được để trống", Toast.LENGTH_SHORT).show()
            return false
        }
        // check if the EditText "eTCarNum" < 4
        if (findViewById<EditText>(R.id.eTCarNum).text.isNotEmpty()) {
            if (findViewById<EditText>(R.id.eTCarNum).text.toString().toInt() < 4) {
                // notify the user that the carNum is not empty
                Toast.makeText(this, "Số chỗ không hợp lệ", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        if (findViewById<EditText>(R.id.eTCarNum).text.isEmpty()){
            // notify the user that the carNum is not empty
            Toast.makeText(this, "Số chỗ không được để trống", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}