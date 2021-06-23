# Real Time Obstacle Avoidance for Unmanned Aerial Vehicles 

During my tensure at Binford research Labs, I have worked and gained experience extensively on commerical and industrial unmanned aerial vehicles and their maneuverability. Due to this project being a direct work product of the company the code in the source file serves only boilerplate functionality. In this repository I would like to emphasise on the various technologies I have worked on and used during my internship tenure 

## Technologies 

1. Pixhawk 
2. Unmanned Aerial Vehicles 
3. Pixhawk Mission Planner and QGroundControl
4. PID Control Systems 
5. Computer Vision (OpenCV and YOLO)
6. MavLink Protocol 
7. Embedded Systems and their deployment 

## Pixhawk 
Pixhawk is a flight controller which is based on the Proportial Integral Differential Algorithm and is used as the brain of an unmanned aerial system. 


Pixhawk is powerful open source autopilot flight stack.

Some of Pixhawks's's key features are:

1. Controls many different vehicle frames, including: aircraft (multicopters, fixed wing aircraft and VTOLs), ground vehicles and underwater vehicles.
2. Great choice of hardware for vehicle controller, sensors and other peripherals.
3. Flexible and powerful flight modes and safety features.
4. Pixhawk is a core part of a broader drone platform that includes the QGroundControl ground station, Pixhawk hardware, and MAVSDK for integration with companion computers, cameras and other hardware using the MAVLink protocol.

The detialed Pin Layput of the flight controller is as follows 
<p align = 'center'><img width="622" alt="Screenshot 2021-06-23 at 9 46 20 PM" src="https://user-images.githubusercontent.com/81710149/123132559-7f2acd00-d46c-11eb-8a2d-9b0075179430.png">
</p>

## Pixhawk Mission Planeer and QGroundControl
The Dronecode ground control station is called QGroundControl. You can use QGroundControl to load Pixhawk onto the vehicle control hardware, you can setup the vehicle, change different parameters, get real-time flight information and create and execute fully autonomous missions.

The primary goal of QGC is ease of use for both first time and professional users. It provides full flight control and mission planning for any MAVLink enabled drone, and vehicle setup for both Pixhawk and ArduPilot powered UAVs.

Some of the features of mission planner include 
1. Point-and-click waypoint/fence/rally point entry, using Google Maps/Bing/Open street maps/Custom WMS.
2. Select mission commands from drop-down menus
3. Download mission log files and analyze them
4. Configure autopilot settings for your vehicle
5. Interface with a PC flight simulator to create a full software-in-the-loop (SITL) UAV simulator.
6. Run its own SITL simulation of many frames types for all the ArduPilot vehicles.

## OpenCv2 and Yolo 
OpenCV (Open Source Computer Vision Library) is an open source computer vision and machine learning software library. OpenCV was built to provide a common infrastructure for computer vision applications and to accelerate the use of machine perception in the commercial products. Being a BSD-licensed product, OpenCV makes it easy for businesses to utilize and modify the code.

The library has more than 2500 optimized algorithms, which includes a comprehensive set of both classic and state-of-the-art computer vision and machine learning algorithms. These algorithms can be used to detect and recognize faces, identify objects, classify human actions in videos, track camera movements, track moving objects, extract 3D models of objects, produce 3D point clouds from stereo cameras, stitch images together to produce a high resolution image of an entire scene, find similar images from an image database, remove red eyes from images taken using flash, follow eye movements, recognize scenery and establish markers to overlay it with augmented reality. 

Open Cv works on :
1. Recurrent Convolutional Neural Networks 
2. Region Based Convolutional Neural Networks
3. YOLO-based Convolutional Neural Network 

By using YOLO(You Only Look Once) based neiral networks computations of more than 45 frames per second can be made by converting images into blobs 

<p align = 'center'>
<img width="1200" alt="Screenshot 2021-06-23 at 9 58 43 PM" src="https://user-images.githubusercontent.com/81710149/123134225-34aa5000-d46e-11eb-8bb2-77da751d7a12.png">
 </p>

## Mavlink Protocol 
MAVLink is a very lightweight messaging protocol for communicating with drones. MAVLink follows a modern hybrid publish-subscribe and point-to-point design pattern: Data streams are sent, published as topics while configuration sub-protocols such as the mission protocol or parameter protocol are point-to-point with retransmission.

Messages are defined within XML files. Each XML file defines the message set supported by a particular MAVLink system, also referred to as a dialect. The reference message set that is implemented by most ground control stations and autopilots is defined in a common xml file.

Code generators create software libraries for specific programming languages from these XML message definitions, which can then be used by drones, ground control stations, and other MAVLink systems to communicate. The generated libraries can therefore be used without limits in any closed-source application without publishing the source code of the closed-source application.

MAVLink has just 8 bytes overhead per packet, including start sign and packet drop detection. MAVLink 2 has just 14 bytes of overhead . Because MAVLink doesn't require any additional framing it is very well suited for applications with very limited communication bandwidth.

Many different programming languages can be used, running on numerous microcontrollers/operating systems and also allows up to 255 concurrent systems on the network while enabling offboard and onboard communication. 


