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
   4. appium &               # start appium


