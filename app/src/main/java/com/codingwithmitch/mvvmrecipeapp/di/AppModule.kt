package com.codingwithmitch.mvvmrecipeapp.di


import android.content.Context
import com.codingwithmitch.mvvmrecipeapp.presentation.BaseApplication
import com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list.RecipeListUseCase
import com.codingwithmitch.mvvmrecipeapp.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app:Context): BaseApplication {
        return app as BaseApplication
    }




}