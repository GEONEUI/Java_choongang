package section15;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {

	public static void main(String[] args) {
		Map<Integer ,String> map = new HashMap<Integer ,String>();
		map.put(85 , "신");
		map.put(90 , "김");
		map.put(95 , "이");
		map.put(85 , "박");
		
		System.out.println(map.get(85));
	}

}
