package com.luizzabuscka.mydeas.interactors.interfaces

import com.luizzabuscka.mydeas.model.Idea

/**
 * Created by luizzabuscka on 14/09/17.
 */
interface IIdeasInteractor {
  fun getIdeas()
  fun deleteIdea(idea:Idea)
}