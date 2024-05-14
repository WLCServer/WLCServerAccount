plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("kapt") version "1.9.24"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "cc.wlcs"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "exceptionflug"
        url = uri("https://mvn.exceptionflug.de/repository/exceptionflug-public/")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    kapt("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    implementation("space.arim.dazzleconf:dazzleconf-ext-snakeyaml:1.3.0-M2")
    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:8.4.0")
    implementation("org.ktorm:ktorm-core:4.0.0")
    compileOnly("dev.simplix:protocolize-api:2.3.3")
    implementation("cn.hutool:hutool-core:5.8.27")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}