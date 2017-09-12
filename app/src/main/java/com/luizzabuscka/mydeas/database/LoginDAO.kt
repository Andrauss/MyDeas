package com.luizzabuscka.mydeas.database

import android.content.ContentValues
import android.content.Context
import com.luizzabuscka.mydeas.model.Login
import com.luizzabuscka.mydeas.utils.database
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select

/**
 * Created by luizzabuscka on 17/08/17.
 */
class LoginDAO {

  val TABLE = "logins"

  fun select(context: Context) : List<Login> {
    var result: List<Login> = ArrayList<Login>()
    context.database.use {
      result = select(TABLE).exec {
        parseList(classParser<Login>())
      }
    }
    return result;
  }

  fun selectLogin(login: Login, context: Context) : List<Login> {
    var result: List<Login> = ArrayList<Login>()
    context.database.use {
      result = select(TABLE)
          .whereArgs("",
              "usuario" to login.usuario,
              "senha" to login.senha)
          .exec {
        parseList(classParser<Login>())
      }
    }
    return result;
  }

  fun insert(context: Context, login: Login) {
    context.database.use {
      val values = ContentValues()
      values.put("usuario", login.usuario)
      values.put("senha", login.senha)
      insert(TABLE, null, values)
    }
  }

}