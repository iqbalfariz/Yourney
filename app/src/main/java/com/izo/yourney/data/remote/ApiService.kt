package com.izo.yourney.data.remote

import com.izo.yourney.data.AnswerResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("predict")
    fun postMessage(
        @Field("question") question: String
    ): Call<AnswerResponse>

}