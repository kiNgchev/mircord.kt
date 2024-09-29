plugins {
    org.jetbrains.kotlin.jvm
    org.jetbrains.kotlin.plugin.serialization
    `maven-publish`
}

repositories {
    mavenCentral()
}

kotlin {
    explicitApi()

    jvmToolchain(Jvm.target)

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    publishing {
        publications.register<MavenPublication>(Library.name) {
            from(components["java"])
            artifact(tasks.kotlinSourcesJar)
        }
    }
}