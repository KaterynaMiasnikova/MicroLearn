package kd.microlearn.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kd.microlearn.R
import kd.microlearn.databinding.ActivityPortionBinding
import kd.microlearn.models.PortionModel
import timber.log.Timber
import timber.log.Timber.i

class PortionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPortionBinding
    var portion = PortionModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portion)
        Timber.plant(Timber.DebugTree())
        i("Portion Activity started..")

        binding = ActivityPortionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}