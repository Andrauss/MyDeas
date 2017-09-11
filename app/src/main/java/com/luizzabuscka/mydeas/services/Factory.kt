package com.luizzabuscka.mydeas.services

import com.luizzabuscka.mydeas.utils.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by luizzabuscka on 02/08/17.
 */
object Factory {

  fun create(): IWebServices {
    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    return retrofit.create(IWebServices::class.java)
  }

}