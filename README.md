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

   Referrence Link :
       https://supriyavivek.wordpress.com/2015/03/03/appium-setup-for-windows/
       
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
