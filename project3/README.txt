Nicholas Schroeder (nis102)
Project 3 - 11.20.2018

Approach:
	For this project I used the supplied DemonstrateEuclideanTSP.java and Map.java files. I wanted to have minimal changes to these files, so I reverse engineered the methods and objects used in these files to get to my working state.

New Files:
	City.java - Class for city structure, contains X/Y coordinates and city name
	Edge.java - Edge class, has two cities (a start and an end)
	EuclideanTSP.java - This file/class has all the logic and methods for constructing an MST and finding the optimal tours.

Compile and Run:
	$javac *.java
	$java DemonstrateEuclideanTSP X
		#X is the number of cities

Other:
	To the best of my knowledge, the project is in a working state and there are no known issues.
