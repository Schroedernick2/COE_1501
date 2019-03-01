//Nicholas Schroeder

public class Garment{
	private int x;
	private int y;
	private int width;
	private int height;
	private int value;
	private String id;

	public Garment(int x, int y, int width, int height, int value, String id){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.value = value;
		this.id = id;
	}

	public int getX(){ return x; }
	public int getY(){ return y; }
	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
	public String getId(){ return id; }
	public int getValue(){ return value; }

	public String toString(){
		return "Garment at ("+x+","+y+") with pattern "+id+" and value "+value;
	}
}
