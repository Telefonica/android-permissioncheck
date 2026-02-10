object Versions { // See https://mvnrepository.com
    const val JUNIT_5 = "5.13.4"
    const val JUNIT_PLATFORM_LAUNCHER ="1.7.1"
}

object Dependencies {
    const val JUNIT_5_ENGINE = "org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT_5}"
    const val JUNIT_5_API = "org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT_5}"
    const val JUNIT_5_PARAMS = "org.junit.jupiter:junit-jupiter-params:${Versions.JUNIT_5}"
    const val JUNIT_PLATFORM_LAUNCHER = "org.junit.platform:junit-platform-launcher:${Versions.JUNIT_PLATFORM_LAUNCHER}"
}
