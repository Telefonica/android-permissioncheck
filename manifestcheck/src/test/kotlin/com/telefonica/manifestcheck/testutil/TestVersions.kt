package com.telefonica.manifestcheck.testutil

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

class TestVersions : ArgumentsProvider {

    @Suppress("DEPRECATION")
    override fun provideArguments(context: ExtensionContext): Stream<out Arguments> {
        val arguments = AGP_VERSIONS.flatMap { agpVersion ->
            GRADLE_VERSIONS
                .map { gradleVersion -> Arguments.of(gradleVersion, agpVersion) }
        }
        return arguments.stream()
    }

    companion object {

        // See https://gradle.org/releases
        private val GRADLE_VERSIONS = listOf(
            "9.1.0",
        )

        // See https://developer.android.com/studio/releases/gradle-plugin
        private val AGP_VERSIONS = listOf(
            "9.0.0",
        )

        val LATEST_GRADLE_VERSION = GRADLE_VERSIONS.first()
        val LATEST_AGP_VERSION = AGP_VERSIONS.first()
    }
}
