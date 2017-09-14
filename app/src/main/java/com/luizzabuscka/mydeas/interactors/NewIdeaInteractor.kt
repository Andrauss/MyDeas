package com.luizzabuscka.mydeas.interactors

import android.content.Context
import com.luizzabuscka.mydeas.database.IdeaDAO
import com.luizzabuscka.mydeas.interactors.interfaces.INewIdeaInteractor
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.presentation.interfaces.INewIdeaPresenter

/**
 * Created by luizzabuscka on 14/09/17.
 */
class NewIdeaInteractor(val presenter: INewIdeaPresenter, val context: Context) : INewIdeaInteractor {

  override fun saveIdea(idea: Idea) {
    IdeaDAO().insert(context, idea)
    presenter.saveReturn()
  }

}