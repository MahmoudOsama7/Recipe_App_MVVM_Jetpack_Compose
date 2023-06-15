package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe
import com.codingwithmitch.mvvmrecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token:String
):ViewModel() {

    val recipes:MutableState<List<Recipe>> = mutableStateOf(listOf())
    val query= mutableStateOf("Chicken")


    val selectedCategory:MutableState<FoodCategory?> = mutableStateOf(null)
    var categoryScrollPositionInt=0
    val loading = mutableStateOf(false)

    init {
        newSearch()
    }

    fun newSearch(){
        viewModelScope.launch {
            loading.value=true
            resetSearchState()
            delay(1000)
            val result = repository.search(
                token=token,
                page = 1,
                query=query.value
            )
            recipes.value=result
            loading.value=false
        }
    }
    fun onQueryChanged(query:String){
        this.query.value=query
    }

    fun onChangeCategoryScrollPosition(position: Int){
        categoryScrollPositionInt=position
    }

    fun onSelectedCategoryChanged(category: String){
        val newCategory= getFoodCategory(category)
        //if nothing is selected
        if(selectedCategory.value==null)
            selectedCategory.value=newCategory
//        //if the same value is selected
        else if (selectedCategory.value?.value==category)
            selectedCategory.value=null
        //if different value is selected
        else
            selectedCategory.value=newCategory
        onQueryChanged(category)
    }

    private fun clearSelectedCategory(){
        selectedCategory.value=null
    }
    private fun resetSearchState(){
        recipes.value= listOf()
        if (selectedCategory.value?.value!=query.value)
            clearSelectedCategory()
    }

}