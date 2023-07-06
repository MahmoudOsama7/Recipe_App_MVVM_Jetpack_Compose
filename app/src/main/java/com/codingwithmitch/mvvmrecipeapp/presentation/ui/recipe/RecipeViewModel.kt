package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list.RecipeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeListUseCase: RecipeListUseCase,
): ViewModel() {

    val recipe:MutableState<Recipe?> = mutableStateOf(null)
    val loading = mutableStateOf(false)


    fun getRecipe(id:Int){
        loading.value=true
        viewModelScope.launch {
            delay(1000)
            recipe.value=recipeListUseCase.get(id = id)
            loading.value=false
        }
    }
}