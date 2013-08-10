TradeStuffs
======

TradeStuffs adds coins, safes and banks to Minecraft.
This mod is a entry for ModJam 2013.

More information will come soon...

[Compiling](https://github.com/CCM-Modding/Modjam#compiling)

***
### Compiling:
IMPORTANT: Please report any issues you have, there might be some problems with the documentation!
***
#### Prerequisites
1. **WARNING:  Make sure you know EXACTLY what you're doing!  It's not any of our faults if your OS crashes, becomes corrupted, etc.**
2. Download and install the Java JDK [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).  Scroll down, accept the `Oracle Binary Code License Agreement for Java SE`, and download the one pertaining to your OS (necessary for GMCP).
  * Go to `Control Panel\System and Security\System`, and click on `Advanced System Settings` on the left-hand side.
	* Click on `Environment Variables`.
  * Under `System Variables`, click `New`.
  * For `Variable Name`, input `JAVA_HOME`.
  * For `Variable Value`, input something similar to `;C:\Program Files (x86)\Java\jdk1.7.0_25` exactly as shown to the end (or wherever your Java JDK installation is), and click `Ok`.
  * Scroll down to a variable named `Path`, and double-click on it.
  * Append `;C:\Program Files (x86)\Java\jdk1.7.0_25\bin` (or your Java JDK installation directory\bin), and click `Ok`.
3. Download Gradle [here](http://www.gradle.org/).
	* Extract the files anywhere you want, eg `C:\Gradle`.
  * Again, go to `Environment Variables` just like you did for the Java JDK.
  * Under `System Variables`, click `New`.
  * For `Variable Name`, input `GRADLE_HOME`.
  * For `Variable Value`, input `C:\Gradle\gradle-1.7-rc-2` (or your Gradle directory\gradle-1.7-rc-2).
  * Scroll down to `Path`, and double-click on it.
  * Append `;C:\gradle\bin` exactly as shown to the end (or your Gadle directory\gradle-1.7-rc-2\bin).
4. Download and install Github [here](http://windows.github.com/) (Windows) or [here](http://mac.github.com/) (Mac OS X 10.7+).  For Linux, you can use a different Git application.  NOTE:  Github For Windows/Mac is OPTIONAL.  You can use your own Git application.
	* Create an account.
  * Scroll to the top of this page, login at the top-right, and then click `Clone to Windows/Mac` at the bottom of the right-hand toolbar.
  * You should see Github flash and `CCM-Modding/Modjam` appear.  (The local repository on Windows defaults to `C:\Users\(username)\Documents\GitHub\Modjam`, you can change it if you want but then you have to find it again on Github).

#### Setup And Build
1. Open a Command Prompt
2. Type `cd PATH_TO_Modjam` which is the path to were ever you cloned Trade Stuffs into
3. Press Enter
4. Type `gradle build`
5. Press Enter
6. Wait for everything to download and set up
7. Enjoy!
