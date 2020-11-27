plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.20"
    id("org.jetbrains.kotlin.kapt") version "1.4.20"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.20"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.2.0"
    id ("application")
}

group = "me.user"
version = "1.0-SNAPSHOT"

val kotlinVersion=project.properties.get("kotlinVersion")
val micronautVersion=project.properties.get("micronautVersion")

repositories {
    mavenCentral()
    jcenter()
}

configurations {
    // for dependencies that are needed for development only
    developmentOnly
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("dev.davinogueira.*")
    }
}


dependencies {
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation( "org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation( "io.micronaut:micronaut-runtime")
    implementation( "io.micronaut:micronaut-http-server-netty")
    implementation( "io.micronaut:micronaut-http-client")
    kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt("io.micronaut:micronaut-inject-java")
    kapt( "io.micronaut:micronaut-validation")
    kapt( "io.micronaut.configuration:micronaut-openapi")
    kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kaptTest("io.micronaut:micronaut-inject-java")
    runtimeOnly( "com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly( "ch.qos.logback:logback-classic")
    testImplementation(kotlin("test-junit5"))
    testImplementation( "org.junit.jupiter:junit-jupiter-api")
    testImplementation( "io.micronaut.test:micronaut-test-junit5")
    testRuntimeOnly( "org.junit.jupiter:junit-jupiter-engine")
}

application {
    mainClass.set("dev.davinogueira.password.Main")
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}


tasks.test {
    useJUnitPlatform()
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
            javaParameters = true
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
            javaParameters = true
        }
    }
}

allOpen {
    annotation("io.micronaut.aop.Around")
}

//shadowJar {
//    mergeServiceFiles()
//}
