package section13;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("자바");
		list.add("JDBC");
		list.add("Mysql");
		
		System.out.println(list.get(0));
		
		
		for(String str : list) {
			System.out.println(str);
		}
		
		String[] aa = {"자바","JDBC","Mysql"};

		
	}

}
