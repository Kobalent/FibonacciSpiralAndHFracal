import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			buildGUI();
		});
	}

	private static void buildGUI() {
		JFrame frame = new JFrame();
		frame.setSize(1500, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingView panel = new DrawingView();
		frame.add(panel);

		frame.setVisible(true);

		DrawingModel model = new DrawingModel();
		Shape s = new FibonacciSquare(200, 300, Color.ORANGE, 1, 1);
		model.addShape(s);
		System.out.println(((AbstractShape)s).addLevel());
		System.out.println(((AbstractShape)s).addLevel());
		System.out.println(((AbstractShape)s).addLevel());
		System.out.println(((AbstractShape)s).addLevel());
		System.out.println(((AbstractShape)s).addLevel());
		System.out.println(((AbstractShape)s).addLevel());
		System.out.println(((AbstractShape)s).addLevel());
		System.out.println(((AbstractShape)s).addLevel());
		System.out.println(((AbstractShape)s).addLevel());
		System.out.println(((AbstractShape)s).addLevel());
		model.addView(panel);
		
		Shape h1 = new HShape(85, 80, Color.RED, 120);
		Shape h2 = new HShape(750, 30, Color.GREEN, 10);
		Shape h3 = new HShape(525, 140, Color.GREEN, 15);
		Shape h4 = new HShape(510, 260, Color.GREEN, 40);
//		model.addShape(h1);
		model.addShape(h2);
		model.addShape(h3);
		model.addShape(h4);
		((AbstractShape)h4).addLevel();
		((AbstractShape)h1).addLevel();
		((AbstractShape)h1).addLevel();
		((AbstractShape)h1).addLevel();
		((AbstractShape)h1).addLevel();
		System.out.println(((AbstractShape)h1).addLevel());
		System.out.println("The level of h1 is " + ((HShape) h1).level);
		System.out.println("The level of the sub Hs in h1 is " + ((HShape) ((HShape) h1).children[0]).level);
		((AbstractShape) h1).removeLevel();
		System.out.println("The level of h1 is " + ((HShape) h1).level);
		((AbstractShape) h2).removeLevel();
		
		
	}
}
