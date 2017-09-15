package com.luizzabuscka.mydeas.interactors

import android.content.Context
import com.luizzabuscka.mydeas.database.IdeaDAO
import com.luizzabuscka.mydeas.interactors.interfaces.IIdeaMaintenanceInteractor
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.presentation.interfaces.IIdeaMaintenancePresenter

/**
 * Created by luizzabuscka on 14/09/17.
 */
class IdeaMaintenanceInteractor(val presenter: IIdeaMaintenancePresenter, val context: Context) : IIdeaMaintenanceInteractor {

    override fun updateIdea(oldIdea: Idea, idea: Idea) {
        IdeaDAO().update(context, oldIdea, idea)
        presenter.saveReturn()
    }

    override fun saveIdea(idea: Idea) {
    IdeaDAO().insert(context, idea)
    presenter.saveReturn()
  }

}