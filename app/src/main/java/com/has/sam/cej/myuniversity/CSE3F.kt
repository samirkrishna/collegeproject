package com.has.sam.cej.myuniversity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CSE3F :Fragment() {

    var ttc3: Button?=null
    var sc3: Button?=null
    var ac3: Button?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v=inflater.inflate(R.layout.cse3f,container,false)
        ttc3=v.findViewById(R.id.ttc3)
        sc3=v.findViewById(R.id.sc3)
        ac3=v.findViewById(R.id.ac3)
        ttc3?.setOnClickListener({
            startActivity(Intent(activity,TimeTable3C::class.java))
        })
        sc3?.setOnClickListener({
            startActivity(Intent(activity,Syllabus3C::class.java))
        })
        ac3?.setOnClickListener({
            startActivity(Intent(activity,Attendance3C::class.java))
        })
        return v

    }
}