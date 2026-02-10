plugins {
    id("com.android.library")
}

android {
    namespace = "com.telefonica.samplelibrary" // Update to your actual package name
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }

    lint {
        abortOnError = false
    }
}
