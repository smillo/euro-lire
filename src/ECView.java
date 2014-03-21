import java.awt.*;
import javax.swing.*;

public class ECView extends JPanel implements ECInterfaceView {
	public ECView(EC model) {
		super(new BorderLayout());
		ec = model;

		JPanel panelNorth = new JPanel(new FlowLayout());
		panelNorth.add(new JLabel("Valore da convertire: "));
		inputText = new JTextField("0", 8);
		panelNorth.add(inputText);
		add(panelNorth, BorderLayout.NORTH);

		label = new JLabel("");
		JPanel panelCenter = new JPanel(new FlowLayout());
		panelCenter.add(label);
		add(panelCenter, BorderLayout.CENTER);

		bottoniControllo = new ECControl(ec, this); // passo il modello e la
													// vista (this)
		JPanel panelSouth = new JPanel(new FlowLayout());
		panelSouth.add(bottoniControllo);
		add(panelSouth, BorderLayout.SOUTH);
		setAnswer("No input ...");
		updateView();
	}

	public void updateView() {
		label.setText(answer);
	}

	public String getInput() {
		return inputText.getText();
	}

	public void setAnswer(String val) {
		answer = val;
	}

	public void setError(String err) {
		answer = err + " non e` un double";
	}

	private EC ec;
	private JLabel label;
	private ECControl bottoniControllo;
	private JTextField inputText;
	private String answer;
}
