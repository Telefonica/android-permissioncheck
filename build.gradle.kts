import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.kotlin.dsl.embeddedKotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		google()
		mavenCentral()
		mavenLocal()
	}
	dependencies {
		classpath("com.android.tools.build:gradle:7.0.0")
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
		kotlinOptions {
			jvmTarget = "17"
			freeCompilerArgs = listOf("-Xopt-in=kotlin.ExperimentalStdlibApi")
		}
	}

	tasks.withType<JavaCompile> {
		sourceCompatibility = JavaVersion.VERSION_17.toString()
		targetCompatibility = JavaVersion.VERSION_17.toString()
	}

	tasks.withType<Test>().configureEach {
		useJUnitPlatform()

		testLogging {
			events("passed", "skipped", "failed")
			exceptionFormat = TestExceptionFormat.FULL
		}
	}

	tasks.register<Jar>("sourcesJar") {
		dependsOn(":plugin-configurator-v1:jar", ":plugin-configurator-v2:jar", ":plugin-core:jar")
	}
}

