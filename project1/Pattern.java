//Nicholas Schroeder

public class Pattern{
	private int width;
	private int height;
	private int value;
	private String id;

	public Pattern(int width, int height, int value, String id){
		this.width = width;
		this.height = height;
		this.value = value;
		this.id = id;

		System.out.println("\t"+this);
	}

	public int getWidth(){ return width; }
	public int getHeight(){ return height; }
	public int getValue(){ return value; }
	public String getId(){ return id; }

	public String toString(){
		return "Pattern "+id+": (width: "+width+", height: "+height+", value: "+value+")";
	}
}
