plugins {
    kotlin("jvm")
}

dependencies {
    compileOnly(gradleKotlinDsl())
    compileOnly("com.android.tools.build:gradle:8.1.4")

    api(project(":plugin-core"))
}
