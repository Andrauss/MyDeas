package com.luizzabuscka.mydeas.interactors

import android.content.Context
import com.luizzabuscka.mydeas.database.IdeaDAO
import com.luizzabuscka.mydeas.interactors.interfaces.IIdeasInteractor
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.presentation.interfaces.IIdeasPresenter

/**
 * Created by luizzabuscka on 14/09/17.
 */
class IdeasInteractor(val presenter: IIdeasPresenter, val context: Context) : IIdeasInteractor {

  override fun getIdeas() {
    presenter.returnGetIdeas(IdeaDAO().select(context))
  }

  override fun deleteIdea(idea: Idea) {
    IdeaDAO().delete(context, idea)
    presenter.returnDeleteIdea()
  }
}