plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSDK)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = "com.shreyas.hybridlogin"
        minSdkVersion(AppConfig.minSDK)
        targetSdkVersion(AppConfig.targetSDK)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    flavorDimensions(AppConfig.dimension)
    viewBinding {
        android.buildFeatures.viewBinding = true
    }
    dataBinding {
        android.buildFeatures.dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    productFlavors {
        create("production") {
            dimension = AppConfig.dimension
            versionCode = AppConfig.versionCode
            versionName = AppConfig.versionName
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
        javaParameters = true
    }
    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
    packagingOptions {
        exclude("META-INF/notice.txt")
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
    sourceSets {
        getByName("main").java.srcDir("src/main/java")
        getByName("test").java.srcDirs("src/test/java")
        getByName("test").resources.srcDirs("src/test/assets")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<Test>().all {
    jvmArgs("-ea -noverify")
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(AppDependencies.kotlinStdLib)
    implementation(AppDependencies.kotlinCoRoutinesCore)
    implementation(AppDependencies.fragmentKTX)
    implementation(AppDependencies.appcompat)
    implementation(AppDependencies.constraintLayout)
    implementation(AppDependencies.material)
    implementation(AppDependencies.legacySupport)

    kapt(AppDependencies.daggerProcessor)
    kapt(AppDependencies.daggerCompiler)
    implementation(AppDependencies.dagger)
    implementation(AppDependencies.daggerAndroid)
    implementation(AppDependencies.daggerAndroidSupport)

    testImplementation(AppDependencies.junit)
    testImplementation(AppDependencies.robolectric)
    testImplementation(AppDependencies.robolectricShadows)
    testImplementation(AppDependencies.robolectricSupport)
    testImplementation(AppDependencies.archCoreTesting)
    testImplementation(AppDependencies.junitRunner)
    testImplementation(AppDependencies.mockito)
    testImplementation(AppDependencies.hamcrest)
    testImplementation(AppDependencies.truth)
    testImplementation(AppDependencies.mockk)
    testImplementation(AppDependencies.nharmaanMockito)

    androidTestImplementation(AppDependencies.extJUnit)
    androidTestImplementation(AppDependencies.espressoCore)
    androidTestImplementation(AppDependencies.espressoContrib)
    androidTestImplementation(AppDependencies.espressoWeb)
    androidTestImplementation(AppDependencies.mockk)
}