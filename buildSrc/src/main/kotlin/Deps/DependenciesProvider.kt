package Deps

import Test.TestDependencies
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.androidx() {
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.ANDROID_CONSTRUCTIONAL)
    implementation(Dependencies.ANDROID_ACTIVITY)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.ANDROID_CORE)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
}

fun DependencyHandler.network() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpLogging)
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.glide() {
    implementation(Dependencies.glide)
}

fun DependencyHandler.testDependencies() {
    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_ESPRESSO_CORE)
}