package com.example.mc_ca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mc_ca.data.JokeEntity
import com.example.mc_ca.databinding.ListItemBinding

// joke list data is passed in
class JokeListAdapter(private val jokesList: List<JokeEntity>,

// listener for each list item
private val listener: ListItemListener

) :
// Inherits from RecyclerView.Adapter
// it also has an inner class ViewHolder
    RecyclerView.Adapter<JokeListAdapter.ViewHolder>() {

    val selectedJokes = arrayListOf<JokeEntity>()

    //
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        // binding to list_item.xml
        val binding = ListItemBinding.bind(itemView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount() = jokesList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // gets the jokes from the jokes list
        val joke = jokesList[position]
        with(holder.binding) {

            jokeSetup.text = joke.setup
            //on click go to the joke
            root.setOnClickListener{
                listener.onItemClick(joke)
            }

        }


    }

    interface ListItemListener {
        fun onItemClick(joke: JokeEntity)
    }
}