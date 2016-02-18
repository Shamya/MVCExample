
//implements view interface for textfield
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextField implements View {

	private String label;
	private boolean editable;
	private JTextField jtf;

	TextField(String label_name, boolean editable) {
		this.label = label_name;
		this.editable = editable;
		this.jtf = new JTextField(5);
	}

	public void draw(JPanel jpstats) {
		jtf.setEditable(this.editable);
		jpstats.add(new JLabel(this.label));
		jpstats.add(jtf);
	}

	public void setText(String text) {
		jtf.setText(text);
	}

	public String getText() {
		return jtf.getText();
	}
}
