//Nicholas Schroeder

import java.util.*;

public class BestCloth{
	private ArrayList<Garment> garments;
	private ArrayList<Cut> cuts;
	private int value;

	public BestCloth(int value, ArrayList<Garment> garments,ArrayList<Cut> cuts){
		this.value = value;
		this.garments = garments;
		this.cuts = cuts;
	}

	public int getValue(){ return value; }
	public ArrayList<Garment> getGarments(){ return garments; }
	public ArrayList<Cut> getCuts(){ return cuts; }
}
