# Pasolini, Sguardi di Vita

A rewritten version of one of my first projects: "Pasolini: Sguardi di Vita" using a MVVM architecture and [Kotlin](https://kotlinlang.org/). 

The app present content regarding the italian poet **Pier Paolo Pasolini** and the Rome neighbourhood where he mainly lived, guiding the user in a digital and interactive visit of these places.

I used the @Plastix [Android-Boilerplate](https://github.com/Plastix/Kotlin-Android-Boilerplate) as project template.

## Screenshots

## Libraries
* [Dagger 2](http://google.github.io/dagger/)
* [RxJava 2](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* [Retrofit 2](http://square.github.io/retrofit/)
* [Picasso](http://square.github.io/picasso/)
* [Google Support Libraries](http://developer.android.com/tools/support-library/index.html)
* MetaioSDK
* Google Maps APIs
* YouTube APIs

## Testing Libraries
* [JUnit](http://junit.org/junit4/)
* [Mockito](http://mockito.org/)

## Requirements
To compile and run the project you'll need:

- [Android SDK](http://developer.android.com/sdk/index.html)
- [Android N (API 25)](http://developer.android.com/tools/revisions/platforms.html)
- Android SDK Tools
- Android SDK Build Tools `25`
- Android Support Repository
- [Kotlin](https://kotlinlang.org/) `1.0.6`
- Kotlin plugin for Android Studio

Building
--------

To build, install and run a debug version, run this from the root of the project:

```
./gradlew assembleDebug
```

Testing
-------

To run **unit** tests on your machine:

```
./gradlew test
```

To run **instrumentation** tests on connected devices:

```
./gradlew connectedAndroidTest
```


## Release Builds
A release build needs to be signed with an Android Keystore. The easiest way to generate a keystore is to open
Android Studio and go to `Build -> Generate Signed Apk -> Create New...` After that you need to create a
`signing.properties` file in the root directory and add the following info to it:
```INI
STORE_FILE=/path/to/your.keystore
STORE_PASSWORD=yourkeystorepass
KEY_ALIAS=projectkeyalias
KEY_PASSWORD=keyaliaspassword
```
Running `./gradlew assembleRelease` will then build and sign a release version of the app.

## FAQ
#### Why Kotlin?
In a nutshell, Kotlin throws all the bad parts of Java out the window and brings lots of great features from
Java 8 and functional programming (Yet still compiling to Java 6 bytecode). Kotlin brings much needed language
features to Android which is stuck on Java 6.

