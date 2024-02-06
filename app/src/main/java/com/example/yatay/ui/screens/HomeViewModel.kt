package com.example.yatay.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yatay.model.HomeCategory
import com.example.yatay.model.HomeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class HomeViewModel (): ViewModel(){
    // Holds our currently selected home category
    private val selectedCategory = MutableStateFlow(HomeCategory.Naranjos)
    // Holds the currently available home categories
    private val categories = MutableStateFlow(HomeCategory.values().asList())

    // Holds our view state which the UI collects via [state]
    private val _state = MutableStateFlow(HomeViewState())

    private val refreshing = MutableStateFlow(false)

    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
            // Combines the latest value from each of the flows, allowing us to generate a
            // view state instance which only contains the latest values.
            combine(
                categories,
                selectedCategory,
                refreshing
            ) { categories, selectedCategory, refreshing ->
                HomeViewState(
                    homeCategories = categories,
                    selectedHomeCategory = selectedCategory,
                    refreshing = refreshing,
                    errorMessage = null
                )
            }.catch { throwable ->
                // TODO: emit a UI error here. For now we'll just rethrow
                throw throwable
            }.collect {
                _state.value = it
            }
        }

        refresh(force = false)
    }

    private fun refresh(force: Boolean) {
        viewModelScope.launch {
            runCatching {
                refreshing.value = true
            }
            // TODO: look at result of runCatching and show any errors

            refreshing.value = false
        }
    }

    fun onHomeCategorySelected(category: HomeCategory) {
        selectedCategory.value = category
    }


}