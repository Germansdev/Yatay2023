

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript{

    val version by extra("1.8.2")



    repositories {
        google()

       maven {setUrl("https://jitpack.io") }
        mavenCentral()
    }

    dependencies {
       classpath ( "com.google.gms:google-services:4.3.15")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
        //classpath ( version = "1.4.0")
    }
}

plugins {
    id("com.android.application") version "8.1.3" apply false
    id ("com.android.library") version "7.4.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
}





