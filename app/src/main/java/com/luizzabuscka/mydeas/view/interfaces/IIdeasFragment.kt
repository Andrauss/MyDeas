package com.luizzabuscka.mydeas.view.interfaces

import com.luizzabuscka.mydeas.model.Idea

/**
 * Created by luizzabuscka on 14/09/17.
 */
interface IIdeasFragment {
  fun updateList(ideas: List<Idea>)
  fun returnDelete()
}