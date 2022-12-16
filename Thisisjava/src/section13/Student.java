package section13;

import java.util.ArrayList;
import java.util.List;

public class Student {
	int id;
	String name;
	String hakbun;
	String addr;
	
	
	public Student() {
		
	}

	
	public Student(int id, String name, String hakbun, String addr) {
		this.id = id;
		this.name = name;
		this.hakbun = hakbun;
		this.addr = addr;
	}
	
	



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", hakbun=" + hakbun + ", addr=" + addr + "]";
	}


	public static void main(String[] args) {
		List<Student> stu = new ArrayList<Student>();
		
	} 
}
