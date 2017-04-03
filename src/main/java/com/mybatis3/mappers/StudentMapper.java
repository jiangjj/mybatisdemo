package com.mybatis3.mappers;

import org.apache.ibatis.session.RowBounds;
import com.mybatis3.domain.Student;

import java.util.List;

/**
 * Created by ubuntu on 17-4-1.
 */
public interface StudentMapper {
    List<Student> findAllStudents(RowBounds rowBounds);
    Student findStudentById(Integer id);
    void insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int studId);
}
