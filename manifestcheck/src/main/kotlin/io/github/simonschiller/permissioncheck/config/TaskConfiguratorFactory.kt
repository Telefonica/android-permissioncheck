package io.github.simonschiller.permissioncheck.config

/**
 * Factory that produces a [TaskConfigurator].
 *
 * It returns [TaskConfiguratorV1], as only V1 is supported for AGP 7.0.0+ (including 9.0.0).
 */
internal object TaskConfiguratorFactory {
    fun getTaskConfigurator(): TaskConfigurator {
        // Always use V1 for AGP 7.0.0+ (including 9.0.0)
        return TaskConfiguratorV1()
    }
}
