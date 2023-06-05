package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

import android.util.Log
import android.util.LogPrinter
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token:String
):ViewModel() {

    val recipes:MutableState<List<Recipe>> = mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            val result = repository.search(
                token="Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
                page = 1,
                query="chicken"
            )
            recipes.value=result
        }
    }
}