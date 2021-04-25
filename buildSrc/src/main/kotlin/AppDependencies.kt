object AppDependencies {

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlinCoRoutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutine}"

    const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val fragmentKTX = "androidx.fragment:fragment-ktx:${Versions.fragmentKTX}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.support}"

    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"

    const val junit = "junit:junit:${Versions.jUnit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJUnit}"
    const val junitRunner = "androidx.test.ext:junit:${Versions.extJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.archCore}"
    const val hamcrest = "org.hamcrest:hamcrest-library:${Versions.hamcrest}"
    const val truth = "com.google.truth:truth:${Versions.googleTruth}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"

    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val robolectricShadows = "org.robolectric:shadows-multidex:${Versions.robolectricShadows}"
    const val robolectricSupport =
        "org.robolectric:shadows-supportv4:${Versions.robolectricShadows}"
    const val nharmaanMockito =
        "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.nhaarmanMockito}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val espressoWeb = "androidx.test.espresso:espresso-web:${Versions.espresso}"
}