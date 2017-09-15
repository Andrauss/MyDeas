package com.luizzabuscka.mydeas.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.luizzabuscka.mydeas.R
import com.luizzabuscka.mydeas.R.string
import com.luizzabuscka.mydeas.adapter.AcceleratorsAdapter
import com.luizzabuscka.mydeas.adapter.IdeasAdapter
import com.luizzabuscka.mydeas.model.Accelerator
import com.luizzabuscka.mydeas.presentation.AcceleratorsPresenter
import com.luizzabuscka.mydeas.presentation.interfaces.IAcceleratorsPresenter
import com.luizzabuscka.mydeas.utils.enum.AcceleratorsEnum
import com.luizzabuscka.mydeas.utils.enum.AcceleratorsEnum.CALL
import com.luizzabuscka.mydeas.utils.enum.AcceleratorsEnum.OPEN_SITE
import com.luizzabuscka.mydeas.utils.enum.AcceleratorsEnum.SEE_MAP
import com.luizzabuscka.mydeas.view.interfaces.IAcceleratorsFragment
import kotlinx.android.synthetic.main.fragment_accelerators.rvAccelerators
import org.jetbrains.anko.support.v4.browse
import org.jetbrains.anko.support.v4.makeCall

/**
 * A simple [Fragment] subclass.
 */
class AcceleratorsFragment : Fragment(), IAcceleratorsFragment {

  val presenter: IAcceleratorsPresenter = AcceleratorsPresenter(this)

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater!!.inflate(R.layout.fragment_accelerators, container, false)
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    configUi()
  }

  fun configUi() {
    presenter.getAccelerators()
  }

  override fun showList(accelerators: List<Accelerator>) {
    rvAccelerators.setLayoutManager(GridLayoutManager(context, 1))
    rvAccelerators.adapter = AcceleratorsAdapter(accelerators) { type: AcceleratorsEnum, accelerator: Accelerator ->
      when (type) {
        OPEN_SITE -> {
          browse(accelerator.url)
        }
        SEE_MAP -> {
          //TODO
        }
        CALL -> {
          makeCall(accelerator.phone)
        }
      }
    }
  }

}
