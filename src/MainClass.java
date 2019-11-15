import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class MainClass {
	
	
	static JRadioButton addLevel, removeLevel;
	
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
		panel.setLayout(null);
		frame.add(panel);
		
		JButton button = new JButton("Reset");
		addLevel = new JRadioButton();
		addLevel.setText("Add a Level");
		addLevel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		addLevel.setBackground(Color.WHITE);
		removeLevel = new JRadioButton();
		removeLevel.setText("Remove a Level");
		removeLevel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		removeLevel.setBackground(Color.WHITE);
		ButtonGroup g1 = new ButtonGroup();
		g1.add(addLevel);
		g1.add(removeLevel);
		addLevel.setSelected(true);
		button.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		JPanel southPanel = new JPanel();
		southPanel.add(button);
		southPanel.add(addLevel);
		southPanel.add(removeLevel);
		southPanel.setBackground(Color.WHITE);
		
		

		frame.setVisible(true);

		DrawingModel model = new DrawingModel();
		Shape s = new FibonacciSquare(240, 275, Color.ORANGE, 1, 1);
		model.addShape(s);
//		s.addLevel();
//		s.addLevel();
//		s.addLevel();
//		s.addLevel();
//		s.addLevel();
//		s.addLevel();
//		s.addLevel();
		model.addView(panel);
		
		Shape h = new HShape(800, 50, Color.RED, 200);
		model.addShape(h);
//		h.addLevel();
//		h.addLevel();
//		System.out.println(h.addLevel());
//		System.out.println("The level of h is " + h.getLevel());
//		System.out.println(h.addLevel());
//		System.out.println("The level of h is " + h.getLevel());
//		System.out.println(h.addLevel());
//		System.out.println("The level of h is " + h.getLevel());
//		System.out.println(h.addLevel());
//		System.out.println("The level of h is " + h.getLevel());
//		System.out.println(h.addLevel());
//		System.out.println("The level of h is " + h.getLevel());
//		System.out.println("The level of the sub Hs in h1 is " + ((AbstractShape) h).children[0].getLevel());
//		h.removeLevel();
//		System.out.println("The level of h1 is " + h.getLevel());
//		h.addLevel();
		
		DrawingController controller = new DrawingController(model,panel);
		frame.add(southPanel,BorderLayout.SOUTH);
		button.addActionListener(controller);
		panel.addMouseListener(controller);
		
		
	}
}
