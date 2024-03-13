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
include(":feature:post-analysis-feature")

// Domain modules
include(":domain:analysis-graph-domain")
include(":domain:uid-domain")
include(":domain:post-analysis-domain")

// Data modules
include(":data:analysis-graph-data")
include(":data:uid-data")
include(":data:post-analysis-data")
 