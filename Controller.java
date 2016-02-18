
//uses strategy pattern for implementing the statistics
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	static ActionListener ResetAll = new ActionListener() {
		// The interface ActionListener defines a call-back method
		// actionPerformed,
		// which is invoked if the user interacts with the GUI component -- in
		// this
		// case, if the user clicks the button.
		public void actionPerformed(ActionEvent e) {
			// Clear the ArrayList and all text fields
			Good.mod.getList().clear();
			Good.txtip.setText("");
			Good.txtnum.setText("");
			Good.txtmean.setText("");
			Good.txtmed.setText("");
			Good.txtarea.setText("");
		}
	};

	static ActionListener AddNumbers = new ActionListener() {
		// The interface ActionListener defines a call-back method
		// actionPerformed,
		// which is invoked if the user interacts with the GUI component -- in
		// this
		// case, if the user clicks the button.
		public void actionPerformed(ActionEvent e) {
			if (Good.txtip.getText() != null && !Good.txtip.getText().isEmpty()) {
				try {
					Integer num = Integer.parseInt(Good.txtip.getText());

					Good.mod.addElement(num);
					Good.txtarea.append(num + ",");

					MyStatsStrategy stat = new MyStatsStrategy();
					Sorter srt = new MySorter();

					// set the count
					int count = stat.count(Good.mod.list);
					Good.txtnum.setText("" + count);

					// set the mean
					// uses iterator design pattern
					double mean = stat.mean(Good.mod.list);
					;
					Good.txtmean.setText("" + mean);

					// set the median
					// use strategy design pattern
					double med;
					stat.setSorter(srt);
					med = stat.median(Good.mod.list);
					Good.txtmed.setText("" + med);
				} catch (NumberFormatException e1) {
					System.out.println("too large input");
				}
			}
		}
	};
}
