# VodQa_MobileAutomationWorkShop

<h3>PreRequisite</h3>
* Install brew(Only for Mac OSX)
  * ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
* Java JDK Installed Version > 1.7.X
* Install node.js 
   * brew install node

<h1> Appium Mac OSX Setup For Android</h1>
  <h2> Android SDK Setup </h2>
 1. Download Android SDK from  https://developer.android.com/sdk/index.html, extract and manage the AVD's.
 2. Set ANDROID_HOME and JAVA_HOME
    * Open Terminal and Navigate to Home Directory.
    * Execute command touch .bash_profile
    * Execute command open -e .bash_profile and set the path a shown in image below( Change the path to the android sdk downloaded)
 
![Android](http://i62.tinypic.com/20tgscj.png)
    * Save the file and Execute "set" in your terminal and restart your terminal for the changes to reflect.
    * Now type adb version 
 
 <h2> Appium Setup </h2>
   1. brew install node      # get node.js
   2. npm install -g appium  # get appium
   3. npm install wd         # get appium client
   4. appium &               # start appium server
 

<h1>Appium Windows Setup For Android </h1>
## Prerequisites:
1. JAVA JDK - http://www.oracle.com/technetwork/java/javase/downloads/index.html
    * Set environment variable JAVA_HOME under 'System variables': https://github.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/blob/master/screenshots/set%20java-home.PNG
2. Android SDK - https://developer.android.com/sdk/index.html [Note: Appium supports Android API >=17]
     * Set environment variable ANDROID_HOME under 'System variables': https://github.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/blob/master/screenshots/set%20android-home.PNG
3. Node.js - https://nodejs.org/en/download/. Then run following commands on cmd:
    * npm install -g appium      #get appium
    * npm install wd    #get appium client
    * appium-doctor     #check if everything is correctly set
4. Appium.exe (zip file) (for Appium Inspector) - https://bitbucket.org/appium/appium.app/downloads/
5. Apache Maven (zip file) - https://maven.apache.org/download.cgi
     * Set environment variable M2_HOME under 'System variables': https://github.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/blob/master/screenshots/set%20maven-home.PNG
6. Any IDE: Eclipse - https://www.eclipse.org/downloads/
7. Add all the environment variables set(in steps 1,2 and 5) along with platform-tools and npm(node package manager)path to PATH variable:
So, your PATH variable would look something like:
C:\Windows\System32;%JAVA_HOME%\bin;%ANDROID_HOME%\bin;%M2_HOME%\bin;C:\Users\Administrator\AppData\Local\Android\android-sdk\platform-tools;C:\Program Files\nodejs\node_modules\npm\bin;
https://github.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/blob/master/screenshots/set%20path%20variable.PNG


## Executing a Basic Script 
### Create a Sample Project:
1. Launch Eclipse. Click on File -> New -> Other -> Maven project.
2. Select workspace and archetype-quickstart.
3. Provide Group and Artifact ID.
4. Click 'Finish'.
5. Add Appium Java Client Dependency: You can add appium java client dependency (which is a java language binding for writing Apiium tests) in pom.xml as - https://github.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/blob/master/screenshots/java_client_dependency.PNG

### Desired Capabilities: 
1. DEVICE_NAME: The kind of mobile device or emulator to use (Android Emulator, Nexus 5 etc.)
2. APP_PACKAGE: Java package of the Android app you want to run(say- com.example.android.myApp)
3. APP_ACTIVITY: Activity name for the Android activity you want to launch from your package(MainActivity, .Settings etc.)
All other Appium capabilties details can be found here - https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md

### Launch Appium and Run Scripts:
1. Launch Appium Server:  appium &
2. Run scripts
3. To View element id's : Launch Appium Inspector

<h1> Wearble Automation with Appium </h1>

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
