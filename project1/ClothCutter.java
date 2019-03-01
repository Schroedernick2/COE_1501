//Nicholas Schroeder

import java.util.*;

public class ClothCutter{
	private ArrayList<Pattern> patterns;
	private int maxWidth;
	private int maxHeight;

	private ArrayList<Garment> garments;
	private ArrayList<Cut> cuts;
	private BestCloth[][] memo;

	public ClothCutter(int maxWidth, int maxHeight, ArrayList<Pattern> patterns){
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.patterns = patterns;
		this.garments = new ArrayList<Garment>();
		this.cuts = new ArrayList<Cut>();
		this.memo = new BestCloth[maxWidth][maxHeight];
	}

	public int optimize(){
		System.out.println("Optimizing Value for a "+maxWidth+"x"+maxHeight+" cloth...");
		BestCloth best = optimize(maxWidth,maxHeight);
		garments = best.getGarments();
		cuts = best.getCuts();

		return best.getValue();
	}

	private BestCloth optimize(int width, int height){
		if(memo[width-1][height-1] != null){
			return memo[width-1][height-1];
		}

		ArrayList<Garment> bestGarments = new ArrayList<Garment>();
		ArrayList<Cut> bestCuts = new ArrayList<Cut>();
		BestCloth bestCloths = new BestCloth(0,bestGarments,bestCuts);
		int bestValue = 0;
		Pattern bestPat = null;

		for(Pattern pat : patterns){
			if(pat.getWidth() > width || pat.getHeight() > height)
				continue;
			bestValue = pat.getValue();
			bestPat = pat;
		}
		if(bestValue>0){
			bestGarments.add(new Garment(width,height,bestPat.getWidth(),bestPat.getHeight(),bestValue,bestPat.getId()));
			bestCloths = new BestCloth(bestValue,bestGarments,bestCuts);
		}
		else{
			memo[width-1][height-1] = new BestCloth(0,bestGarments,bestCuts);
			return memo[width-1][height-1];
		}

		int better = 0;

		//horizontal
		for(int i=1;i<height;i++){
			BestCloth slice1 = optimize(width,i);
			BestCloth slice2 = optimize(width,height-i);

			better = slice1.getValue() + slice2.getValue();

			if(better <= bestValue)
				continue;
			bestCuts = addCuts(slice1.getCuts(),slice2.getCuts());
			bestCuts.add(new Cut(maxWidth-width,i,maxWidth,i,false));
			bestValue = better;
			bestCloths = new BestCloth(bestValue,addGarments(slice1.getGarments(),slice2.getGarments()),bestCuts);
		}

		//vertical
		for(int i=1;i<width;i++){
			BestCloth slice1 = optimize(i,height);
			BestCloth slice2 = optimize(width-i,height);

			better = slice1.getValue() + slice2.getValue();

			if(better <= bestValue)	
				continue;
			bestCuts = addCuts(slice1.getCuts(),slice2.getCuts());
			bestCuts.add(new Cut(i,maxHeight-height,i,maxHeight,true));
			bestValue = better;
			bestCloths = new BestCloth(bestValue,addGarments(slice1.getGarments(),slice2.getGarments()),bestCuts);
		}
		memo[width-1][height-1] = bestCloths;
		return bestCloths;
	}

	private ArrayList<Garment> addGarments(ArrayList<Garment> slice1, ArrayList<Garment> slice2){
		ArrayList<Garment> addedGarments = new ArrayList<Garment>();

		for(Garment g : slice1)
			addedGarments.add(g);
		for(Garment g2 : slice2)
			addedGarments.add(g2);
		return addedGarments;
	}


	private ArrayList<Cut> addCuts(ArrayList<Cut> temp1, ArrayList<Cut> temp2){
		ArrayList<Cut> addedCuts = new ArrayList<Cut>();

		for(Cut c : temp1)
			addedCuts.add(c);
		for(Cut c2 : temp2)
			addedCuts.add(c2);
		return addedCuts;
	}

	public ArrayList<Cut> getCuts(){ return cuts; }
	public ArrayList<Garment> getGarments(){ return garments; }
}
