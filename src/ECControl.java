import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ECControl extends JPanel implements ActionListener {
	private EC ec;
	private ECInterfaceView ecVista;
	private JButton euroButton;
	private JButton lireButton;

	public ECControl(EC ec, ECInterfaceView ecVista) {
		super(new FlowLayout());
		this.ec = ec;
		this.ecVista = ecVista;
		euroButton = new JButton("Euro");
		add(euroButton);
		euroButton.addActionListener(this);
		lireButton = new JButton("Lire");
		add(lireButton);
		lireButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		try {
			double input = Double.parseDouble((ecVista.getInput()).trim());
			String answer = "Valore ";
			if (source == euroButton)
				answer = answer + "in Euro: " + ec.fromLireToEuro(input);
			else
				answer = answer + "in Lire: " + ec.fromEuroToLire(input);
			ecVista.setAnswer(answer);
		} catch (RuntimeException err) {
			ecVista.setError(err.getMessage());
		}
		ecVista.updateView();
	}
}
