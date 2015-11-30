# Mobile Android Automation using Appium

# Appium Mac OSX Setup For Android
## Prerequisites:
1. Brew:
  * ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
2. JAVA JDK - http://www.oracle.com/technetwork/java/javase/downloads/index.html
3. Android SDK - https://developer.android.com/sdk/index.html [Note: Appium supports Android API >=17]
4. Set ANDROID_HOME and JAVA_HOME
   * Open Terminal and Navigate to Home Directory.
   * Execute command touch .bash_profile
   * Execute command open -e .bash_profile and set the path a shown in image below( Change the path to the android sdk downloaded)
![screenshots](https://raw.githubusercontent.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/master/screenshots/set_bash_profile.png)
   * Save the file and Execute "set" in your terminal and restart your terminal for the changes to reflect.
5. Node.js and Appium:
  * brew install node    # get node.js
  * npm install -g appium     # get appium
  * npm install wd    # get appium client
  * appium-doctor     # check if everything is correctly set
6. Appium.app (for Appium Inspector) - https://bitbucket.org/appium/appium.app/downloads/
7. Any IDE: Eclipse - https://www.eclipse.org/downloads/

# Appium Windows Setup For Android
## Prerequisites:
1. JAVA JDK - http://www.oracle.com/technetwork/java/javase/downloads/index.html
  * Set environment variable JAVA_HOME under 'System variables':  ![screenshots](https://raw.githubusercontent.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/master/screenshots/set%20java-home.PNG)

2. Android SDK - https://developer.android.com/sdk/index.html [Note: Appium supports Android API >=17]
  * Set environment variable ANDROID_HOME under 'System variables': ![screenshots](https://raw.githubusercontent.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/master/screenshots/set%20android-home.PNG)

3. Node.js - https://nodejs.org/en/download/. Then run following commands on cmd:
    * npm install -g appium    # get appium
    * npm install wd    # get appium client
    * appium-doctor    # check if everything is correctly set
4. Appium.exe (zip file) (for Appium Inspector) - https://bitbucket.org/appium/appium.app/downloads/
5. Apache Maven (zip file) - https://maven.apache.org/download.cgi - Set environment variable M2_HOME under 'System variables': 
![screenshots](https://raw.githubusercontent.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/master/screenshots/set%20maven-home.PNG)

6. Any IDE: Eclipse - https://www.eclipse.org/downloads/
7. Add all the environment variables set(in steps 1,2 and 5) along with platform-tools and npm(node package manager)path to the PATH variable: 
![screenshots](https://raw.githubusercontent.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/master/screenshots/set%20path%20variable.PNG)

So, your PATH variable would look something like:
C:\Windows\System32;%JAVA_HOME%\bin;%ANDROID_HOME%\bin;%M2_HOME%\bin;C:\Users\Administrator\AppData\Local\Android\android-sdk\platform-tools;C:\Program Files\nodejs\node_modules\npm\bin;




## Executing a Basic Script 
### Create a Sample Project:
1. Launch Eclipse. Click on File -> New -> Other -> Maven project.
2. Select workspace and then click on Next.
3. Select 'Catalog -> Internal' and 'maven-archetype-quickstart'.
3. Provide Group and Artifact ID.
4. Click 'Finish'.
5. Add Appium Java Client Dependency: You can add appium java client dependency (which is a java language binding for writing Appium tests) in pom.xml as - ![screenshots](https://raw.githubusercontent.com/SmritiTuteja/VodQa_MobileAutomationWorkShop/master/screenshots/java_client_dependency.PNG)

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
