package com.luizzabuscka.mydeas.presentation

import android.content.Context
import com.luizzabuscka.mydeas.interactors.interfaces.IIdeaMaintenanceInteractor
import com.luizzabuscka.mydeas.interactors.IdeaMaintenanceInteractor
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.presentation.interfaces.IIdeaMaintenancePresenter
import com.luizzabuscka.mydeas.utils.enum.IdeaEnum.EMPTY_DESCRIPTION
import com.luizzabuscka.mydeas.utils.enum.IdeaEnum.EMPTY_TITLE
import com.luizzabuscka.mydeas.view.interfaces.IIdeaMaintenanceActivity

/**
 * Created by luizzabuscka on 14/09/17.
 */
class IdeaMaintenancePresenter(val activity: IIdeaMaintenanceActivity, val context: Context) : IIdeaMaintenancePresenter {

  val interactor: IIdeaMaintenanceInteractor = IdeaMaintenanceInteractor(this, context)

  override fun saveIdea(title: String, description: String, isAdding: Boolean, oldIdea: Idea?) {
    if (title.isNullOrEmpty()) {
      activity.showError(EMPTY_TITLE)
      return
    }

    if (description.isNullOrEmpty()) {
      activity.showError(EMPTY_DESCRIPTION)
      return
    }

      if (isAdding)
          interactor.saveIdea(Idea(title, description))
      else
          interactor.updateIdea(oldIdea!!, Idea(title, description))
  }

  override fun saveReturn() {
    activity.success()
  }
}