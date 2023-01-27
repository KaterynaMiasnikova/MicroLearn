package kd.microlearn.activities

import android.R.attr.value
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kd.microlearn.R
import kd.microlearn.adapters.PortionAdapter
import kd.microlearn.adapters.PortionListener
import kd.microlearn.databinding.ActivityPortionListBinding
import kd.microlearn.main.MainApp
import kd.microlearn.models.PortionModel


class PortionListActivity : AppCompatActivity(), PortionListener {
    lateinit var app: MainApp
    private lateinit var binding: ActivityPortionListBinding
    private lateinit var mDrawerLayout : DrawerLayout
    private lateinit var mToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPortionListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = PortionAdapter(app.portions.findAllOfTheme(app.usersThemes), this)

        mDrawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        mToggle = ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close)

        mDrawerLayout.addDrawerListener(mToggle)
        mToggle.syncState()

        val appBarConfiguration = AppBarConfiguration(binding.navigationView.menu, binding.drawerLayout)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fab = findViewById<View>(R.id.addTheme) as FloatingActionButton
        fab.setOnClickListener { view ->
            val launcherIntent = Intent(this, ThemeActivity::class.java)
            getClickResult.launch(launcherIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (mToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPortionClick(portion: PortionModel) {
        val launcherIntent = Intent(this, PortionActivity::class.java)
        launcherIntent.putExtra("portion_show", portion)
        getClickResult.launch(launcherIntent)
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0, app.portions.findAllOfTheme(app.usersThemes).size)
            }
        }

    private val getClickResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0, app.portions.findAllOfTheme(app.usersThemes).size +1)
            }
        }
}