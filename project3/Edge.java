//Nicholas Schroeder
//11.8.2018

public class Edge{
	private City city1;
	private City city2;

	//edge from city1 - city2
	public Edge(City city1, City city2){
		this.city1 = city1;
		this.city2 = city2;
	}

	public City getFirstCity(){ return city1; }
	public City getSecondCity(){ return city2; }
}
