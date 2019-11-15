import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class DrawingController implements ActionListener, MouseListener{
	
	private DrawingModel model; // the drawing model the controller is connected to
	private JPanel panel; // get the size of the panel
	
	public DrawingController(DrawingModel model, JPanel panel) {
		this.model = model;
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
		int x = e.getX();
		int y = e.getY();
		model.changeLevel(x, y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("click");

		System.out.println("click");
		model.changeLevel(1, 1);
	}

}
