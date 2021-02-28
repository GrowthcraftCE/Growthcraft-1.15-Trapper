buildscript {
    repositories {
        mavenCentral()
        jcenter()
        maven { url = 'https://files.minecraftforge.net/maven' }
        maven { url = "https://oss.sonatype.org/content/repositories/snapshots/" }
    }
    dependencies {
        classpath group: 'net.minecraftforge.gradle', name: 'ForgeGradle', version: '3.+', changing: true
        classpath 'org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.7'
    }
}

plugins {
    id 'org.sonatype.gradle.plugins.scan' version '1.2.0' // Update the version as needed
}

apply plugin: 'net.minecraftforge.gradle'
apply plugin: 'eclipse'
apply plugin: 'maven-publish'
apply plugin: 'org.sonarqube'

sonarqube {
    properties {
        property "sonar.projectName" , "Growthcraft-" + project.minecraft_version_short
        property "sonar.projectKey", "growthcraft:Growthcraft-" + project.minecraft_version_short
    }
}

repositories {
    mavenLocal()
    // JEI, Tinker's Construct, Mantle, Iron Chests, Natura, etc.
    maven { url = "https://dvs1.progwml6.com/files/maven" }
    // The One Probe
    maven { url "http://maven.tterrag.com/" }
    // Patchouli
    maven { url 'https://maven.blamejared.com' }
    maven { url 'https://oss.sonatype.org/content/groups/public/' }
}

version = project.minecraft_version + '-' + project.growthcraft_version
group = 'growthcraft'
archivesBaseName = 'growthcraft-trapper'

sourceCompatibility = targetCompatibility = compileJava.sourceCompatibility = compileJava.targetCompatibility = '1.8'

minecraft {
    // The mappings can be changed at any time, and must be in the following format.
    // snapshot_YYYYMMDD   Snapshot are built nightly.
    // stable_#            Stables are built at the discretion of the MCP team.
    // Use non-default mappings at your own risk. they may not always work.
    // Simply re-run your setup task after changing the mappings to update your workspace.
    //mappings channel: 'snapshot', version: '20200217-1.15.1'
    mappings channel: 'snapshot', version: '20200706-1.15.1'

    //mappings channel: 'stable', version: '60'

    runs {
        client {
            workingDirectory project.file('run')
            property 'forge.logging.markers', 'SCAN,REGISTRIES,REGISTRYDUMP'
            property 'forge.logging.console.level', 'debug'
            mods {
                examplemod {
                    source sourceSets.main
                }
            }
        }

        server {
            workingDirectory project.file('run')
            property 'forge.logging.markers', 'SCAN,REGISTRIES,REGISTRYDUMP'
            property 'forge.logging.console.level', 'debug'
            mods {
                examplemod {
                    source sourceSets.main
                }
            }
        }

        data {
            workingDirectory project.file('run')
            property 'forge.logging.markers', 'SCAN,REGISTRIES,REGISTRYDUMP'
            property 'forge.logging.console.level', 'debug'
            args '--mod', 'growthcraft', '--all', '--output', file('src/generated/resources/')
            mods {
                examplemod {
                    source sourceSets.main
                }
            }
        }
    }
}

dependencies {
    minecraft 'net.minecraftforge:forge:' + project.forge_version

    /** Compile time Dependencies
     * Include mods that we have a direct dependency with.
     */
    compile fg.deobf("vazkii.patchouli:Patchouli:${minecraft_version}-${patchouli_version}:api")

    /** Runtime Dependencies
     *  Include mods the we need while testing during runtime. When adding mods
     *  to this list, place the version into the gradle.properties file.
     */
    runtime fg.deobf("mezz.jei:jei-${minecraft_version}:${jei_version}")
    runtime fg.deobf("mcjty.theoneprobe:TheOneProbe-${minecraft_version_short}:${minecraft_version_short}-${theoneprobe_version}")
    runtime fg.deobf("vazkii.patchouli:Patchouli:${minecraft_version}-${patchouli_version}")

}

task sourcesJar(type: Jar) {
    from sourceSets.main.allJava
    classifier = 'src'
}

task deobjJar(type: Jar) {
    from sourceSets.main.output
    classifier 'deobf'
}

artifacts {
    archives sourcesJar, deobjJar
}

jar {
    manifest {
        attributes([
            "Specification-Title": "growthcraft",
            "Specification-Vendor": "growthcraft",
            "Specification-Version": "5",
            "Implementation-Title": project.name,
            "Implementation-Version": "${version}",
            "Implementation-Vendor" :"growthcraft",
            "Implementation-Timestamp": new Date().format("yyyy-MM-dd'T'HH:mm:ssZ")
        ])
    }
}

publishing {
    publications {
        mavenJava(MavenPublication) {
            artifact jar
            artifact sourcesJar
        }
    }
    repositories {
        maven {
            url "file:///${project.projectDir}/mcmodsrepo"
        }
    }
}

ossIndexAudit {
    allConfigurations = true
    useCache = false
    cacheDirectory = '.nexus/audit'
    cacheExpiration = 'PT12H'
}