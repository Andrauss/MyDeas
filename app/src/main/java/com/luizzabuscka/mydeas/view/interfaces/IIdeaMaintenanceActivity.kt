package com.luizzabuscka.mydeas.view.interfaces

import com.luizzabuscka.mydeas.utils.enum.IdeaEnum

/**
 * Created by luizzabuscka on 14/09/17.
 */
interface IIdeaMaintenanceActivity {
  fun showError(type: IdeaEnum)
  fun success()
}