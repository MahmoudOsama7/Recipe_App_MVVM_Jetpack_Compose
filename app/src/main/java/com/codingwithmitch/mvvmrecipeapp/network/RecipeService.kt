package com.codingwithmitch.mvvmrecipeapp.network

import com.codingwithmitch.mvvmrecipeapp.network.model.RecipeDto
import com.codingwithmitch.mvvmrecipeapp.network.responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeService{

    //get list of recipes
    @GET("search")
    suspend fun search(
        @Header("Authorization") token:String,
        @Query("page") page:Int,
        @Query("query") query:String
    ):RecipeSearchResponse

    //get specific recipe by it's id
    @GET("get")
    suspend fun get(
        @Header("Authorization") token:String,
        @Query("id") id:Int,
    ):RecipeDto

}