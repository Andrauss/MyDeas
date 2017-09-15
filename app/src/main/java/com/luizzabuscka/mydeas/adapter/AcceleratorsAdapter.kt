package com.luizzabuscka.mydeas.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luizzabuscka.mydeas.R
import com.luizzabuscka.mydeas.adapter.AcceleratorsAdapter.ViewHolder
import com.luizzabuscka.mydeas.model.Accelerator
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.utils.enum.AcceleratorsEnum
import com.luizzabuscka.mydeas.utils.enum.AcceleratorsEnum.CALL
import com.luizzabuscka.mydeas.utils.enum.AcceleratorsEnum.OPEN_SITE
import com.luizzabuscka.mydeas.utils.enum.AcceleratorsEnum.SEE_MAP
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum.DELETE
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum.EDIT
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum.SHARE
import kotlinx.android.synthetic.main.item_accelerator.view.ivCall
import kotlinx.android.synthetic.main.item_accelerator.view.ivMap
import kotlinx.android.synthetic.main.item_accelerator.view.ivSite
import kotlinx.android.synthetic.main.item_accelerator.view.tvName
import kotlinx.android.synthetic.main.item_idea.view.ivDelete
import kotlinx.android.synthetic.main.item_idea.view.ivEdit
import kotlinx.android.synthetic.main.item_idea.view.ivShare
import kotlinx.android.synthetic.main.item_idea.view.tvDescription
import kotlinx.android.synthetic.main.item_idea.view.tvTitle

/**
 * Created by luizzabuscka on 15/09/17.
 */
class AcceleratorsAdapter(val accelerators: List<Accelerator>, val listener: (AcceleratorsEnum, Accelerator) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.item_accelerator, null))

  override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(accelerators[position], listener)

  override fun getItemCount() = accelerators.size

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(accelerator: Accelerator, listener: (AcceleratorsEnum, Accelerator) -> Unit) = with(itemView) {
      tvName.text = accelerator.name

      ivMap.setOnClickListener { listener(SEE_MAP, accelerator) }
      ivSite.setOnClickListener { listener(OPEN_SITE, accelerator) }
      ivCall.setOnClickListener { listener(CALL, accelerator) }
    }
  }


}