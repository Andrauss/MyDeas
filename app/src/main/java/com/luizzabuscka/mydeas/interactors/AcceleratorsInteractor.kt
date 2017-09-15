package com.luizzabuscka.mydeas.interactors

import com.luizzabuscka.mydeas.database.AcceleratorDAO
import com.luizzabuscka.mydeas.interactors.interfaces.IAcceleratorsInteractor
import com.luizzabuscka.mydeas.presentation.interfaces.IAcceleratorsPresenter

/**
 * Created by luizzabuscka on 15/09/17.
 */
class AcceleratorsInteractor(val presenter: IAcceleratorsPresenter) : IAcceleratorsInteractor {

  override fun getAccelerators() {
    presenter.returnAccelerators(AcceleratorDAO().select())
  }

}