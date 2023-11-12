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
    versionCatalogs {
        create("libs"){
            //ui
            library("core-ktx","androidx.core:core-ktx:1.12.0")
            library("compose-bom","androidx.compose:compose-bom:2023.08.00")
            library("activity-ktx","androidx.activity:activity-ktx:1.8.0")
            library("activity-compose","androidx.activity:activity-compose:1.8.0")
            library("window","androidx.window:window:1.1.0")

            //room
            library("room-runtime","androidx.room:room-runtime:2.6.0")
            library("room-compiler","androidx.room:room-compiler:2.6.0")
            library("room-ktx","androidx.room:room-ktx:2.6.0")

            //retrofit
            library("retrofit","com.squareup.retrofit2:retrofit:2.9.0")
            library("gson","com.google.code.gson:gson:2.10")
            library("converter-gson","com.squareup.retrofit2:converter-gson:2.9.0")

            //hilt
            library("hilt-android","com.google.dagger:hilt-android:2.48")
            library("hilt-android-compiler","com.google.dagger:hilt-android-compiler:2.44")
            library("hilt-navigation-compose","androidx.hilt:hilt-navigation-compose:1.1.0")

            //okhttp client
            library("okhttp-bom","com.squareup.okhttp3:okhttp-bom:5.0.0-alpha.2")

            //data-store
            library("datastore-preferences","androidx.datastore:datastore-preferences:1.0.0")
            library("datastore-core","androidx.datastore:datastore-core:1.0.0")

            //coil image
            library("coil-compose","io.coil-kt:coil-compose:2.4.0")
            library("constraintlayout-compose","androidx.constraintlayout:constraintlayout-compose:1.0.1")

            library("navigation-compose","androidx.navigation:navigation-compose:2.7.5")
            library("lifecycle-runtime-compose","androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
        }
    }
}
rootProject.name = "Grab Food"
include(":app")
