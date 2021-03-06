package com.luizzabuscka.mydeas.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.luizzabuscka.mydeas.R
import com.luizzabuscka.mydeas.R.string
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.presentation.interfaces.IIdeaMaintenancePresenter
import com.luizzabuscka.mydeas.presentation.IdeaMaintenancePresenter
import com.luizzabuscka.mydeas.utils.enum.IdeaEnum
import com.luizzabuscka.mydeas.utils.enum.IdeaEnum.EMPTY_DESCRIPTION
import com.luizzabuscka.mydeas.utils.enum.IdeaEnum.EMPTY_TITLE
import com.luizzabuscka.mydeas.view.interfaces.IIdeaMaintenanceActivity
import kotlinx.android.synthetic.main.activity_new_idea.btSave
import kotlinx.android.synthetic.main.activity_new_idea.etDescription
import kotlinx.android.synthetic.main.activity_new_idea.etTitle
import kotlinx.android.synthetic.main.activity_new_idea.input_layout_description
import kotlinx.android.synthetic.main.activity_new_idea.input_layout_title
import org.jetbrains.anko.toast

class IdeaMaintenanceActivity : AppCompatActivity(), IIdeaMaintenanceActivity {

  val presenter: IIdeaMaintenancePresenter = IdeaMaintenancePresenter(this, this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_new_idea)
    configUi()
  }

    fun configUi() {

        var title = ""
        var description = ""

        try {
            title = intent.extras.getString("title")
            description = intent.extras.getString("description")
        } catch (e: Exception) {}

        var oldIdea: Idea? =  null

        if (!title.isNullOrEmpty()) {
            etTitle.setText(title)
            etDescription.setText(description)
            oldIdea = Idea(title, description)
            supportActionBar?.title = getString(string.edit_idea)
        }

        btSave.setOnClickListener {
                presenter.saveIdea(etTitle.text.toString(), etDescription.text.toString(), title.isNullOrEmpty(), oldIdea)
        }
    }

  override fun showError(type: IdeaEnum) {
    when (type) {
      EMPTY_TITLE -> input_layout_title.error = getString(string.error_title)
      EMPTY_DESCRIPTION -> input_layout_description.error = getString(string.error_description)
    }
  }

  override fun success() {
    toast(getString(string.toast_success_save))
    finish()
  }

}
