package kd.microlearn.main
import android.app.Application
import kd.microlearn.models.ModuleAI


class MainApp : Application() {
    fun main() {
        // Test the ModuleAI class
        val moduleAI = ModuleAI()
        val data = "This is a sample text. It consists of multiple sentences. Each sentence represents some information."
        val portions = moduleAI.generateMaterial(data)
        println("Portions:")
        portions.forEachIndexed { index, portion ->
            println("Portion ${index + 1}: $portion")
        }
    }
}