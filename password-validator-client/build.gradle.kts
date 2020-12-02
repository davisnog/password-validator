import com.google.protobuf.gradle.*

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.20"
    id("org.jetbrains.kotlin.kapt") version "1.4.20"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.20"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.2.0"
    id("com.google.protobuf") version "0.8.13"
    id("application")
    id("idea")
}

group = "me.user"
version = "1.0-SNAPSHOT"

val kotlinVersion = project.properties.get("kotlinVersion")
val micronautVersion = project.properties.get("micronautVersion")
val kotlinxCoroutinesVersion = project.properties.get("kotlinxCoroutinesVersion")
val micronautGrpcVersion = project.properties.get("micronautGrpcVersion")
val grpcKotlinVersion = project.properties.get("grpcKotlinVersion")


repositories {
    mavenCentral()
    jcenter()
}

micronaut {
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("dev.davinogueira.client.*")
    }
}

dependencies {
    kapt(enforcedPlatform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut:micronaut-validation")
    kapt("io.micronaut.configuration:micronaut-openapi")

    implementation(enforcedPlatform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.grpc:micronaut-grpc-client-runtime:$micronautGrpcVersion")
    implementation("io.grpc:grpc-kotlin-stub:$grpcKotlinVersion")
    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.micronaut:micronaut-http-client")
    runtimeOnly("io.micronaut:micronaut-discovery-client")

    runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")

    kaptTest("io.micronaut:micronaut-inject-java")

    testImplementation(enforcedPlatform("io.micronaut:micronaut-bom:$micronautVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.0")
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testImplementation("org.mockito:mockito-junit-jupiter:2.22.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.0")
    testRuntimeOnly("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
}

application {
    mainClass.set("dev.davinogueira.client.MainKt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

allOpen {
    annotation("io.micronaut.aop.Around")
}

sourceSets {
    main {
        java {
            srcDirs("build/generated/source/proto/main/grpc")
            srcDirs("build/generated/source/proto/main/grpckt")
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
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:0.1.2"
        }
    }
    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.plugins {
                // Apply the "grpc" plugin whose spec is defined above, without options.
                id("grpc")
                id("grpckt")
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
