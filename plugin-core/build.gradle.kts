plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(gradleKotlinDsl())
    compileOnly("com.android.tools.build:gradle:9.0.0")

    testRuntimeOnly(Dependencies.JUNIT_5_ENGINE)
    testRuntimeOnly(Dependencies.JUNIT_PLATFORM_LAUNCHER)
    testImplementation(Dependencies.JUNIT_5_API)
    testImplementation(gradleKotlinDsl())
}
