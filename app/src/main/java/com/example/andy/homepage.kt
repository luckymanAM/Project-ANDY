package com.example.andy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class homepage : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.navigationview)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_open_drawer,R.string.navigation_close_drawer)
        drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.home_page -> replacefragment(Homefragment(),it.title.toString())
                R.id.search_donor -> replacefragment(sendEmailfragment(),it.title.toString())
                R.id.createrequest ->replacefragment(create_request_fragment(),it.title.toString())
                R.id.a_plus -> Toast.makeText(applicationContext, "clicked a plus", Toast.LENGTH_SHORT).show()
                R.id.a_minus -> Toast.makeText(applicationContext, "a_minus", Toast.LENGTH_SHORT).show()
                R.id.b_minus -> Toast.makeText(applicationContext, "clicked b minus", Toast.LENGTH_SHORT).show()
                R.id.b_plus -> Toast.makeText(applicationContext, "clicked b plus", Toast.LENGTH_SHORT).show()
                R.id.ab_plus -> Toast.makeText(applicationContext, "clicked ab plus", Toast.LENGTH_SHORT).show()
                R.id.ab_minus -> Toast.makeText(applicationContext, "clicked ab minus", Toast.LENGTH_SHORT).show()
                R.id.o_minus -> Toast.makeText(applicationContext, "clicked o minus", Toast.LENGTH_SHORT).show()
                R.id.o_plus -> Toast.makeText(applicationContext, "clicked o plus", Toast.LENGTH_SHORT).show()
                R.id.profile -> replacefragment(ProfileFragment(),it.title.toString())
                R.id.notification -> Toast.makeText(applicationContext, "clicked home", Toast.LENGTH_SHORT).show()
                R.id.logout -> Toast.makeText(applicationContext, "clicked home", Toast.LENGTH_SHORT).show()
               // R.id.card1 -> replacefragment(Homefragment(),it.title.toString())
                //R.id.card2 -> replacefragment(Homefragment(),it.title.toString())
               // R.id.card3 -> replacefragment(ProfileFragment(),it.title.toString())
                //R.id.card4 -> replacefragment(Homefragment(),it.title.toString())

            }
            true
        }
    }
    private fun replacefragment(fragment: Fragment,title : String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}