package com.test.project.connection.home

sealed class ServiceStatus<F, T> {
    /** */
    class Loading<F, T>: ServiceStatus<F, T>()
    /** */
    data class Failed<F: String?, T>(val failure: F): ServiceStatus<F, T>()
    /** */
    data class Done<F, T>(val value: T): ServiceStatus<F, T>()
}
