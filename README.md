# Android MapsApp

Sample app that shows the different map services.

## HMS

### MapKit

> Android Studio project requires a `agconnect-services.json` file.

```groovy
implementation 'com.huawei.hms:maps:5.0.2.300'
```

* The minimum Android API level (minSdkVersion) required for Map Kit is 19.
* In the Map SDK 5.0.0.300 or later for Android, you must set an API key before initializing the map. You can directly copy the API key in api_key in the agconnect-services.json file, or call MapsInitializer.setApiKey(String apiKey) to set the API key.
* To replace the Google Map SDK for Android of the V2 version with the HUAWEI Map SDK, you need to replace the package name `com.google.android.gms.maps` with `com.huawei.hms.maps`. To replace the Google Map SDK for Android of the V3 version with the HUAWEI Map SDK, you need to replace the package name com.google.android.libraries.maps with com.huawei.hms.maps. (To replace the package name, you can go to Edit > Find > Replace in Path in Android Studio.)

* [FAQs](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides-V5/faq-0000001050166999-V5)

## GMS

### Google Maps

```groovy
implementation 'com.google.android.gms:play-services-maps:17.0.0'
```
