package com.example.qlcar21it640

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qlcar21it640.adapter.RvAdapter
import com.example.qlcar21it640.adapter.RvDetail
import com.google.firebase.database.*

class ListCarActivity21IT640 : AppCompatActivity() {
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_car_activity21_it640)
        // get recycler view
        val rVList = findViewById<RecyclerView>(R.id.rVList)
        rVList.setHasFixedSize(true)
        rVList.layoutManager = LinearLayoutManager(this)
        // get all data
        dbRef = FirebaseDatabase.getInstance().getReference("Cars")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // get data
                val list = ArrayList<CarModel>()
                for (ds in snapshot.children) {
                    val model = ds.getValue(CarModel::class.java)
                    list.add(model!!)
                }
                // set adapter
                rVList.adapter = RvAdapter(list, object : RvDetail {
                    override fun onClick(position: Int) {
                        // get data
                        val model = list[position]
                        // put data to intent
                        val intent = Intent(this@ListCarActivity21IT640, DetailActivity21IT640::class.java)
                        intent.putExtra("carID", model.carID)
                        intent.putExtra("carName", model.carName)
                        intent.putExtra("carNum", model.carNum)
                        intent.putExtra("carType", model.carType)
                        startActivity(intent)

                    }
                })
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        )
    }
}