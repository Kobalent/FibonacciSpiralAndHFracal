import java.awt.Color;
import java.awt.Graphics;

public class HShape extends AbstractShape{
	// Arrays for the X and Y values of the top-left corner of each square
	private int[] xNums = {},yNums = {};
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
		this.children = new HShape[7];
	}
	
	public boolean criticalCondition() {
		if (size < 3) {
			return false;
		} else {
			return true;
		}
	}
	
	// Method called during base case of AbstractShape.addLevel()
	public void createChildren() {
		// Replace the null H in innerHs[n] with a new H starting at the coordinate of the respective square
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
