//Nicholas Schroeder
//11.8.2018

public class City{
	private double x;
	private double y;
	private String name;


	public City(String name, double x, double y){
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public String getName(){ return this.name; }
	public double getX(){ return this.x; }
	public double getY(){ return this.y; }
}
