import java.util.ArrayList;
import java.util.List;

public class DrawingModel {
	private int state = 1;
	private List<Shape> shapes = new ArrayList<Shape>();
	private List<View> views = new ArrayList<View>();

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
