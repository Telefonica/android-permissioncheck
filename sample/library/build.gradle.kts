plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(30)
    namespace = "io.github.simonschiller.permissioncheck.sample.library"

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
    }

    lintOptions {
        checkOnly("") // Disable all Lint checks
    }
}
