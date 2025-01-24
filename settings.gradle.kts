pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "nowinjetpack"
include(":app")
include(":core")
include(":core:data")
include(":core:network")
include(":core:common")
include(":core:model")
include(":core:domain")
include(":feature:deliveries")
include(":feature:marvel")
