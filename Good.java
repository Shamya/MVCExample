import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Assignment 2:
 *
 * This implementation fixes the violations of design principles, makes the code extensible,
 * and its components can be tested in isolation. 
 */
public class Good {
	static TextField txtip;
	static Button btnadd;
	static Button btnreset;
	static TextField txtnum;
	static TextField txtmean;
	static TextField txtmed;
	static JTextArea txtarea;
	static ModelList mod;

	public static void main(String... args) {
		/**
		 * A simple GUI that includes: - a text field and a button that
		 * allows the user to enter numbers. - a button that allows the user to
		 * clear all entered numbers. - a panel with labels and text fields for
		 * count, median, and mean. - a text area that shows all numbers.
		 */
		// Create the main frame of the application, and set size and position

		txtip = new TextField("", true);
		btnadd = new Button("Add number");
		btnreset = new Button("Reset");
		txtnum = new TextField("Numbers:", false);
		txtmean = new TextField("Mean:", false);
		txtmed = new TextField("Median:", false);
		mod = new ModelList();
		txtarea = new JTextArea(10, 50);
		txtarea.setEditable(false);

		// uses composite pattern for view
		// add required statistics
		ComposedView cvip = new ComposedView();
		ComposedView.setMainFrame();

		// Panel that lets user input numbers
		JPanel jpInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cvip.addView(txtip);
		cvip.addView(btnadd);
		cvip.addView(btnreset);
		cvip.draw(jpInput);
		ComposedView.setPanelPosition((Component) jpInput, (Object) BorderLayout.NORTH);

		ComposedView.setPanelPosition((Component) txtarea, (Object) BorderLayout.SOUTH);
		
		// Panel that shows stats about the numbers
		ComposedView cvstat = new ComposedView();
		JPanel jpStats = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cvstat.addView(txtnum);
		cvstat.addView(txtmean);
		cvstat.addView(txtmed);
		cvstat.draw(jpStats);
		ComposedView.setPanelPosition((Component) jpStats, (Object) BorderLayout.CENTER);

		ComposedView.makeVisible();

		btnreset.OnClickListener(Controller.ResetAll);
		btnadd.OnClickListener(Controller.AddNumbers);

	}
}
