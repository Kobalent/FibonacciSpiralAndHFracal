import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class DrawingModel {
	public int state = 0;
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<View> views = new ArrayList<View>();
	
	public boolean changeLevel(int x, int y) {
		if (state == 1) {
			if (x > 750 && y < 750) {
				return this.shapes.get(1).addLevel();
			} else if (x > 0 && y < 750) {
				return this.shapes.get(0).addLevel();
			}
		} else {
			if (x > 750 && y < 750) {
				return this.shapes.get(1).removeLevel();
			} else if (x > 0 && y < 750) {
				return this.shapes.get(0).removeLevel();
			}
		}
		return false;
		/*shapes.get(0).addLevel();
		shapes.get(1).addLevel();
		
		updateAll();

		return true;*/
	}
	
	public boolean addLevel(int x, int y) {
			if (x > 750 && y < 750) {
				return this.shapes.get(1).addLevel();
			} else if (x > 0 && y < 750) {
				return this.shapes.get(0).addLevel();
			}
		return false;
	}
	
	public boolean removeLevel(int x, int y) {
		if (x > 750 && y < 750) {
			return this.shapes.get(1).removeLevel();
		} else if (x > 0 && y < 750) {
			return this.shapes.get(0).removeLevel();
		}
	return false;
	}
	
	public void reset() {
		this.shapes.set(0, new FibonacciSquare(240, 275, Color.ORANGE, 1, 1));
		this.shapes.set(1, new HShape(800, 50, Color.RED, 200));
		updateAll();
	}
	

	public void addView(View v) {
		views.add(v);
		v.update(this);
	}

	public void updateAll() {
		for (View v : views) {
			v.update(this);
		}
	}

	public void addShape(Shape s) {
		shapes.add(s);
		updateAll();
	}

	public List<Shape> getShapes() {
		return new ArrayList<Shape>(shapes);
	}
}
