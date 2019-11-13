import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class HShape extends AbstractShape{
	// Arrays for the X and Y values of the top-left corner of each square
	private int[] xNums = {},yNums = {};
	// Size value in pixels of each square in the H
	private int size;
	// Array of H shapes contained within the current H; initially all set to null
	// private HShape[] innerHs = new HShape[7];
	
	// Construct an HShape by populating the fields with given arguments
	public HShape(int x, int y, Color c, int size) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.size = size;
		// Create a temporary array for xNums and yNums to hard-set the values
		// prevents repetition later on
		int[] xTemp = {x,x,x,x+size,x+(2*size),x+(2*size),x+(2*size)};
		this.xNums = xTemp;
		int[] yTemp = {y,y+size,y+(2*size),y+size,y,y+size, y+(2*size)};
		this.yNums = yTemp;
		this.level = 1;
		this.children = new HShape[7];
	}
	
	
	// If the size of a square is greater than 3, check if the H has innerHs and run accordingly
	static boolean addLevel(Shape s) {
		HShape h = (HShape) s;
		if (h.size < 3) {
			return false;
		} else if (h.children[0] == null) {
			// Base case
			// Add children if the current H has none
			h.createChildren();
		} else {
			// If children is populated, try on all the children
			for (int i = 0; i < 7; i++) {
				addLevel(h.children[i]);
			}
		}
		h.level ++;
		return true;
	}
	
	// Method called during base case of addInnerHs
	public void createChildren() {
		// Replace the null H in children[n] with a new H starting at the coordinate of the respective square
		// The size of the squares in the new H will be a third of the original size
		for (int n = 0; n < 7; n++) {
			this.children[n] = new HShape(this.xNums[n],this.yNums[n],this.c,this.size/3);
		}
	}
	
	// Draws H if it has no children, otherwise it calls draw(g) on all the children
	public void draw(Graphics g){
		g.setColor(c);
		// Fills the spaces corresponding to the adequate squares
		if (children[0] == null) {
			for (int i = 0; i < xNums.length; i++) {
				g.fillRect(xNums[i], yNums[i], size, size);
			}
		} else {
			for (int n = 0; n < 7; n++) {
				children[n].draw(g);
			}
		}
	}
	
	
}
