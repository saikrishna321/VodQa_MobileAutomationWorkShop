# Use Genymotion instead of Android AVD for emulator

***Since the performance of Android AVD emulator is quite low, especially not using the "host GPU", so it's better for us to use Genymotion, which is a faster Android emulator, based on VirtualBox.***

***So we need to install VirtualBox and Genymotion first.***

Except the emulator is hosted in a different way, it's the same to locate element using uiautomatorviewer.

![Alt text](https://raw.githubusercontent.com/hy1984427/appium/master/images/android_uiautomatorviewer_locate_element_genymotion.png "uiautomatorviewer to locate element in Android app using Genymotion")

We can see the elements on current page shows in tree structure on the right panel; and the details of the element selected will show beneath the elements' list panel.

Once you have found the elements on one page, and write script by your self, you need to take screenshot of another page, and repeat the steps.

The uiautomatorviewer doesn't provide the "Record" feature.

Everything is ready, it's time for us to write our first iOS script from scratch.
