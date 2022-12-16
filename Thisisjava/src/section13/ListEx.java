package section13;

import java.util.ArrayList;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {
		List<Integer> list2 = new ArrayList<Integer>();
		
		List list = new ArrayList();
		list.add("hello");
		
		String str = (String) list.get(0);
		
		System.out.println(str);
		
	}

}
