package com.telefonica.manifestcheck.testutil

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class AndroidProjectExtensionTest {

    @JvmField
    @RegisterExtension
    val androidProject =
        AndroidProjectExtension()

    @Test
    fun `AndroidProjectExtension creates project that works correctly`() {
        androidProject.runTask(
            "tasks",
            "--all",
            gradleVersion = TestVersions.Companion.LATEST_GRADLE_VERSION,
            agpVersion = TestVersions.Companion.LATEST_AGP_VERSION
        )
    }
}
