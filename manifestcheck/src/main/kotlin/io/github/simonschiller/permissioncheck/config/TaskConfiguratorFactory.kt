package io.github.simonschiller.permissioncheck.config

/** Factory that produces different [TaskConfigurator]s to maintain backwards compatibility to older AGP versions. */
internal object TaskConfiguratorFactory {
    fun getTaskConfigurator(): TaskConfigurator {
        // For AGP 7.0.0+ (including 9.0.0), always use V1
        return TaskConfiguratorV1()
    }
}
