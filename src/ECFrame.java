import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ECFrame extends JFrame {
	public ECFrame() {
		ecModello = new EC();
		ecVista = new ECView(ecModello);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(ecVista, BorderLayout.CENTER);
		cp.add(new ExitButton(), BorderLayout.SOUTH);
		addWindowListener(new ExitFrame());
		setTitle("Euro-Lire Converter");
		setSize(320, 160);
		setVisible(true);
	}

	public static void main(String[] args) {
		ECFrame frame = new ECFrame();
	}

	private EC ecModello;
	private ECView ecVista;
}

class ExitFrame extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

class ExitButton extends JButton implements ActionListener {
	public ExitButton() {
		super("Exit");
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
