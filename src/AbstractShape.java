import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractShape implements Shape{
	protected int x, y;
	protected int size;
	protected Color c;
	protected Shape[] children;
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Shape deepCopy() {
		return this; // Placeholder; Remove
	}
	
	public boolean addLevel() {
		if (!this.criticalCondition()) {
			return false;
		}
		if (this.children[0] == null) {
			// Base case
			// Add children if the current shape has none
			this.createChildren();
			
		} else {
			// If children array is populated, try on all the children
			for (int i = 0; i < this.children.length; i++) {
				if(!((AbstractShape) this.children[i]).addLevel()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean removeLevel() {
		
		// cannot remove level if level = 1
		if (this.getLevel() == 1) {
			return false;
		}
		
		// base case
		// if the shape's level is 2, set all the children to null and decrease the level
		else if (this.getLevel() == 2) {
			for (int i = 0; i< this.children.length; i++) {
				this.children[i] = null;
			}
		}
		
		// if the shape is any level higher than 2
		// run the removeLevel on all its children
		else {
			for (int i = 0; i < this.children.length; i++) {
				((AbstractShape)this.children[i]).removeLevel();
			}
		}
		
		// return true if shape is not level 1
		return true;
		
	}
	
	public int getLevel() {
		if (this.children[0] == null) {
			return 1;
		} else {
			return ((AbstractShape) this.children[0]).getLevel() + 1;
		}
	}
}
