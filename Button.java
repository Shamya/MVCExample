
//Button class implementing view for buttons 
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class Button implements View {

	private String name;
	JButton jb;

	Button(String name) {
		this.name = name;
		jb = new JButton(this.name);
	}

	public void draw(JPanel jpstats) {
		jpstats.add(jb);
	}

	public void OnClickListener(ActionListener aw) {
		jb.addActionListener(aw);
	}
}
