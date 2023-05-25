package kd.microlearn.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import kd.microlearn.R
import kd.microlearn.databinding.ActivityAccountBinding
import kd.microlearn.main.MainApp

class AccountActivity : AppCompatActivity() {
    lateinit var app: MainApp
    private lateinit var binding: ActivityAccountBinding
    private lateinit var mDrawerLayout : DrawerLayout
    private lateinit var mToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarUser.title = title
        setSupportActionBar(binding.toolbarUser)

        app = application as MainApp

        mDrawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        mToggle = ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close)

        mDrawerLayout.addDrawerListener(mToggle)
        mToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (mToggle.onOptionsItemSelected(item)) {
            when(item.itemId) {
                R.id.navigation_portions -> {
                    val myIntent = Intent(this, PortionListActivity::class.java)
                    this.startActivity(myIntent)
                }
                R.id.navigation_account -> {
                    val myIntent = Intent(this, AccountActivity::class.java)
                    this.startActivity(myIntent)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}