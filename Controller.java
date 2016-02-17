//uses strategy pattern for implementing the statistics
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	static ActionListener ResetAll = new ActionListener(){
    	// The interface ActionListener defines a call-back method actionPerformed,
        // which is invoked if the user interacts with the GUI component -- in this
        // case, if the user clicks the button.
        public void actionPerformed(ActionEvent e) {
            // Clear the ArrayList and all text fields
            Good.mod.getList().clear();
        	Good.txtip.setText("");
        	Good.txtnum.setText("");
        	Good.txtmean.setText("");
        	Good.txtmed.setText("");
        	Good.txtarea.setText("");
        	//ADD TXT AREA..
        }
    };
    
    static ActionListener AddNumbers = new ActionListener(){
    	// The interface ActionListener defines a call-back method actionPerformed,
        // which is invoked if the user interacts with the GUI component -- in this
        // case, if the user clicks the button.
        public void actionPerformed(ActionEvent e) {
        	Integer num = Integer.parseInt(Good.txtip.getText());
        	Good.mod.addElement(num);
        	Good.txtarea.append(num + ",");
        	
        	// Compute and set the count
        	int count = Good.mod.size();
        	Good.txtnum.setText("" + count);
        	
            // Compute and set the mean
            double sum = 0;
            for (Object value : Good.mod.list) {
                sum += (Integer)value;
            }
            
            double mean = sum / count;
            Good.txtmean.setText("" + mean);

            //Compute and set the median
            //use strategy design pattern
            double med;
           // if(Good.mod.list.size() < 2){
           // 	med = Good.mod.list.get(0);
            //}
            //else{
            	MyStatsStrategy stat = new MyStatsStrategy();
            	Sorter srt = new MySorter();
            	stat.setSorter(srt);
            	med = stat.median(Good.mod.list);
            //}
            Good.txtmed.setText("" + med);
            
        }
    };
}
