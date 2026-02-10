import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.kotlin.dsl.embeddedKotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

buildscript {
	repositories {
		google()
		mavenCentral()
		mavenLocal()
	}
	dependencies {
		classpath("com.android.tools.build:gradle:9.0.0")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$embeddedKotlinVersion")

//		classpath("com.telefonica:manifestcheck:+") // Uncomment to use the sample
	}
}

allprojects {
	repositories {
		google()
		mavenCentral()
	}
}

subprojects {
	repositories {
		google()
		mavenCentral()
	}

	tasks.withType<KotlinCompile>().configureEach {
		compilerOptions {
			jvmTarget.set(JvmTarget.JVM_17)
			freeCompilerArgs.add("-Xopt-in=kotlin.ExperimentalStdlibApi")
		}
	}

	tasks.withType<Test>().configureEach {
		useJUnitPlatform()

		testLogging {
			events("passed", "skipped", "failed")
			exceptionFormat = TestExceptionFormat.FULL
		}
	}
}
