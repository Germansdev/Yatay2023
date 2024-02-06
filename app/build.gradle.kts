plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")

    id ("com.google.gms.google-services")
}

android {
    namespace = "com.example.yatay"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.yatay"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17//VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"//"1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"// version.toString()//"1.4.3"

    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

//accompanist:
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.28.0")

// Hilt
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    implementation ("com.google.dagger:hilt-android:2.38.1")
    implementation("androidx.compose.ui:ui-unit-android:1.6.0")
    kapt ("com.google.dagger:hilt-compiler:2.38.1")

//Navigation:
    implementation ("androidx.navigation:navigation-compose:2.6.0")
    //implementation("androidx.compose.material:material:1.4.3")

//windows Size:
    implementation("androidx.compose.material3:material3-window-size-class")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    implementation(platform("androidx.compose:compose-bom:2023.03.00"))

    implementation("androidx.compose.ui:ui:$version")
    implementation("androidx.compose.ui:ui-tooling-preview:$version")

    implementation("androidx.compose.ui:ui-graphics")

    implementation("androidx.compose.material3:material3")

//google service firebase
    implementation(platform("com.google.firebase:firebase-bom:32.7.1"))

    implementation ("com.google.firebase:firebase-auth-ktx:21.1.0")
    implementation("com.google.firebase:firebase-auth:21.1.0")
    implementation ("com.google.android.gms:play-services-auth:20.4.1")

// mapas:
    implementation("com.google.maps.android:maps-compose:2.11.2")
    implementation("com.google.android.gms:play-services-maps:18.1.0")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.0")
    implementation ("androidx.navigation:navigation-compose:2.5.3")

    implementation ("io.coil-kt:coil-compose:2.2.2")

    //implementation ("com.google.android.material:material-icons:1.5.0")

    //material icons extended
    implementation ("androidx.compose.material:material-icons-extended:1.4.3")
    implementation ("androidx.core:core-ktx:1.10.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
   // androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
   // androidTestImplementation("androidx.compose.ui:ui-test-junit4:$version")
    debugImplementation("androidx.compose.ui:ui-tooling:$version")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$version")
}