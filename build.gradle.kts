import io.papermc.paperweight.util.Constants

plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.0.0" apply false
    id("io.papermc.paperweight.patcher") version "1.1.4"
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/") {
        content { onlyForConfigurations(Constants.PAPERCLIP_CONFIG) }
    }
    maven("https://maven.quiltmc.org/repository/release/") {
        content { onlyForConfigurations(Constants.REMAPPER_CONFIG) }
    }
}

dependencies {
    remapper("org.quiltmc:tiny-remapper:0.4.1")
    paperclip("io.papermc:paperclip:2.0.1")
}

subprojects {
    apply(plugin = "java")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(16))
        }
    }

    tasks.withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(16)
    }
    tasks.withType<Javadoc> {
        options.encoding = Charsets.UTF_8.name()
    }

    repositories {
        mavenCentral()
        maven("https://oss.sonatype.org/content/groups/public/")
        maven("https://papermc.io/repo/repository/maven-public/")
        maven("https://ci.emc.gs/nexus/content/groups/aikar/")
        maven("https://repo.aikar.co/content/groups/aikar")
        maven("https://repo.md-5.net/content/repositories/releases/")
        maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    }
}

paperweight {
    serverProject.set(project(":Papyrus-Server"))

    usePaperUpstream(provider { file("current-paper").readText().trim() }) {
        withPaperPatcher {
            apiPatchDir.set(layout.projectDirectory.dir("patches/api"))
            apiOutputDir.set(layout.projectDirectory.dir("Papyrus-API"))

            serverPatchDir.set(layout.projectDirectory.dir("patches/server"))
            serverOutputDir.set(layout.projectDirectory.dir("Papyrus-Server"))
        }
    }
}

tasks.paperclipJar {
    destinationDirectory.set(rootProject.layout.projectDirectory)
    archiveFileName.set("papyrus-paperclip.jar")
}
