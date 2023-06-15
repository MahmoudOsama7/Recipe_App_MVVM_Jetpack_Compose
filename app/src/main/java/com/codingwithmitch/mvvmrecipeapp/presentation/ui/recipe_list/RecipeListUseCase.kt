package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.repository.RecipeRepository

class RecipeListUseCase(
    private val recipeRepository: RecipeRepository,
    private val token:String
    ) {
    suspend fun search(
        page:Int,
        query:String
    ):List<Recipe>{
        return recipeRepository.search(
            token=token,
            page=page,
            query = query
        )
    }
}