package section13;

import java.util.ArrayList;

public class StudentsEx {

	public static void main(String[] args) {
		ArrayList<Student> stulist = new ArrayList<Student>();
		
		stulist.add(new Student(16, "유건의", "20120314", "인천"));
		stulist.add(new Student(25, "하세", "20132154", "서울"));
		stulist.add(new Student(2, "요요", "20132154", "서울"));
		
		
		Student[] stu = {
				 new Student(16, "유건의", "20120314", "인천"),
				 new Student(25, "하세", "20132154", "서울"),
				 new Student(2, "요요", "20132154", "서울")
		};
		
		
		System.out.println(stulist.get(0));
		
		
		System.out.println(stu[0].hakbun);
		
		
		


	}

}
