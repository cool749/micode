plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "net.micode.notes"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "net.micode.notes_master"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    packaging {
        resources {
            // 排除冲突的 DEPENDENCIES 文件
            excludes += "META-INF/DEPENDENCIES"
            // 可选：如果后续还有 LICENSE/NOTICE 冲突，也可以一起排除
            excludes += "META-INF/LICENSE"
            excludes += "META-INF/NOTICE"
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
/*    implementation(fileTree(mapOf(
        "dir" to "D:\\Notesmaster\\httpcomponents-client-4.5.14-bin\\lib",
        "include" to listOf("*.aar", "*.jar"),
        "exclude" to listOf()
    )))*/

    implementation(files("D:\\Android\\source\\httpcomponents-client-4.5.14-bin\\lib\\httpclient-osgi-4.5.14.jar"))
    implementation(files("D:\\Android\\source\\httpcomponents-client-4.5.14-bin\\lib\\httpclient-win-4.5.14.jar"))
    implementation(files("D:\\Android\\source\\httpcomponents-client-4.5.14-bin\\lib\\httpcore-4.4.16.jar"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}