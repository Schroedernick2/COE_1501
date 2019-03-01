//Nicholas Schroeder

public class Cut{
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private boolean vertical;
	
	public Cut(int x1, int y1, int x2, int y2, boolean vertical){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.vertical = vertical;
	}

	public int getX1(){ return x1; }
	public int getY1(){ return y1; }
	public int getX2(){ return x2; }
	public int getY2(){ return y2; }
	public boolean isVertical(){ return vertical; }

	public String toString(){
		String type = "Vertical";
		
		if(!vertical)
			type = "Horizontal";

		return type+" cut from ("+x1+","+y1+") to ("+x2+","+y2+")";
	}
	public boolean equals(Cut c){
		if(c.getX1() == this.x1 && c.getY1() == this.y1 &&
		 	c.getX2() == this.x2 && c.getY2() == this.y2 && 
		 	c.isVertical() == this.vertical){
			return true;
		}
		return false;
	}
}
