package Article;

import java.util.ArrayList;
import java.util.List;

public class ArtiEx {
	static List<Article> lst;
	
	public static void main(String[] args) {
		lst = selectAll();
		for (Article art : lst) {
			System.out.println(art);
		}
//		System.out.println(select(2));
	}
	public static List<Article> selectAll() {
		List<Article> lst = new ArrayList<Article>();
		lst.add(new Article(1, "홍길동","제목1", "내용1", 0));
		lst.add(new Article(2, "홍길철","제목2", "내용2", 0));
		lst.add(new Article(3, "홍길순","제목3", "내용3", 0));
//		
		return lst;
	}
	
	public static Article select(int i) {
		return lst.get(i);
//		Article art = lst.get(0);
//		return art;
	}

}




