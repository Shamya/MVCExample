
//composite design pattern for drawing all views, currently buttons and textfield
//aggregation to draw all views
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ComposedView implements View {
	private static JFrame main_frame;
	List<View> view_list = new ArrayList<View>();

	// add views for different statistics
	public void addView(View v) {
		view_list.add(v);
	}

	// draw views for different statistics
	public void draw(JPanel jpStats) {
		for (View v : view_list) {
			v.draw(jpStats);
		}
	}

	public JFrame getMainFrame() {
		return main_frame;
	}

	public static void setMainFrame() {
		if (main_frame == null) {
			main_frame = new JFrame("Simple stats");
			main_frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			main_frame.setSize(600, 400);
			main_frame.setLocationRelativeTo(null);
		}
	}

	public static void setPanelPosition(Component comp, Object layout) {
		if (main_frame != null) {
			main_frame.getContentPane().add(comp, layout);
		}
	}

	public static void makeVisible() {
		if (main_frame != null) {
			main_frame.setVisible(true);
		}
	}

}
