package com.luizzabuscka.mydeas.services

import com.luizzabuscka.mydeas.model.Login
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Created by luizzabuscka on 02/08/17.
 */
interface IWebServices {

  @Headers("Accept: application/json")
  @GET("58b9b1740f0000b614f09d2f")
  fun login(): Observable<Login>

}