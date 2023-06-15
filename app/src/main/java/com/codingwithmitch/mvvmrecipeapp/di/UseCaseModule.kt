package com.codingwithmitch.mvvmrecipeapp.di

import com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list.RecipeListUseCase
import com.codingwithmitch.mvvmrecipeapp.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule{
    //no need to mark it as singleton as it does not matter to have any instance
    //we use this at some classes as retrofit to use the same exact instance we already been using
    @Provides
    fun provideRecipeListUseCase(
        recipeRepository: RecipeRepository,
        @Named("auth_token") token:String
    ): RecipeListUseCase {
        return RecipeListUseCase(
            recipeRepository,
            token
        )
    }
}