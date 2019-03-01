Nicholas Schroeder (nis102)
CS/COE 1501 - Project 1 Cloth Cutter

Included Files:
	1. BestCloth.java - This is a structure that contains an integer value, and array lists of garments and cuts. This structure is used to keep track of cuts and garments used in the optimal arrangement of patterns.

	2. Cut.java - This is a structure that holds integers x1, x2, y1, and y2. It also has boolean value to determine if cut is vertical or not.

	3. Garment.java - This is a structure to represent garments (patterns on a cloth with dimensions and value).

	4. Pattern.java - This structure is used to represent different patterns of different dimensions and values.

	5. ClothCutter.java - This is where the optimization happens. In the recursive method optimize(int width, int height) a BestCloth is returned with an optimal value and the garments and cuts that make that value.

	6. ClothCutterGui.java - GUI display for cloth cutter. Each pattern is a different color. I made my own driver and created a board of cell objects. each cell is 1x1 on the board of JPanels. Each pattern is represented by width X height colored cells. 

	7. Main.java - Main driver for GUI display and program itself.

Known Issues:
	-As far as I can tell, everything works as anticipated

To run:
	compile: $javac *.java
	run: $java Main 
