package com.base.common

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val message : String) : Resource<Nothing>()
    data object Loading : Resource<Nothing>()
}

/**
 * Handling in the Repository
 * [Pros]:
 * Keeps use cases focused on business logic, not data transformation.
 * Centralizes error handling and loading state management related to data fetching.
 * [Cons]:
 * Might make repositories less reusable if error handling is specific to a particular use case.
 * Handling in the Use Case
 * [Pros]:
 * Allows for more fine-grained control over error handling and loading state logic for each use case.
 * Can make repositories more generic and reusable.
 * [Cons]:
 * Might lead to some duplication of error handling logic across use cases.
 * Recommendation
 * In general, I'd recommend handling the Resource type in the repository. This keeps your use cases focused on the business logic and centralizes data-related concerns in the repository.
 * */