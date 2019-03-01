//Nicholas Schroeder

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ClothCutterGui{
	JFrame window;
	Container content;
	JPanel grid;
	cell[][] board;
	int maxWidth;
	int maxHeight;

	public ClothCutterGui(int width, int height, ArrayList<Garment> garments, ArrayList<Pattern> patterns){
		window = new JFrame("Nicky's Cloth Cutter");
		content = window.getContentPane();
		content.setLayout(new GridLayout(1,1));

		this.maxHeight = height;
		this.maxWidth = width;

		grid = new JPanel(new GridLayout(height,width));
		board = new cell[height][width];

		int adjustedHeight = (int)(500*((double)height/width));
		int adjustedWidth = 500;

		while(adjustedHeight >= 1000){
			adjustedHeight /= 2;
			adjustedWidth /=2;
		}

		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				board[i][j] = new cell(i,j);
				grid.add(board[i][j].body);
			}
		}

		content.add(grid);

		System.out.println("\nAdjusted window dimensions: "+adjustedWidth+"x"+adjustedHeight);

		HashMap legend = makeLegend(patterns);

		int w=0;
		int h=0;
		int ht=garments.get(0).getHeight();
		int hp=0;

		for(int x=0;x<garments.size();x++){
			Garment g = garments.get(x);

			if(patternFits(w,h+hp,g.getWidth(),g.getHeight())){
				setPattern(w,h+hp,g.getWidth(),g.getHeight(),(Color)legend.get(getPattern(g.getWidth(),g.getHeight(),patterns)));
			}

			if(g.getHeight()<ht){
				hp+=g.getHeight();
				if(hp>=ht){
					hp=0;
					w+=g.getWidth();
				}
			}
			else{
				w+=g.getWidth();
			}
			if(w>=maxWidth){
				w=0;
				h+=ht;
				hp=0;
				if(x+1<garments.size())
					ht = garments.get(x+1).getHeight();
			}
		}

		window.setSize(adjustedWidth,adjustedHeight);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Pattern getPattern(int width,int height,ArrayList<Pattern> patterns){
		for(Pattern p : patterns){
			if(p.getWidth()==width && p.getHeight()==height)
				return p;
		}
		return null;
	}

	private HashMap<Pattern,Color> makeLegend(ArrayList<Pattern> patterns){
		Color[] colors = {Color.BLUE,Color.CYAN,Color.GREEN,Color.GRAY,Color.YELLOW,Color.RED,Color.PINK,Color.ORANGE,Color.MAGENTA,Color.BLACK};
		HashMap<Pattern,Color> legend = new HashMap<Pattern,Color>();

		int i=0;
		for(Pattern p : patterns){
			legend.put(p,colors[i]);
			i++;
			if(i>=colors.length)
				break;
		}

		return legend;
	}

	private boolean patternFits(int x,int y,int width,int height){
		if(x+width > maxWidth || y+height > maxHeight)
			return false;
		for(int i=y;i<y+height;i++){
			for(int j=x;j<x+width;j++){
				if(board[i][j].used)
					return false;
			}
		}
		return true;
	}

	public void setPattern(int x,int y,int width,int height,Color c){
		//System.out.println("width: "+width);
		//System.out.println("height: "+height);
		for(int i=y;i<y+height;i++){
			for(int j=x;j<x+width;j++){
				board[i][j].body.setBackground(c);
				//top-left corner
				if(i==y&&j==x)
					board[i][j].body.setBorder(BorderFactory.createMatteBorder(1,1,0,0,Color.BLACK));
				//bottom-left corner
				if(i==(y+height-1)&&j==x)
					board[i][j].body.setBorder(BorderFactory.createMatteBorder(0,1,1,0,Color.BLACK));
				//bottom-right corner
				if(i==(y+height-1)&&j==(x+width-1))
					board[i][j].body.setBorder(BorderFactory.createMatteBorder(0,0,1,1,Color.BLACK));
				//top-right corner
				if(i==y&&j==(x+width-1))
					board[i][j].body.setBorder(BorderFactory.createMatteBorder(1,0,0,1,Color.BLACK));

				if(i==y&&j!=x&&j!=(x+width-1))
					board[i][j].body.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.BLACK));
				if(j==x&&i!=y&&i!=(y+height-1))
					board[i][j].body.setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
				if(j==(x+width-1)&&i!=y&&i!=(height+y-1))
					board[i][j].body.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.BLACK));
				if(i==(y+height-1)&&j!=x&&j!=(x+width-1))
					board[i][j].body.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));

				board[i][j].used = true;
			}
		}
	}

	private class cell{
		JPanel body;
		int x;
		int y;
		boolean used;

		cell(int x,int y){
			this.x = x;
			this.y = y;
			this.body = new JPanel();
			this.used = false;
		}
	}
}
