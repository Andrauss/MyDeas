package com.luizzabuscka.mydeas.database

import android.content.ContentValues
import android.content.Context
import com.luizzabuscka.mydeas.model.Idea
import com.luizzabuscka.mydeas.model.Login
import com.luizzabuscka.mydeas.utils.database
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select

/**
 * Created by luizzabuscka on 14/09/17.
 */
class IdeaDAO {

  val TABLE = "ideas"

  fun select(context: Context) : List<Idea> {
    var result: List<Idea> = ArrayList<Idea>()
    context.database.use {
      result = select(TABLE).exec {
        parseList(classParser<Idea>())
      }
    }
    return result;
  }

  fun insert(context: Context, idea: Idea) {
    context.database.use {
      val values = ContentValues()
      values.put("title", idea.title)
      values.put("description", idea.description)
      insert(TABLE, null, values)
    }
  }

  fun update(context: Context, oldIdea: Idea, idea: Idea) {
    context.database.use {
      val values = ContentValues()
      values.put("title", idea.title)
      values.put("description", idea.description)
      update(TABLE, values, " title LIKE '${oldIdea.title}' ", null)
    }
  }

  fun delete(context: Context, idea: Idea) {
    context.database.use {
      val values = ContentValues()
      delete(TABLE," title LIKE '${idea.title}' AND description LIKE '${idea.description}' ", null)
    }
  }

}