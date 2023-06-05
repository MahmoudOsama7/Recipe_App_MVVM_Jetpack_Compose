package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

import android.util.Log
import android.util.LogPrinter
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.codingwithmitch.mvvmrecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val randomString: String,
    private val repository: RecipeRepository,
    @Named("auth_token") private val token:String
):ViewModel() {

    init {
        Log.d("3ash", "1: "+randomString)
        Log.d("3ash", "2: "+repository)
        Log.d("3ash", "3: "+token)
    }
}