package com.has.sam.cej.myuniversity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class CSE2F :Fragment() {


    var ttc2: Button?=null
    var sc2: Button?=null
    var ac2: Button?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v=inflater.inflate(R.layout.cse2f,container,false)
        ttc2=v.findViewById(R.id.ttc2)
        sc2=v.findViewById(R.id.sc2)
        ac2=v.findViewById(R.id.ac2)
        ttc2?.setOnClickListener({


            var intent = Intent(getActivity(),TimeTable::class.java)
            startActivity(intent)
        })
        sc2?.setOnClickListener({
            startActivity(Intent(activity,Syllabus2C::class.java))
        })
        return v

    }
}