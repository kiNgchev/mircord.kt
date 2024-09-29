plugins {
    org.jetbrains.dokka
    `mircord-module`
    `mircord-publishing`
}

dependencies {
    implementation(libs.bundles.ktor.client)
}