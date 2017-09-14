package com.luizzabuscka.mydeas.presentation.interfaces

import com.luizzabuscka.mydeas.model.Idea

/**
 * Created by luizzabuscka on 14/09/17.
 */
interface IIdeasPresenter {
  fun getIdeas()
  fun returnGetIdeas(ideas: List<Idea>)
  fun deleteIdea(idea: Idea)
  fun returnDeleteIdea()
}