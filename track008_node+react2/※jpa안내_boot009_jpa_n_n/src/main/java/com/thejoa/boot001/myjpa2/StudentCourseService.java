package com.thejoa.boot001.myjpa2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentCourseService {
	private final StudentRepository   studentRepository;
	private final CourseRepository   courseRepository;
	
	@Autowired
	public StudentCourseService(StudentRepository studentRepository, CourseRepository courseRepository) {
		super();
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}
	
    @Transactional
    public void addStudentWithCourse(  Long userId, Long courseId) {
    	Student student = studentRepository.findById(userId).orElseThrow(()-> new RuntimeException("사용자 없음"));
    	Course  course  = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("코스 없음"));
		
        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student); // 학생 저장
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll(); // 모든 학생 조회
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id); // 특정 학생 조회
    }
    
    @Transactional
    public void updateStudent(Long id, String newName) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("학생을 찾을 수 없음"));
        student.setName(newName); // 이름 변경
        studentRepository.save(student); // 변경된 값 저장
    }
    
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}


