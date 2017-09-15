package com.luizzabuscka.mydeas.presentation.interfaces

import com.luizzabuscka.mydeas.model.Accelerator

/**
 * Created by luizzabuscka on 15/09/17.
 */
interface IAcceleratorsPresenter {
  fun getAccelerators()
  fun returnAccelerators(accelerators: List<Accelerator>)
}