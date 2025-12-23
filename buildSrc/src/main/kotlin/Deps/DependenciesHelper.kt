package Deps

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dep: String) {
    add("implementation", dep)
}

fun DependencyHandler.kapt(dep: String) {
    add("kapt", dep)
}

fun DependencyHandler.testImplementation(dep: String) {
    add("testImplementation", dep)
}

fun DependencyHandler.androidTestImplementation(dep: String) {
    add("androidTestImplementation", dep)
}

fun DependencyHandler.debugImplementation(dep: String) {
    add("debugImplementation", dep)
}

fun DependencyHandler.api(dep: String) {
    add("api", dep)
}