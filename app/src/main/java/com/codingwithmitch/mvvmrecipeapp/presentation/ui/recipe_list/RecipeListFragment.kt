package com.codingwithmitch.mvvmrecipeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.codingwithmitch.mvvmrecipeapp.presentation.components.RecipeCard
import com.codingwithmitch.mvvmrecipeapp.presentation.components.SearchAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment:Fragment() {
    private val viewModel:RecipeListViewModel by viewModels()
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes=viewModel.recipes.value
                val query=viewModel.query.value
                val selectedCategory=viewModel.selectedCategory.value
                val keyboardController = LocalSoftwareKeyboardController.current
                Column {
                    SearchAppBar(
                        query = query,
                        onQueryChanged =viewModel::onQueryChanged ,
                        onExecuteSearch =  viewModel::newSearch ,
                        keyboardController = keyboardController,
                        selectedCategory = selectedCategory,
                        scrollPosition =viewModel.categoryScrollPositionInt ,
                        onSelectedCategoryChanged =viewModel::onSelectedCategoryChanged ,
                        onChangeCategoryScrollPosition =viewModel::onChangeCategoryScrollPosition
                    )
                    LazyColumn{
                        itemsIndexed(
                            items = recipes
                        ){ index,recipe->
                            RecipeCard(
                                recipe = recipe,
                                onClick = {}
                            )
                        }
                    }
                }
            }
        }
    }
}