# Developer of Mircord stopped development. This library has no more actuality

# Mircord.kt

---
Mircord.kt is a coroutine-based implementation of [Mircord API](https://github.com/wst-007/API-Mircord), written 100% in Kotlin
## Platforms support
| Module                   | JVM | JS  | Native |
|--------------------------|-----|-----|--------|
| [common](common)         | ✅   | ❌   | ❌      |

---
## Installation 

---
### Gradle (Kotlin)
Maven central repository
```kotlin
dependencies {
    implementation("net.kingchev:mircord:{version}")
}
```
Or Jitpack repository
```kotlin
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.kiNgchev:mircord.kt:{version}")
}
```
---
### Gradle (Groovy)
Maven central repository
```groovy
dependencies {
    implementation("net.kingchev:mircord:{version}")
}
```
Or Jitpack repository
```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}


dependencies {
    implementation 'com.github.kiNgchev:mircord.kt:{version}'
}
```
---
### Maven
Maven central repository
```xml
<dependency>
    <groupId>net.kingchev</groupId>
    <artifactId>mircord</artifactId>
    <version>{version}</version>
</dependency>
```
Or Jitpack repository
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>com.github.kiNgchev</groupId>
    <artifactId>mircord.kt</artifactId>
    <version>{version}</version>
</dependency>
```
---
## example
```kotlin
suspend fun main() {
    val stats = BotStats()
        .servers(7)
        .shards(1)
    
    mircord("Place your Mircord API token here") {
        updateStatistic(stats)
    }
}
```
---
## This project is supported by JetBrains
[![JetBrains Logo (Main) logo](https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.svg)](https://jb.gg/OpenSourceSupport)