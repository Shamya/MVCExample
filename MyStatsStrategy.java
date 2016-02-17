//implements stats using sort from strategy pattern
import java.util.ArrayList;

public class MyStatsStrategy implements Stats{
private Sorter s;
	
	//set sorting strategy
	 public void setSorter(Sorter s) {
	        this.s = s;
	    }
	 public final double median(ArrayList<Integer> array){
	        int length = array.size();

	        // Sort array -> delegate to strategy
	        s.sort(array);

	        if (length%2 == 0) {
	            return (array.get(length >> 1) + array.get((length >> 1) - 1)) / 2.;
	        } else {
	            return array.get(length >> 1);
	        } 
	    }    

}
