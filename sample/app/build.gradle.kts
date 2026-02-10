plugins {
	id("com.android.application")
	id("com.telefonica.manifestcheck")
}

android {
    namespace = "com.telefonica.sampleapp" // Update to your actual package name
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        targetSdk = 36
    }

    lint {
        abortOnError = false
    }
}

dependencies {
	implementation(project(":sample:library"))
}

permissionCheck {
	baselineFile.set(layout.projectDirectory.file("sample-baseline.xml"))
	reportDirectory.set(layout.buildDirectory.dir("reports"))
	strict.set(true)
}
