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

// Feature modules
include(":feature:analysis-graph-feature")

// Domain modules
include(":domain:analysis-graph-domain")

// Data modules
include(":data:analysis-graph-data")
 