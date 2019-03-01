//Nicholas Schroeder

import java.util.*;

public class Main{
	public static void main(String[] args){
		System.out.println("Starting Application...");

		ArrayList<Pattern> patterns = new ArrayList<Pattern>();

		int width = 15;
		int height = 15;

	    patterns.add(new Pattern(2,2,1,"A"));
	    patterns.add(new Pattern(2,6,4,"B"));
	    patterns.add(new Pattern(4,2,3,"C"));
	    patterns.add(new Pattern(5,3,5,"D"));

	    ClothCutter c = new ClothCutter(width,height,patterns);

	    System.out.println("\nMax value: "+c.optimize()+"\n");
	    ArrayList<Garment> garments = c.getGarments();
	    ArrayList<Cut> cuts = c.getCuts();

	    for(Garment g : garments)
	    	System.out.println(g);
	    for(Cut cut : cuts)
	    	System.out.println(cut);

	    Collections.reverse(cuts);

	    new ClothCutterGui(width,height,garments,patterns);
	}
}
