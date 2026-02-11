package com.telefonica.manifestcheck

import com.android.build.gradle.AppPlugin
import com.telefonica.manifestcheck.config.TaskConfiguratorV1
import org.gradle.api.Plugin
import org.gradle.api.Project

class PermissionCheckPlugin : Plugin<Project> {
    private lateinit var extension: PermissionCheckExtension

    override fun apply(project: Project) {
        extension = project.extensions.create("permissionCheck", PermissionCheckExtension::class.java)

        // Register tasks once the Android app plugin is available
        project.plugins.configureEach { plugin ->
            if (plugin !is AppPlugin) {
                return@configureEach // Only applicable to app modules
            }

            val taskConfigurator = TaskConfiguratorV1()
            taskConfigurator.configureTasks(project, extension)
        }
    }
}