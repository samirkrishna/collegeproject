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

class TimeTable4C : AppCompatActivity() {

    var imageView:ImageView?=null
    private var mRef: Firebase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timetable4c)
        imageView=findViewById(R.id.imageView4)
        mRef= Firebase("https://collegeproject-3163b.firebaseio.com/Users")
        mRef?.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: FirebaseError?) {

                Toast.makeText(this@TimeTable4C,"failed to load", Toast.LENGTH_LONG).show()

            }

            override fun onDataChange(p0: DataSnapshot?) {
                var url = p0!!.child("Click").getValue().toString()
                Glide.with(this@TimeTable4C).
                        load(url).into(imageView!!)

            }
        })

    }
}
