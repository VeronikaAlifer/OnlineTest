import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentGroup implements GroupOperationService {

	private Student[] students;
	
	public StudentGroup(int length) {
		students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		if (students == null) {
			throw new IllegalArgumentException();
		}
		
		this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if (student == null || index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		
		students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		
		Student[] newStudents = new Student[students.length + 1];
		newStudents[0] = student;
		
		for (int i = 0; i < students.length; i++) {
			newStudents[i + 1] = students[i];
		}
	}

	@Override
	public void addLast(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		
		Student[] newStudents = new Student[students.length + 1];
		newStudents[students.length] = student;
		
		for (int i = 0; i < students.length; i++) {
			newStudents[i] = students[i];
		}
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		
		students[index] = null;
	}

	@Override
	public void remove(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < students.length; i++) {
			if (students[i].equals(student)) {
				students[i] = null;
			}
		}
	}

	@Override
	public void removeFromIndex(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		
		for (int i = index; i < students.length; i++) {
			students[i] = null;
		}
	}

	@Override
	public void removeFromElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < students.length; i++) {
			if (students[i].equals(student)) {
				removeFromIndex(i);
				break;
			}
		}
	}

	@Override
	public void removeToIndex(int index) {
		if (index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < index; i++) {
			students[i] = null;
		}
	}

	@Override
	public void removeToElement(Student student) {
		if (student == null) {
			throw new IllegalArgumentException();
		}
		
		for (int i = 0; i < students.length; i++) {
			if (students[i].equals(student)) {
				removeToIndex(i);
				break;
			}
		}
	}

	@Override
	public void bubbleSort() {

	}

	@Override
	public Student[] getByBirthDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException();
		}
		
		int count = 0;
		
		for (int i = 0; i < students.length; i++) {
			if (students[i].getBirthDate().equals(date)) {
				count++;
			}
		}
		
		Student[] studentsBorn = new Student[count];
		
		for (int i = 0, j = 0; i < students.length; i++) {
			if (students[i].getBirthDate().equals(date)) {
				studentsBorn[j] = students[i];
				j++;
			}
		}
		
		return studentsBorn;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		return null;
	}

	@Override
	public void add(Student student, int index) {
		if (student == null || index < 0 || index >= students.length) {
			throw new IllegalArgumentException();
		}
		
		Student[] newStudents = new Student[students.length + 1];
		newStudents[index] = student;
		
		for (int i = 0; i < index; i++) {
			newStudents[i] = students[i];
		}
		
		for (int i = index + 1; i < newStudents.length; i++) {
			newStudents[i] = students[i - 1];
		}
	}

	private int getStudentIndex(Student student) {
		return 0;
	}

	private int getDiffYears(Date first, Date last) {
		return 0;
	}

	private Calendar getCalendar(Date date) {
		return null;
	}
}