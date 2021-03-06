package com.has.sam.cej.myuniversity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.cse1f.*

class ECE1F :Fragment() {


    var ttc1:Button?=null
    var sc1:Button?=null
    var ac1:Button?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v=inflater.inflate(R.layout.ece1f,container,false)
        ttc1=v.findViewById(R.id.ttc1)
        sc1=v.findViewById(R.id.sc1)
        ac1=v.findViewById(R.id.ac1)
        ttc1?.setOnClickListener({
           /* var fManager=fragmentManager
            var tx=fManager?.beginTransaction()
            tx?.replace(R.id.frag1,TimeTable1C())
            tx?.commit()
            tx?.addToBackStack("true")*/
            startActivity(Intent(activity,TimeTable1E::class.java))
        })
        sc1?.setOnClickListener({
            startActivity(Intent(activity,Syllabus1e::class.java))
        })
        ac1?.setOnClickListener({
            startActivity(Intent(activity,Attendance1E::class.java))
        })

        return v

    }

}