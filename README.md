# Presenter app
An android app which with you can control your power-point presentation via volume up/down buttons. For the serverside application python is used.

## Requirements
* `python` version 3.5 or newer
* `pynput` (can easily installed by `pip install pynput`)
* android smartphone
* pc and smartphone must be in the same local network

## Installation
1. You have to get the ip address of your pc by typing `ipconfig` in a command line and extract the local ip address like the following picture shows: ![ipconfig example](/doc/ipconfig.png)
2. Now you can start the server python script by typing `python presenterServer.py ip-addr` in a command line. `ip-addr` must be replaced by the ip from the command before. You should see something like this: <br></br>![python output](/doc/pythonOutput.png)
3. Install now the presenter.apk on your android smartphone if not already done and start it. It looks like this: ![app on create](/doc/appOnCreate.png)
<br></br> Here you have to enter the ip address from your pc which you picked on step 1. Enter it and click `OK`. It should look like this: <br></br>![app ip entered](/doc/appIpEntered.png)
4. Now focus the power point presentation on your pc and let the python program run in background. You are now able to control the presentation with your volume buttons on your smartphone: `volume up` to go forward and `volume down` to go backward in the foils.