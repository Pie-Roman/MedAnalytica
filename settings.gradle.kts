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

rootProject.name = "MedAnalytica"
include(":app")

include(":base:uikit")

// Feature modules
include(":feature:analysis-graph-feature")

// Domain modules
include(":domain:analysis-graph-domain")

// Data modules
include(":data:analysis-graph-data")
 