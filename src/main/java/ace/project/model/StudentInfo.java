package ace.project.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentInfo {
	private List<Student>studentList = new ArrayList<>();
	
	public void addStudent(Student student) {
		this.studentList.add(student);
	}
}
