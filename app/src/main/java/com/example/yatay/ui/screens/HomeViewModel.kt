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
import java.text.NumberFormat


class HomeViewModel(

) : ViewModel() {
    // Holds our currently selected home category
    private val selectedCategory = MutableStateFlow(HomeCategory.Bananos)

    // Holds the currently available home categories
    private val categories = MutableStateFlow(HomeCategory.values().asList())

    // Holds our view state which the UI collects via [state]
    private val _state = MutableStateFlow(HomeViewState())

  //  private val refreshing = MutableStateFlow(false)

    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
            // Combines the latest value from each of the flows, allowing us to generate a
            // view state instance which only contains the latest values.
            combine(
                categories,
                selectedCategory,


                ) { categories, selectedCategory ->
                HomeViewState(
                    homeCategories = categories,
                    selectedHomeCategory = selectedCategory,
                    errorMessage = null,
                )
            }.catch { throwable ->
                // TODO: emit a UI error here. For now we'll just rethrow
                throw throwable
            }.collect {
                _state.value = it
            }
        }

    }

    fun Double.formatPrice(): String {
        return NumberFormat.getCurrencyInstance().format(this)
    }
    fun onHomeCategorySelected(category: HomeCategory) {
        selectedCategory.value = category
    }
    }


