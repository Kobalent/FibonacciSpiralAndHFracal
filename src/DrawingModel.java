import java.util.ArrayList;
import java.util.List;

public class DrawingModel {
	private int state = 1;
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<View> views = new ArrayList<View>();
	
	public boolean changeLevel(int x, int y) {
		/*if (state == 1) {
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
		return false;*/
		shapes.get(0).addLevel();
		shapes.get(1).addLevel();
		
		updateAll();

		return true;
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
