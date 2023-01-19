package kd.microlearn.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kd.microlearn.R
import kd.microlearn.databinding.ActivityPortionBinding
import kd.microlearn.main.MainApp
import kd.microlearn.models.PortionModel
import timber.log.Timber.i

class PortionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPortionBinding
    var portion = PortionModel()
    var app : MainApp? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPortionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = "Portion"
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp
        i("Portion Activity started...")
        if (intent.hasExtra("portion_show")) {
            portion = intent.extras?.getParcelable("portion_show")!!
            binding.portionName.text = getString(R.string.show_underlined, portion.title_portion)
            binding.portionText.text = portion.text_portion
            binding.toolbarAdd.title = app!!.themes.getById(portion.id_theme).title_theme
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_portion, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> { finish() }
        }
        return super.onOptionsItemSelected(item)
    }
}