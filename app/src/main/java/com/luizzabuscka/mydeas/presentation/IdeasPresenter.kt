package com.luizzabuscka.mydeas.presentation

import android.content.Context
import com.luizzabuscka.mydeas.interactors.IdeasInteractor
import com.luizzabuscka.mydeas.interactors.interfaces.IIdeasInteractor
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.presentation.interfaces.IIdeasPresenter
import com.luizzabuscka.mydeas.view.interfaces.IIdeasFragment

/**
 * Created by luizzabuscka on 14/09/17.
 */
class IdeasPresenter(val fragment: IIdeasFragment, val context: Context) : IIdeasPresenter {

  val interactor: IIdeasInteractor = IdeasInteractor(this, context)

  override fun getIdeas() {
    interactor.getIdeas()
  }

  override fun returnGetIdeas(ideas: List<Idea>) {
    fragment.updateList(ideas)
  }

  override fun deleteIdea(idea: Idea) {
    interactor.deleteIdea(idea)
  }

  override fun returnDeleteIdea() {
    fragment.returnDelete()
  }
}