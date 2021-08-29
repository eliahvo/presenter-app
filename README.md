# Presenter app
An android app with which you can control your power-point presentation via volume up/down buttons. For the server-side application, python is used.

## Requirements
* `python` version 3.5 or newer
* Package `pynput` (can easily installed by `pip install pynput`)
* Android smartphone
* PC and smartphone must be in the same local network

## Installation
1. You have to get the IP address of your PC by typing `ipconfig` in a command line and extract the local IP address like the following picture shows: ![ipconfig example](/doc/ipconfig.png)
2. Now you can start the server python script by typing `python presenterServer.py ip-addr` in a command line. `ip-addr` must be replaced by the IP from the command before. You should see something like this: <br></br>![python output](/doc/pythonOutput.png)
3. Install now the presenter.apk on your android smartphone if not already done and start it. It looks like this: ![app on create](/doc/appOnCreate.png)
<br></br> Here you have to enter the IP address from your pc which you picked on step 1. Enter it and click `OK`. It should look like this: <br></br>![app ip entered](/doc/appIpEntered.png)
4. Now focus the PowerPoint presentation on your PC and let the python program run in the background. You are now able to control the presentation with your volume buttons on your smartphone: `volume up` to go forward and `volume down` to go backward in the foils.

## License
**The MIT License (MIT)**

Copyright © 2021 Eliah Vogel
