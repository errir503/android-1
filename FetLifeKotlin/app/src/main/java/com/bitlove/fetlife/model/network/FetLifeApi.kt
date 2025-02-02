package com.bitlove.fetlife.model.network

import com.bitlove.fetlife.model.dataobject.base.Comment
import com.bitlove.fetlife.model.dataobject.base.Conversation
import com.bitlove.fetlife.model.dataobject.base.Message
import com.bitlove.fetlife.model.dataobject.temp.ExploreStory
import com.bitlove.fetlife.model.network.networkobject.AuthBody
import com.bitlove.fetlife.model.network.networkobject.Token
import retrofit2.Call
import retrofit2.http.*

interface FetLifeApi {
    @POST("/api/oauth/token")
    fun login(@Query("client_id") clientId: String, @Query("client_secret") clientSecret: String, @Query("redirect_uri") redirectUrl: String, @Body authBody: AuthBody): Call<Token>

    @FormUrlEncoded
    @POST("/api/oauth/token")
    fun refreshToken(@Query("client_id") clientId: String, @Field("client_secret") clientSecret: String, @Field("redirect_uri") redirectUrl: String, @Field("grant_type") grantType: String, @Field("refresh_token") refreshToken: String): Call<Token>

//    @GET("/api/v2/me")
//    fun getMe(@Header("Authorization") authHeader: String): Call<Member>

    @GET("/api/v2/me/conversations")
    fun getConversations(@Header("Authorization") authHeader: String, @Query("order_by") orderBy: String?, @Query("limit") limit: Int?, @Query("page") page: Int?): Call<Array<Conversation>>

    @GET("/api/v2/me/conversations/{conversationId}")
    fun getConversation(@Header("Authorization") authHeader: String, @Path("conversationId") conversationId: String): Call<Conversation>

    @GET("/api/v2/me/conversations/{conversationId}/messages")
    fun getMessages(@Header("Authorization") authHeader: String, @Path("conversationId") conversationId: String, @Query("since_id") sinceMessageId: String, @Query("until_id") untilMessageId: String, @Query("limit") limit: Int): Call<Array<Comment>>

    @GET("/api/v2/explore/stuff-you-love")
    abstract fun getStuffYouLove(@Header("Authorization") authHeader: String, @Query("marker") timeStamp: String, @Query("limit") limit: Int?, @Query("page") page: Int?): Call<Array<ExploreStory>>

}