package com.luizzabuscka.mydeas.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.luizzabuscka.mydeas.R
import com.luizzabuscka.mydeas.adapter.IdeasAdapter
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum.DELETE
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum.EDIT
import com.luizzabuscka.mydeas.utils.enum.CardOptionsEnum.SHARE
import com.luizzabuscka.mydeas.view.interfaces.IIdeasFragment
import kotlinx.android.synthetic.main.fragment_ideas.rvIdeas
import org.jetbrains.anko.support.v4.toast
import com.luizzabuscka.mydeas.R.string
import com.luizzabuscka.mydeas.presentation.IdeasPresenter
import com.luizzabuscka.mydeas.presentation.interfaces.IIdeasPresenter
import org.jetbrains.anko.noButton
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.yesButton


/**
 * A simple [Fragment] subclass.
 */
class IdeasFragment : Fragment(), IIdeasFragment {

  var presenter : IIdeasPresenter? = null

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    presenter = IdeasPresenter(this, context)
    return inflater!!.inflate(R.layout.fragment_ideas, container, false)
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  override fun onResume() {
    super.onResume()
    presenter?.getIdeas()
  }

  override fun updateList(ideas: List<Idea>) {
    rvIdeas.setLayoutManager(GridLayoutManager(context, 1))
    rvIdeas.adapter = IdeasAdapter(ideas) { type: CardOptionsEnum, idea: Idea ->
      when (type) {
        SHARE -> {
          toast("Share: ${idea.title}")
        }
        EDIT -> {
          toast("Edit: ${idea.title}")
        }
        DELETE -> {
          alert(getString(string.dialog_delete_idea)) {
            yesButton { presenter?.deleteIdea(idea) }
            noButton {}
          }.show()
        }
      }
    }
  }

  override fun returnDelete() {
    toast(getString(string.toast_deleted_idea))
    presenter?.getIdeas()
  }





}
