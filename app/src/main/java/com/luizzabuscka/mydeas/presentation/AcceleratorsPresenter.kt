package com.luizzabuscka.mydeas.presentation

import com.luizzabuscka.mydeas.interactors.AcceleratorsInteractor
import com.luizzabuscka.mydeas.interactors.interfaces.IAcceleratorsInteractor
import com.luizzabuscka.mydeas.model.Accelerator
import com.luizzabuscka.mydeas.presentation.interfaces.IAcceleratorsPresenter
import com.luizzabuscka.mydeas.view.interfaces.IAcceleratorsFragment

/**
 * Created by luizzabuscka on 15/09/17.
 */
class AcceleratorsPresenter(val fragment: IAcceleratorsFragment) : IAcceleratorsPresenter {

  val interactor: IAcceleratorsInteractor = AcceleratorsInteractor(this)

  override fun getAccelerators() {
    interactor.getAccelerators()
  }

  override fun returnAccelerators(accelerators: List<Accelerator>) {
    fragment.showList(accelerators)
  }

}