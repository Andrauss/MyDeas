package com.luizzabuscka.mydeas.interactors.interfaces

import com.luizzabuscka.mydeas.model.Idea

/**
 * Created by luizzabuscka on 14/09/17.
 */
interface IIdeaMaintenanceInteractor {
  fun saveIdea(idea: Idea)
    fun updateIdea(oldIdea: Idea, idea: Idea)
}