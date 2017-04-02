package org.mybatis.mappers;

import org.mybatis.domain.Student;

import java.util.List;

/**
 * Created by ubuntu on 17-4-1.
 */
public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(Integer id);
    void insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int studId);
}
