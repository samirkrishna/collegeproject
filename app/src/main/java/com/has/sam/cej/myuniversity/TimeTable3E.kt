package com.has.sam.cej.myuniversity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.firebase.client.DataSnapshot
import com.firebase.client.Firebase
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener

class TimeTable3E : AppCompatActivity() {

    var imageView:ImageView?=null
    private var mRef: Firebase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timetable3e)
        imageView=findViewById(R.id.imageView1)
        mRef= Firebase("https://collegeproject-3163b.firebaseio.com/ECE")
        mRef?.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: FirebaseError?) {

                Toast.makeText(this@TimeTable3E,"failed to load", Toast.LENGTH_LONG).show()

            }

            override fun onDataChange(p0: DataSnapshot?) {
                var url = p0!!.child("ECE3TT").getValue().toString()
                Glide.with(this@TimeTable3E).
                        load(url).into(imageView!!)

            }
        })

    }
}
