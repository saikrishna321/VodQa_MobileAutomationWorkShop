# Precondition of using inspector and recording script for Android

We need to start appium GUI tool first, and setup some parameters.

For Android, we need to set path of test app, like:

![Alt text](https://raw.githubusercontent.com/hy1984427/appium/master/images/android_gui_setting.png "Android app path in appium GUI setting")

and we also need to configure appium GUI to prelaunch the test app:

![Alt text](https://raw.githubusercontent.com/hy1984427/appium/master/images/gui_prelaunch.png "appium GUI setting - prelaunch")

After all these, we can `Launch` appium.

***If you are using appium v1.1.0, you need to copy the `zipalign` from the sdk "build-tools" folder, such as "/Applications/adt/sdk/build-tools/19.1.0", to "/Applications/adt/sdk/tools".***

![Alt text](https://raw.githubusercontent.com/hy1984427/appium/master/images/android_zipalign_appium_1.1.png "Android zipalign appium v1.1")

***This issue is fixed in appium v1.2.0.***
