//Nicholas Schroeder
//11.8.2018

import java.util.*;

public class EuclideanTSP{
	private static final double INFINITY = Double.MAX_VALUE;	//pseudo-infinity

	public static ArrayList<Edge> MST(ArrayList<City> cities){
		ArrayList<Edge> mst = new ArrayList<Edge>();
		ArrayList<City> addedNodes = new ArrayList<City>();

		addedNodes.add(cities.remove(0));

		while(cities.size() != 0){
			double minDistance = INFINITY;
			Edge minEdge = null;

			for(City firstCity : addedNodes){
				for(City nextCity : cities){
					//get distance
					double dist = distanceBetweenCities(firstCity,nextCity);
					//if(distance < min) --> set minEdge, set minDist
					if(dist < minDistance){
						minDistance = dist;
						minEdge = new Edge(firstCity,nextCity);
					}
				}
			}
			//remove minEdge.secondCity from cities
			cities.remove(minEdge.getSecondCity());
			//add minEdge.secondCity to nodes
			addedNodes.add(minEdge.getSecondCity());
			//add minEdge to mst
			mst.add(minEdge);
		}
		return mst;
	}

	public static ArrayList<City> MSTTour(ArrayList<Edge> mst){
		ArrayList<City> mstTour = new ArrayList<City>();

		return MSTTour(mst.get(0).getFirstCity(),mstTour,mst);
	}

	private static ArrayList<City> MSTTour(City currentCity, ArrayList<City> mstTour, ArrayList<Edge> mst){
		mstTour.add(currentCity);
		for(Edge e : mst){
			City a = e.getFirstCity();
			City b = e.getSecondCity();

			if(a.equals(currentCity) && !mstTour.contains(b))
				mstTour = MSTTour(b,mstTour,mst);
		}

		return mstTour;
	}

	public static String weight(ArrayList<Edge> mst){
		double totalWeight = 0;

		for(Edge e : mst)
			totalWeight += distanceBetweenCities(e.getFirstCity(),e.getSecondCity());

		return ""+Math.round(totalWeight*100.0)/100.0;
	}

	public static String length(ArrayList<City> mstTour){
		double totalLength = 0;

		for(int i=0;i<mstTour.size()-1;i++)
			totalLength += distanceBetweenCities(mstTour.get(i),mstTour.get(i+1));

		return ""+Math.round(totalLength*100.0)/100.0;
	}

	private static double distanceBetweenCities(City a,City b){
		double ax = a.getX();
		double ay = a.getY();
		double bx = b.getX();
		double by = b.getY();

		double side1 = Math.abs(ax-bx);
		double side2 = Math.abs(ay-by);

		side1 *= side1;	
		side2 *= side2;

		return (Math.sqrt(side1+side2));
	}
}
