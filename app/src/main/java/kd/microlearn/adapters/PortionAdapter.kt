package kd.microlearn.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import kd.microlearn.databinding.CardPortionBinding
import kd.microlearn.models.PortionModel


interface PortionListener {
    fun onPortionClick(portion: PortionModel)
}

class PortionAdapter constructor(private var portions: List<PortionModel>,
                                 private val listener: PortionListener) :
    RecyclerView.Adapter<PortionAdapter.MainHolder>() {
    //lateinit var cbSelect: CheckBox

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
//        cbSelect = parent.findViewById(R.id.checkbox)
        val binding = CardPortionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val portion = portions[holder.adapterPosition]
        holder.bind(portion, listener, this)
    }

    override fun getItemCount(): Int = portions.size

    class MainHolder(private val binding : CardPortionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(portion: PortionModel, listener : PortionListener, parent : PortionAdapter) {

            binding.portionTitle.text = portion.title_portion
            binding.portionText.text = buildString { append(portion.text_portion.take(223))
                                                     append("...") }
            binding.root.setOnClickListener { //parent.cbSelect.isChecked = true
                listener.onPortionClick(portion) }
        }
    }
}