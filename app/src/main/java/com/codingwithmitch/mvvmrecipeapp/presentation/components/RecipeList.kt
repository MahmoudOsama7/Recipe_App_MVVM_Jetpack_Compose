package com.codingwithmitch.mvvmrecipeapp.presentation.components

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.codingwithmitch.mvvmrecipeapp.R
import com.codingwithmitch.mvvmrecipeapp.domain.model.Recipe

@Composable
fun RecipeList(
    loading:Boolean,
    recipes:List<Recipe>,
    onChangeRecipeScrollPosition:(Int)->Unit,
    nextPage:()->Unit,
    navController: NavController
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn{
            itemsIndexed(
                items = recipes
            ){ index,recipe->
                onChangeRecipeScrollPosition(index)
                nextPage()
                RecipeCard(
                    recipe = recipe,
                    onClick = {
                        if(recipe.id!=null){
                            val bundle=Bundle()
                            bundle.putInt("recipeId",recipe.id)
                            navController.navigate(R.id.viewRecipe,bundle)
                        }else{

                        }
                    }
                )
            }
        }
        CircularIndeterminateProgressBar(
            isDisplayed =loading
        )
    }
}