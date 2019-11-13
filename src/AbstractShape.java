import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class AbstractShape implements Shape{
	protected int x, y;
	protected Color c;
	protected Shape[] children;
	public int level;
	public boolean canAddLevel = true;
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Shape deepCopy() {
		return this; // Placeholder; Remove
	}
	
	public static boolean removeLevel(Shape s) {
		AbstractShape a = (AbstractShape) s;
		
		// cannot remove level if level = 1
		if (a.level == 1) {
			return false;
		}
		
		// base case
		// if the shape's level is 2, set all the children to null and decrease the level
		else if (a.level == 2) {
			for (int i = 0; i< a.children.length; i++) {
				((AbstractShape) s).children[i] = null;
			}
			((AbstractShape) s).level --;
		}
		
		// if the shape is any level higher than 2
		// run the removeLevel on all its children
		else {
			for (int i = 0; i < a.children.length; i++) {
				removeLevel(((AbstractShape) s).children[i]);
			}
			((AbstractShape) s).level --;
		}
		
		// return true if shape is not level 1
		return true;
		
	}
}
