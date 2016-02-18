import java.util.ArrayList;
import java.util.Collections;

//one example implementation of sorter interface
public class MySorter implements Sorter {
	public void sort(ArrayList<Integer> array) {
		Collections.sort(array);
	}
}
