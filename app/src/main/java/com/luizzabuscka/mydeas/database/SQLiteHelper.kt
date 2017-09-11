package com.luizzabuscka.mydeas.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by luizzabuscka on 8/2/17.
 */
class SQLiteHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, Constants.DB_NAME) {

    companion object {
        private var instance: SQLiteHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): SQLiteHelper {
            if (instance == null) {
                instance = SQLiteHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable("logins", true,
                "usuario" to TEXT,
                "senha" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

}

val Context.database: SQLiteHelper
    get() = SQLiteHelper.getInstance(applicationContext)

