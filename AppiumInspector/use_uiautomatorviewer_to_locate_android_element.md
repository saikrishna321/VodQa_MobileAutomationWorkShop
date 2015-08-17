# Use uiautomatorviewer to locate Android element

Actually Android SDK provides a GUI tool to scan and analyze the UI elements of app - uiautomatorviewer.

After we have successfully launched Android emulator, we can type `uiautomatorviewer` in "Terminal" to launch it.

![Alt text](https://raw.githubusercontent.com/hy1984427/appium/master/images/android_uiautomatorviewer_locate_element.png "uiautomatorviewer to locate element in Android app")

***Please note, we need to uncheck the option "Use Host GPU" in avd settings, but this will signaficantly reduce the performance of emulator. And seems currently Nexus5 avd emulator is not supported by uiautomatorviewer.***

![Alt text](https://raw.githubusercontent.com/hy1984427/appium/master/images/android_avd_uncheck_use_host_gpu.png "Uncheck Use Host GPU")

Due to reason above, it's time for us to choose another emulator to boost our productivity.
