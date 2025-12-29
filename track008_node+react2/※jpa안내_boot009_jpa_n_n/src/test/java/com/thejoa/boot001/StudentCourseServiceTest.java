package com.thejoa.boot001;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa.boot001.myjpa2.Course;
import com.thejoa.boot001.myjpa2.CourseRepository;
import com.thejoa.boot001.myjpa2.Student;
import com.thejoa.boot001.myjpa2.StudentCourseService;
import com.thejoa.boot001.myjpa2.StudentRepository;

@SpringBootTest
class StudentCourseServiceTest {

    @Autowired private StudentRepository studentRepository;

    @Autowired private CourseRepository courseRepository;

    @Autowired private StudentCourseService studentCourseService;

    @Test  @Transactional   @Commit  // 트랜잭션 롤백을 방지하여 DB에 반영
    void testAddStudentWithCourse() {
        Student student = new Student();
        student.setName("테스트 학생");
        student = studentRepository.save(student);
        studentRepository.flush();  // 변경 사항 즉시 반영

        Course course = new Course();
        course.setTitle("코스 제목");
        course.setContent("코스 내용");
        course = courseRepository.save(course);
        courseRepository.flush();

        studentCourseService.addStudentWithCourse(student.getId(), course.getId());

        Optional<Student> updatedStudent = studentRepository.findById(student.getId());
        assertTrue(updatedStudent.isPresent());
        assertTrue(updatedStudent.get().getCourses().contains(course));
    }

    @Disabled @Test
    void testGetAllStudents() {
        assertNotNull(studentCourseService.getAllStudents());
    }

    @Disabled  @Test
    void testGetStudentById() {
        Student student = new Student();
        student.setName("테스트 학생");
        student = studentRepository.save(student);
        studentRepository.flush();

        Optional<Student> foundStudent = studentCourseService.getStudentById(student.getId());
        assertTrue(foundStudent.isPresent());
        assertEquals("테스트 학생", foundStudent.get().getName());
    }

    @Disabled  @Test    @Transactional   @Commit
    void testUpdateStudent() {
        Student student = new Student();
        student.setName("초기 이름");
        student = studentRepository.save(student);
        studentRepository.flush();

        studentCourseService.updateStudent(student.getId(), "변경된 이름");

        Optional<Student> updatedStudent = studentRepository.findById(student.getId());
        assertTrue(updatedStudent.isPresent());
        assertEquals("변경된 이름", updatedStudent.get().getName());
    }

    @Disabled  @Test    @Transactional   @Commit
    void testDeleteStudent() {
        Student student = new Student();
        student.setName("삭제될 학생");
        student = studentRepository.save(student);
        studentRepository.flush();

        studentCourseService.deleteStudent(student.getId());

        Optional<Student> deletedStudent = studentRepository.findById(student.getId());
        assertFalse(deletedStudent.isPresent());
    }
}