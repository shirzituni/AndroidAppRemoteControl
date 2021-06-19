# Android-App-Remote-Control
```bash
Third milestone
1. Using MVVM architecture in a multi-threaded environment.
2. Implementing a TCP Client to send the data to FlightGear.
3. Control your flight from our Android App Remote Control
4. If the images in the README look blurry, click on the image to improve the quality.
```
## Project Description
This project is an Android App Remote Control, wich help you control your flight in the FlightGear Game.
The control of the plane is done from the app, with a joystick and two sliders.  
## 📽️ Demonstration Video
You can watch out trial video on YouTube- [------->LINK](https://youtu.be/fqjke-0-wj4)


## Architecture MVVM
We built this project based on MVVM architecture as follow:
-  `<Model>` - The Model is responsible of the connection to the server, which talkes to the FlightGear.
-  `<View>` - Here we have two XML files (XML to each activity), that are responsible of what the user sees on the screen (UI). All the objects are connected to the ViewModel, wich has Listeners for each object.
-  `<ViewModel>`- The View and the MainActivities are connected to the ViewModel. The ViewModel is the only one who talkes to the Model.

 
## Using two activities
To create two windows for the app, we used two activities.
* The first activity (MainActivity) is the login screen, where you have to enter IP and PORT to connect to the server.
* If the connection succeeded, the following message will appear at the bottom of the screen -
  - "Try to connecte to the server"
  - "Connected Successfully into the Server!"
* and you will move to the seconed activity (MainActivity2) screen. There you can move the plane! 

## Features
- [x] Seprated screen for the connection (IP & Port).
- [x] Seprated screen for the controllers -Joystick & two sliders.
## Preliminary requirements
- [x] Android Studio
- [x] FlightGear
## Setup instructions
* Please Download "FlightGearDesktopApp" project to Android Studio.
* Download FlightGear application from: [FlightGear](https://www.flightgear.org/)
* Define FlightGear settings as follow: 
> --telnet=socket,in,10,192.168.1.28,5400,tcp
> --httpd=8080

<img src="https://user-images.githubusercontent.com/73064092/122537440-3b7c3180-d02e-11eb-8292-875a9dbe2bbd.png" width="400" height="350">

   - (IP in this case - 192.168.1.28, Port in this case - 5400 , Port must be an integer number. Change according to your IP & Port).
* Press *Fly*, and don't forget to start the engine!

Enjoy :)
## Operating instructions
- [ ] Insert here your IP & Port, than click on the "Connect" button: 

<img src="https://user-images.githubusercontent.com/73064092/122533457-4339d700-d02a-11eb-9f62-99b60ea3e9c6.png" width="250" height="500">

- [ ] If the connection succed you will see this massage: 
 
![image](https://user-images.githubusercontent.com/73064092/122534738-80529900-d02b-11eb-9ae8-8b1f53b7dd2b.png)

- [ ] Move the Joystick to change Aileron and Elevator, use the sliders to change the Throttle and the Rudder:   


<img src="https://user-images.githubusercontent.com/73064092/122562185-76d92900-d04b-11eb-8101-8d988d23144d.png" width="250" height="500">







## UML diagram
![image](https://user-images.githubusercontent.com/73064092/122532672-716ae700-d029-11eb-9d81-186a300a8117.png)




