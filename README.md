
# Mobile Android Automation using Appium

# Appium Setup in Mac OSX:
Checkout our Appium Setup for Mac OSX Installation wiki [here](https://github.com/saikrishna321/VodQa_MobileAutomationWorkShop/wiki/Appium-Mac-Installation)

# Appium Setup in Windows Platform:
Checkout our Appium Setup for windows Installation wiki [here](https://github.com/saikrishna321/VodQa_MobileAutomationWorkShop/wiki/Appium-Windows-Installation)

## Executing a Basic Script 
### Create a Sample Project:
1. Launch Eclipse. Click on File -> New -> Other -> Maven project.
2. Select workspace and then click on Next.
3. Select 'Catalog -> Internal' and 'maven-archetype-quickstart'.
3. Provide Group and Artifact ID.
4. Click 'Finish'.
5. Add Appium Java Client Dependency: You can add appium java client dependency (which is a java language binding for writing Appium tests) in pom.xml as - ![screenshots](https://raw.githubusercontent.com/saikrishna321/VodQa_MobileAutomationWorkShop/master/screenshots/java_client_dependency.PNG)

### Desired Capabilities: 
1.  DEVICE_NAME: The kind of mobile device or emulator to use (Android Emulator, iPhone Simulator, Nexus 5 etc.)
2.  APP: The absolute local path or remote http URL to a .apk file. This capability is not required for Android if you specify appPackage and appActivity capabilities.
3.  APP_PACKAGE(Android): Java package of the Android app you want to run(say- com.example.android.myApp)
4.  APP_ACTIVITY(Android): Activity name for the Android activity you want to launch from your package(MainActivity, .Settings etc.)
5.  UDID(iOS): Unique device identifier of the connected physical device

All other Appium capabilties details can be found here - https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md

### Launch Appium and Run Scripts:
1. Launch Appium Server:  appium &
2. Run scripts
3. To View any element id : Launch Appium Inspector

# Wearble Automation with Appium

 1. Download the Android Wear App from Google PlayStore and install it on the Android Phone.
 2. Sync the Android Wearbable device/emulator with Android Phone.
 3. Check if android phone and android wearable are detected
    * Navigate to terminal and type "adb devices" -- Should display both phone and wearbale
 4. Port forward 5601 from mac to android device to allow wearable device to connect with the andriod device.
    * abd -s <device-serial-no> forward tcp:5601 tcp:5601
 5. Run appium server one for android device(port 4724) and one for the wearable device(port 4723)
    * appium -p 4723 --udid <wearbale-serial-number> &
    * appium -p 4724 --udid <android-phone-serial-number> &
 6. Run the Sameple Test(AppiumWearableTest)
 
[![ScreenShot](https://i.ytimg.com/vi/ULXhQTyLVIA/0.jpg?time=1439788986539)](https://www.youtube.com/watch?v=ULXhQTyLVIA)


How to get the UIAutomation Javascript API from Instruments

  1. brew install ios-sim
  2. ios-sim launch ios.app --devicetypeid com.apple.CoreSimulator.SimDeviceType.iPhone-6  
  3. 
  
## Deploying an iOS app to a real device

To prepare for your Appium tests to run on a real device, you will need to:

1. Build your app with specific device-targeted parameters
1. Use [fruitstrap](https://github.com/ghughes/fruitstrap), a 3rd-party tool,
 to deploy this build to your device

### Xcodebuild with parameters:
A newer xcodebuild now allows settings to be specified. Taken from [developer.apple.com](https://developer.apple.com/library/mac/#documentation/Darwin/Reference/ManPages/man1/xcodebuild.1.html):

```center
xcodebuild [-project projectname] [-target targetname ...]
             [-configuration configurationname] [-sdk [sdkfullpath | sdkname]]
             [buildaction ...] [setting=value ...] [-userdefault=value ...]
```

This is a resource to explore the available [settings](https://developer.apple.com/library/mac/#documentation/DeveloperTools/Reference/XcodeBuildSettingRef/1-Build_Setting_Reference/build_setting_ref.html#//apple_ref/doc/uid/TP40003931-CH3-DontLinkElementID_10)

```center
CODE_SIGN_IDENTITY (Code Signing Identity)
    Description: Identifier. Specifies the name of a code signing identity.
    Example value: iPhone Developer
```

PROVISIONING_PROFILE is missing from the index of available commands,
but may be necessary.

Specify "CODE_SIGN_IDENTITY" & "PROVISIONING_PROFILE" settings in the
xcodebuild command:

```center
xcodebuild -sdk <iphoneos> -target <target_name> -configuration <Debug> CODE_SIGN_IDENTITY="iPhone Developer: Mister Smith" PROVISIONING_PROFILE="XXXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXX"
```

On success, the app will be built to your ```<app_dir>/build/<configuration>-iphoneos/<app_name>.app```


## Element Identification for Android
| elements      | locators      | examples |
| ------------- |:-------------:| ---------|
| type          | className     | driver.findElementsByClassName("")|
| text,label    | AccessibilityId|driver.findElementByAccessibilityId("").click();|
| resource-id |  Id      |driver.findElementsById("")|

## Element Identification for IOS
| elements      | locators      | examples |
| ------------- |:-------------:| ---------|
| type          | className     | driver.findElementsByClassName("")|
| name,label    | AccessibilityId|driver.findElementByAccessibilityId("").click();|
| value |  Id      |driver.findElementsById("")|
