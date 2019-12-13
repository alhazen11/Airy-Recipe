package com.apps.airyrecipe.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.airyrecipe.R
import com.apps.airyrecipe.abstraction.util.ext.load
import com.apps.airyrecipe.abstraction.utils.ext.hide
import com.apps.airyrecipe.data.entity.Recipe
import kotlinx.android.synthetic.main.item_list_recipe.view.*


class MainAdapter(private val repo: List<Recipe>): RecyclerView.Adapter<MainAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder.inflate(parent)
    }

    override fun getItemCount(): Int = repo.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(repo[position])
    }

    class Holder(private val view: View): RecyclerView.ViewHolder(view) {
        private val title = view.uiTitle
        private val desc = view.uiDesc
        private val foto = view.uiImg
        private val creator = view.uiCreator
        private val rating = view.uiRating

        companion object {
            fun inflate(parent: ViewGroup): Holder {
                return Holder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_list_recipe,
                        parent,
                        false)
                )
            }
        }

        fun bind(repo: Recipe) {
            title.text = repo.name
            desc.text = repo.review
            rating.text = repo.rating
            creator.text = "By: ${repo.creator}"
            if(repo.rating.toFloat()<4){
                rating.hide()
            }
            foto.load(repo.image)
        }
    }

}