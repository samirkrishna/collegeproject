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

class Attendance3EE : AppCompatActivity() {

    var imageView:ImageView?=null
    private var mRef: Firebase?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.attendance3ee)
        imageView=findViewById(R.id.ivca1)
        mRef= Firebase("https://collegeproject-3163b.firebaseio.com/EEE")
        mRef?.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: FirebaseError?) {

                Toast.makeText(this@Attendance3EE,"failed to load", Toast.LENGTH_LONG).show()

            }

            override fun onDataChange(p0: DataSnapshot?) {
                var url = p0!!.child("EEE3A").getValue().toString()
                Glide.with(this@Attendance3EE).
                        load(url).into(imageView!!)

            }
        })

    }
}
