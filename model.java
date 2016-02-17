//model to take any input format
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class model {
	ArrayList<Integer> list;
	model(){
		list = new ArrayList<Integer>();
	}
	
	public void addElement(Integer a){
		list.add(a);
	}
	
	public ArrayList<Integer> getList(){
		return list;
	}
	
	public int size(){
		return list.size();
	}
	
}
