
//implements the logic to calculate the needed statistics
import java.util.ArrayList;

public class MyStatsStrategy implements Stats {
	private Sorter s;

	// set sorting strategy
	public void setSorter(Sorter s) {
		this.s = s;
	}

	public final int count(ArrayList<Integer> arr) {
		return arr.size();
	}

	public final double median(ArrayList<Integer> array) {
		int length = array.size();

		// Sort array -> delegate to strategy
		s.sort(array);

		if (length % 2 == 0) {
			return (array.get(length >> 1) + array.get((length >> 1) - 1)) / 2.;
		} else {
			return array.get(length >> 1);
		}
	}

	public final double mean(ArrayList<Integer> arr) {
		// Compute count
		int count = arr.size();

		// Compute and set the mean
		// uses iterator design pattern
		double sum = 0;
		ListRepo itr = new ListRepo();
		itr.list = arr;
		itr.index = 0;
		for (Iterator iter = itr.getIterator(); iter.hasNext();) {
			sum += (Integer) iter.next();
			itr.index++;
		}

		double mean = sum / count;
		return mean;
	}
}
