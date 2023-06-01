package com.codingwithmitch.mvvmrecipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.network.model.RecipeDto
import com.codingwithmitch.mvvmrecipeapp.network.model.RecipeDtoMapper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val mapper=RecipeDtoMapper()

        val recipe= Recipe()
        val recipeDto=RecipeDto()

        val toNetworkEntity=mapper.mapToEntity(recipe)
        val fromNetworkEntity=mapper.mapToDomainModel(recipeDto)
    }
}