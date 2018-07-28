package com.has.sam.cej.myuniversity

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.firebase.client.DataSnapshot
import com.firebase.client.Firebase
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener
import kotlinx.android.synthetic.main.activity_my_university.*
import kotlinx.android.synthetic.main.app_bar_my_university.*


class MyUniversity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var name: TextView?=null
    private var iview1: ImageView?=null
    private var iview2: ImageView?=null
    private var iview3: ImageView?=null
    private var mRef: Firebase?=null
    var iview: ImageView?=null
    //var click:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_university)
        setSupportActionBar(toolbar)
        Firebase.setAndroidContext(this)


        name=findViewById(R.id.name)

        name?.setOnClickListener({
            startActivity(Intent(this@MyUniversity,TimeTable::class.java
            ))
        })


       // var font= Typeface.createFromAsset(assets,"COMIC.TTF") //for font type
        //name?.setTypeface(font)



        iview=findViewById(R.id.iview)
        iview1=findViewById(R.id.iview1)
        iview2=findViewById(R.id.iview2)
        iview3=findViewById(R.id.iview3)



        mRef= Firebase("https://collegeproject-3163b.firebaseio.com/Users")

        mRef?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot?) {

                var value= p0?.child("Name")!!.getValue().toString()
                name?.setText(value)

                var url = p0.child("PVP")!!.getValue().toString()
                Glide.with(this@MyUniversity).
                        load(url).into(iview!!)

                var url1 = p0.child("Image1").getValue().toString()
                Glide.with(this@MyUniversity).
                        load(url1).into(iview1!!)

                var url2 = p0.child("Image2").getValue().toString()
                Glide.with(this@MyUniversity).
                        load(url2).into(iview2!!)

                var url3 = p0.child("Image3").getValue().toString()
                Glide.with(this@MyUniversity).
                        load(url3).into(iview3!!)

            }

            override fun onCancelled(p0: FirebaseError?) {

                Toast.makeText(this@MyUniversity,"Failed to load", Toast.LENGTH_LONG).show()

            }
        })




//Predefined code provided by android studio

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.my_university, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                startActivity(Intent(this@MyUniversity,MyUniversity::class.java))
            }
            R.id.nav_cse -> {
                startActivity(Intent(this@MyUniversity,CSE::class.java))
            }
            R.id.nav_ece -> {
                startActivity(Intent(this@MyUniversity,ECE::class.java))
            }
            R.id.nav_eee -> {
                startActivity(Intent(this@MyUniversity,EEE::class.java))
            }
            R.id.nav_mec -> {
                startActivity(Intent(this@MyUniversity,MEC::class.java))
            }
            R.id.nav_it -> {
                startActivity(Intent(this@MyUniversity,IT::class.java))
            }
            R.id.nav_collegeinfo -> {
                startActivity(Intent(this@MyUniversity,CollegeInfo::class.java))
            }
            R.id.nav_results -> {
                startActivity(Intent(this@MyUniversity,Results::class.java))
            }
            R.id.nav_examsinfo -> {
                startActivity(Intent(this@MyUniversity,ExamsInfo::class.java))
            }
            R.id.nav_contactus -> {
                startActivity(Intent(this@MyUniversity,ContactUs::class.java))
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
