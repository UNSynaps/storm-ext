rootProject.name = "CloudstreamPlugins"

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

rootProject.name = "storm-ext"

// Esta es la parte mágica que modifiqué para ti:
File(rootDir, "src").listFiles()?.forEach { file ->
    if (file.isDirectory && file.name == "AnimeflvProvider") {
        include(":${file.name}")
        project(":${file.name}").projectDir = file
    }
}

// This file sets what projects are included. All new projects should get automatically included unless specified in "disabled" variable.

//val disabled = listOf<String>()

//File(rootDir, ".").eachDir { dir ->
    //if (!disabled.contains(dir.name) && File(dir, "build.gradle.kts").exists()) {
        //include(dir.name)
    //}
//}

//fun File.eachDir(block: (File) -> Unit) {
    //listFiles()?.filter { it.isDirectory }?.forEach { block(it) }
//}


// To only include a single project, comment out the previous lines (except the first one), and include your plugin like so:
// include("PluginName")
