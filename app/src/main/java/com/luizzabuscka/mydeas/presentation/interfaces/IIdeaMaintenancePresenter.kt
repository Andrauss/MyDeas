package com.luizzabuscka.mydeas.presentation.interfaces

import com.luizzabuscka.mydeas.model.Idea

/**
 * Created by luizzabuscka on 14/09/17.
 */
interface IIdeaMaintenancePresenter {
  fun saveIdea(title: String, description: String, isAdding: Boolean, oldIdea: Idea? = null)
  fun saveReturn()
}