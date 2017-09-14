package com.luizzabuscka.mydeas.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.R
import com.luizzabuscka.mydeas.adapter.IdeasAdapter.ViewHolder
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum.DELETE
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum.EDIT
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum.SHARE
import kotlinx.android.synthetic.main.item_idea.view.ivDelete
import kotlinx.android.synthetic.main.item_idea.view.ivEdit
import kotlinx.android.synthetic.main.item_idea.view.ivShare
import kotlinx.android.synthetic.main.item_idea.view.tvDescription
import kotlinx.android.synthetic.main.item_idea.view.tvTitle


/**
 * Created by luizzabuscka on 14/09/17.
 */
class IdeasAdapter(val ideas: List<Idea>, val listener: (CardOptionsEnum, Idea) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_idea, null))

  override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(ideas[position], listener)

  override fun getItemCount() = ideas.size

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(idea: Idea, listener: (CardOptionsEnum, Idea) -> Unit) = with(itemView) {
      tvTitle.text = idea.title
      tvDescription.text = idea.description

      ivShare.setOnClickListener { listener(SHARE, idea) }
      ivEdit.setOnClickListener { listener(EDIT, idea) }
      ivDelete.setOnClickListener { listener(DELETE, idea) }
    }
  }


}