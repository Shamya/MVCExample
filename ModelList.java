
//model to take an ArrayList of integers as input format
import java.util.ArrayList;

public class ModelList extends Model {
	ArrayList<Integer> list;

	ModelList() {
		list = new ArrayList<Integer>();
	}

	public void addElement(Integer a) {
		list.add(a);
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	public Integer getElement(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}

}
