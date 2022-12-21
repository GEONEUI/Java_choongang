package section13.page668;

import java.util.ArrayList;
import java.util.List;

public class Course<T> {
	private String name;
	private List<T> students;
	
	public Course(String name) {
		this.name = name;
		this.students = new ArrayList<T>();
		
	}

	public String getName() {
		return name;
	}


	public List<T> getStudents() {
		return students;
	}
	

	@Override
	public String toString() {
		return "Course [name=" + name + ", students=" + students + "]";
	}
	
	

	public void print() {
		System.out.println(this.name +" : [");
		students.stream().forEach(e->System.out.println(e.toString()));
		System.out.println("]");
	}


	
	
}
