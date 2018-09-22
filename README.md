# TBA-API-V3
A Java library for pulling robotics data from https://www.thebluealliance.com.

I made this API because none of the other Java APIs were working for me. I hope that this will be the last place you have to go for your TBA API needs. Thanks!
# Installation
You'll need to create a TBA account and register a read API key
here: https://www.thebluealliance.com/account.
## With JitPack
Use [JitPack](https://jitpack.io) to install the library with Maven, Gradle, SBT, or Leiningen. Simply go to https://jitpack.io/#wdavies973/tba-api-v3, select your release, and add the provided lines to your buildfile.

## Manually
Download the .jar file from https://github.com/wdavies973/TBA-API-V3/releases.

This API also requires json-simple. Download the .jar file at https://code.google.com/archive/p/json-simple/, and add both JARs to your build path.

# Overview
TBA-API-V3 is modeled exactly off of the API specifications described at https://www.thebluealliance.com/apidocs/v3. All API
calls found on this page are implemented in Java (or will be soon). Models can be found in the ```models``` package, if a model
begins with a 'S', it represents a ```simple``` model as defined by the V3 API. To get started using the API, set the
API read AUTH token with `Constants.AUTH = "<auth-token>"`. Create a ```TBA``` object for usage with no constructors (better if parameters
will be changed frequently) and a ```CTBA``` object for usage with constructors (better if parameters won't be changed frequently).
For more information, visit the wiki at https://www.github.com/wdavies973/TBA-API-V3/wiki.

# Android troubleshooting
Make sure you have internet permissions declared in the manifest:  
```java
<uses-permission android:name="android.permission.INTERNET"/> 
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 ```

Make sure you run this line of code before calling any API commands:  
```java
StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build(); StrictMode.setThreadPolicy(policy);
```

Make sure you make API calls in an ```AsyncTask```

# Tutorial and Examples
Find them at https://www.github.com/wdavies973/TBA-API-V3/wiki.  
The API is designed to be easy to use and fairly idiot-proof (no offense, I wish everyone designed their software like that).

# Contribute
There are about 5 API calls that haven't been implemented yet. JUnit tests and more would also be useful.
I would greatly appreciate any help towards making this API a solid interface for the V3 API for the years to come.

# Other
Report any bugs or suggestions to wdavies973@gmail.com
If you'd like any more functionality as far as ways you can pull data, and what you can pull, let me know and I'll add it right away.

# Roblu
This API is used by my scouting app Roblu. It's an all-in-one solution for scouting.
Check it out at: https://www.roblu.net


