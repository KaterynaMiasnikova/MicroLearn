package kd.microlearn.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kd.microlearn.R
import kd.microlearn.databinding.ActivityThemeBinding
import kd.microlearn.main.MainApp
import kd.microlearn.models.ThemeModel
import timber.log.Timber


class ThemeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    private lateinit var binding: ActivityThemeBinding
    var theme = ThemeModel()
    var app : MainApp? = null
    lateinit var themeSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = "New Theme"
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        Timber.i("Portion Activity started...")

        val fab = findViewById<View>(R.id.commitTheme) as FloatingActionButton
        fab.setOnClickListener {
            finish()
        }

        val areaSpinner: Spinner = findViewById(R.id.areaSpinner)
        areaSpinner.onItemSelectedListener = this
        val a: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, app!!.areas.getAreasNames())
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        areaSpinner.adapter = a

        themeSpinner = findViewById(R.id.themeSpinner)
        themeSpinner.onItemSelectedListener = this
        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, app!!.themes.getThemesNamesOfArea( app!!.areas.findAreaByName(areaSpinner.getItemAtPosition(0) as String).id_area))
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        themeSpinner.adapter = aa
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_theme, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> { finish() }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            if (parent.id == R.id.areaSpinner) {

                val aa: ArrayAdapter<*> =
                    ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, app!!.themes.getThemesNamesOfArea(
                        app!!.areas.findAreaByName(parent.getItemAtPosition(position) as String).id_area))
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                themeSpinner.adapter = aa

            } else if (parent.id == R.id.themeSpinner) {
                theme = app?.themes?.findThemeByName(parent.getItemAtPosition(position) as String)!!
                Timber.i(theme.toString())
                Toast.makeText(applicationContext, ""+ parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext, "BAAAAAAAAAAAD", Toast.LENGTH_LONG).show();
    }
}