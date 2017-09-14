package com.luizzabuscka.mydeas.presentation

import android.content.Context
import com.luizzabuscka.mydeas.interactors.interfaces.INewIdeaInteractor
import com.luizzabuscka.mydeas.interactors.NewIdeaInteractor
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.presentation.interfaces.INewIdeaPresenter
import com.luizzabuscka.mydeas.utils.enum.IdeaEnum.EMPTY_DESCRIPTION
import com.luizzabuscka.mydeas.utils.enum.IdeaEnum.EMPTY_TITLE
import com.luizzabuscka.mydeas.view.interfaces.INewIdeaActivity

/**
 * Created by luizzabuscka on 14/09/17.
 */
class NewIdeaPresenter(val activity: INewIdeaActivity, val context: Context) : INewIdeaPresenter {

  val interactor: INewIdeaInteractor = NewIdeaInteractor(this, context)

  override fun saveIdea(title: String, description: String) {
    if (title.isNullOrEmpty()) {
      activity.showError(EMPTY_TITLE)
      return
    }

    if (description.isNullOrEmpty()) {
      activity.showError(EMPTY_DESCRIPTION)
      return
    }

    interactor.saveIdea(Idea(title, description))
  }

  override fun saveReturn() {
    activity.success()
  }
}