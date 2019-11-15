import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape{
	private  int quadrant;
	
	private int iteration;

	private int arcX;
	private int arcY;
	
	private int arcSize;
	
	private int angle;
	
	private int nextX, nextY;
	
	
	/**
	 * 
	 */
	
	
	public FibonacciSquare(int x, int y, Color c, int quadrant, int iteration) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.iteration = iteration;
		this.quadrant = quadrant;
		this.size = 2* 10 * FibonacciSequence(this.iteration);
		this.arcSize = 2*this.size;
		this.children = new FibonacciSquare[1];
		updateArc();
		nextCoordinates();
	}
	
	
	/*
	 * Calculate fibonacci number
	 * @param int n
	 * @return fibonacci number
	 */
	
	public int FibonacciSequence(int n) {
			if (n < 0) {
				return -1;
			}
			if (n == 0) {
				return 0;
			}
			if (n == 1) {
				return 1;
			}
			return FibonacciSequence(n - 1) + FibonacciSequence(n - 2);
	}

	/*
	 * update the x and y of "Arc", that location depends on x and y of "Rectangle" and quadrant.
	 * update the angle to draw Arc of the right quadrant.
	 */
	public void updateArc() {
		
		switch (quadrant) {
		
			case 1:
				arcX = x - size;
				arcY = y;
				angle = 0;
				break;
				
			case 2:
				arcX = x;
				arcY = y;
				angle = 90;
				break;
				
			case 3:
				arcX = x;
				arcY = y - size;
				angle = 90 * 2;
				break;
				
			case 4:
				arcX = x - size;
				arcY = y - size;
				angle = 90 * 3;
				break;
				
			default:
				throw new IllegalArgumentException("Quadrant takes only numbers to 4 from 1.");
		}
			
	}
	
	private void nextCoordinates() {
		switch (quadrant) {
		case 1:
			nextX = x - (2 * 10 * FibonacciSequence(iteration+1));
			nextY = y;
			break;
		case 2:
			nextX = x;
			nextY = y + size;
			break;
		case 3:
			if(iteration == 1) {
				nextX = x + size;
				nextY = y;
			} else {
				nextX = x + size ;
				nextY = y - (2 * 10 * FibonacciSequence(iteration+1)) + size;
			}
			break;
		case 4:
			nextX = x - (2 * 10 * FibonacciSequence(iteration+1)) + size; // x = n.x + n.w - w
			nextY = y - (2 * 10 * FibonacciSequence(iteration+1)); // y =
			break;
		}
	}
	
	@Override
	public void createChildren() {
		// (1) privious left upper == last right upper
		// (2) privious left lower == last left upper
			// x  == x
			// y = 
		// (3) privious right lower == last left lower
		// (4) privious right upper == last right lower
		
		switch (quadrant) {
		case 1:
			children[0] = new FibonacciSquare(nextX,nextY,c,2, iteration+1);
			break;
		case 2:
			children[0] = new FibonacciSquare(nextX,nextY,c,3, iteration+1);
			break;
		case 3:
			children[0] = new FibonacciSquare(nextX,nextY,c,4, iteration+1);
			break;
		case 4:
			children[0] = new FibonacciSquare(nextX,nextY,c,1, iteration+1);
			break;
		default:
			children[0] = null;
			break;
			}
	}
	
	@Override
	public boolean criticalCondition() {
		if (nextX>0 && nextY>0 && (nextX + 2* 10 * FibonacciSequence(iteration+1)) < 750 && (nextY + 2* 10 * FibonacciSequence(iteration+1)) < 750) {
			return true;
		}
		return false;
	}

	
	@Override
	public void draw(Graphics g) {
//		recursiveTiles(level,g,limit);
//		updateDrawingParameter();
		g.setColor(c);
		g.drawRect(x, y, size, size);
		g.drawArc(arcX, arcY, arcSize, arcSize, angle, 90);
		
		if (children[0] != null) {
			((FibonacciSquare) children[0]).draw(g);
		}
		
	}


	
}
