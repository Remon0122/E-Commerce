package Test

import Deps.DependenciesVersion

object TestDependencies {
    const val ANDROIDX_JUNIT = "androidx.test.ext:junit:${DependenciesVersion.JUNIT_VERSION}"
    const val ANDROIDX_ESPRESSO_CORE =
        "androidx.test.espresso:espresso-core:${DependenciesVersion.ESPRESSO_CORE}"
    const val JUNIT = "junit:junit:${DependenciesVersion.JUNIT}"
}