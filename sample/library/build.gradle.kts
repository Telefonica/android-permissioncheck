plugins {
    id("com.android.library")
}

android {
    namespace = "io.github.simonschiller.permissioncheck.sample.library"
    compileSdkVersion(33)

    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(33)
    }

    lintOptions {
        checkOnly("") // Disable all Lint checks
    }
}
