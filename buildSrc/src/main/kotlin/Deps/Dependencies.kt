package Deps

object Dependencies {
    const val ANDROID_CORE = "androidx.core:core-ktx:${DependenciesVersion.CORE_KTX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${DependenciesVersion.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${DependenciesVersion.MATERIAL}"
    const val ANDROID_ACTIVITY = "androidx.activity:activity:${DependenciesVersion.ANDROID_ACTIVITY}"
    const val ANDROID_CONSTRUCTIONAL = "androidx.constraintlayout:constraintlayout:${DependenciesVersion.ANDROID_CONSTRUCTIONAL}"
    // Navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${DependenciesVersion.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${DependenciesVersion.navigation}"
    const val navigationTest =  "androidx.navigation:navigation-testing${DependenciesVersion.navigation}"
    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${DependenciesVersion.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${DependenciesVersion.retrofit}"

    // OkHttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${DependenciesVersion.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${DependenciesVersion.okhttp}"

    // Hilt
    const val hilt = "com.google.dagger:hilt-android:${DependenciesVersion.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${DependenciesVersion.hilt}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${DependenciesVersion.room}"
    const val roomKtx = "androidx.room:room-ktx:${DependenciesVersion.room}"
    const val roomCompiler = "androidx.room:room-compiler:${DependenciesVersion.room}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${DependenciesVersion.glide}"
}