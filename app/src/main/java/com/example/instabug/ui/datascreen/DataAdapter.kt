package com.example.instabug.ui.datascreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instabug.R
import kotlinx.android.synthetic.main.row_word.view.*

class DataAdapter: RecyclerView.Adapter<DataAdapter.WordViewHolder>() {

    private val wordsMap = HashMap<String, Int>()

    class WordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun processData(word: String, count: Int) {
            itemView.wordTV.text = word
            itemView.countTV.text = "$count"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.row_word, parent, false)
        return WordViewHolder(
            inflater
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.processData(wordsMap.keys.elementAt(position), wordsMap.values.elementAt(position))
    }

    override fun getItemCount(): Int = wordsMap.count()

    fun updateHashMap(map: HashMap<String, Int>) {
        wordsMap.clear()
        wordsMap.putAll(map)
        this.notifyDataSetChanged()
    }
}