package com.luizzabuscka.mydeas.interactors

import com.luizzabuscka.mydeas.model.Idea

/**
 * Created by luizzabuscka on 14/09/17.
 */
interface INewIdeaInteractor {
  fun saveIdea(idea: Idea)
}