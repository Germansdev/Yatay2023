package com.example.yatay.ui.screens

/**
class BananosViewModel(
  //  private val categoryStore: CategoryStore = CategoryStore()
): ViewModel() {

    // Holds our currently selected category
    private val _selectedCategory = MutableStateFlow<HomeCategory?>(null)

    // Holds our view state which the UI collects via [state]
    private val _state = MutableStateFlow(BananosViewState())

    val state: StateFlow<BananosViewState>
        get() = _state

    init {
        viewModelScope.launch {
            // Combines the latest value from each of the flows, allowing us to generate a
            // view state instance which only contains the latest values.
            //    val categoryStore : CategoryStore =

        }
        fun onCategorySelected(category: HomeCategory) {
            _selectedCategory.value = HomeCategory.Bananos
        }

    }
}
data class BananosViewState(
    val categories: List<HomeCategory> = emptyList(),
    val selectedCategory: HomeCategory? = null
)

data class Category (
    val id: Long = 0,
    val name: String
)
        */