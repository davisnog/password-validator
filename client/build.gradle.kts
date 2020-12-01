import com.google.protobuf.gradle.*

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.20"
    id("org.jetbrains.kotlin.kapt") version "1.4.20"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.20"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.2.0"
    id("com.google.protobuf") version "0.8.13"
}

group = "me.user"
version = "1.0-SNAPSHOT"

val kotlinVersion=project.properties.get("kotlinVersion")
val micronautVersion=project.properties.get("micronautVersion")

repositories {
    mavenCentral()
    jcenter()
}

micronaut {
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("dev.davinogueira.*")
    }
}


dependencies {
    compileOnly("org.graalvm.nativeimage:svm")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation( "org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation( "io.micronaut:micronaut-runtime")
    implementation( "io.micronaut:micronaut-http-server-netty")
    implementation( "io.micronaut:micronaut-http-client")
    implementation("io.micronaut.grpc:micronaut-grpc-server-runtime")
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
    mainClass.set("dev.davinogueira.client.MainKt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

sourceSets {
    main {
        java {
            srcDirs("build/generated/source/proto/main/grpc")
            srcDirs("build/generated/source/proto/main/java")
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.14.0"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.33.1"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                // Apply the "grpc" plugin whose spec is defined above, without options.
                id("grpc")
            }
        }
    }
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