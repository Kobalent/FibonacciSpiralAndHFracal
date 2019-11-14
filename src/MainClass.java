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
		Shape s = new FibonacciSquare(240, 275, Color.ORANGE, 1, 1);
		model.addShape(s);
		s.addLevel();
		s.addLevel();
		s.addLevel();
		s.addLevel();
		s.addLevel();
		s.addLevel();
		s.addLevel();
		model.addView(panel);
		
		Shape h = new HShape(800, 50, Color.RED, 200);
		model.addShape(h);
		h.addLevel();
		h.addLevel();
		System.out.println(h.addLevel());
		System.out.println("The level of h is " + h.getLevel());
		System.out.println(h.addLevel());
		System.out.println("The level of h is " + h.getLevel());
		System.out.println(h.addLevel());
		System.out.println("The level of h is " + h.getLevel());
		System.out.println(h.addLevel());
		System.out.println("The level of h is " + h.getLevel());
		System.out.println(h.addLevel());
		System.out.println("The level of h is " + h.getLevel());
		System.out.println("The level of the sub Hs in h1 is " + ((AbstractShape) h).children[0].getLevel());
		h.removeLevel();
		System.out.println("The level of h1 is " + h.getLevel());
		h.addLevel();
		
		
	}
}
