
//implements methods needed for iteration
import java.util.ArrayList;

public class ListRepo implements Container {

	public ArrayList<Integer> list;
	public int index;

	@Override
	public Iterator getIterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator {

		public boolean hasNext() {

			if (index < list.size()) {
				return true;
			}
			return false;
		}

		public Object next() {

			if (this.hasNext()) {
				return list.get(index);
			}
			return null;
		}
	}
}