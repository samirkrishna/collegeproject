package com.has.sam.cej.myuniversity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CSE4F :Fragment() {

    var ttc4: Button?=null
    var sc4: Button?=null
    var ac4: Button?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v=inflater.inflate(R.layout.cse4f,container,false)
        ttc4=v.findViewById(R.id.ttc4)
        sc4=v.findViewById(R.id.sc4)
        ac4=v.findViewById(R.id.ac4)
        ttc4?.setOnClickListener({
            startActivity(Intent(activity,TimeTable4C::class.java))
        })
        sc4?.setOnClickListener({
            startActivity(Intent(activity,Syllabus4C::class.java))
        })
        ac4?.setOnClickListener({
            startActivity(Intent(activity,Syllabus4C::class.java))
        })
        return v

    }
}