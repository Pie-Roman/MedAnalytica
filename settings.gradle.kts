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

// Base modules
include(":base:uikit")

// Common modules
include(":common:navigation")
include(":common:navigation:api")

// Feature modules
include(":feature:analysis-graph-feature")
include(":feature:post-analysis-feature")
include(":feature:login-feature")
include(":feature:register-feature")
include(":feature:start-feature")

// Domain modules
include(":domain:analysis-graph-domain")
include(":domain:uid-domain")
include(":domain:token-domain")
include(":domain:post-analysis-domain")
include(":domain:login-domain")
include(":domain:register-domain")
include(":domain:start-domain")

// Data modules
include(":data:analysis-graph-data")
include(":data:uid-data")
include(":data:token-data")
include(":data:post-analysis-data")
include(":data:login-data")
include(":data:register-data")
include(":data:start-data")
 