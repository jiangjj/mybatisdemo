package com.mybatis3.services;

import com.mybatis3.domain.Student;
import com.mybatis3.mappers.StudentMapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import com.mybatis3.util.MyBatisSqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by ubuntu on 17-4-1.
 */
public class StudentService {
    private Logger logger = LoggerFactory.getLogger(getClass());;

    public List<Student> findAllStudents(int offset, int limit) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            RowBounds rowBounds = new RowBounds(offset, limit);
            return studentMapper.findAllStudents(rowBounds);
        } finally {
            sqlSession.close();
        }
    }

    public Student findStudentById(Integer studId) {
        logger.debug("Select Student By Id :{}", studId);
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(studId);
        } finally {
            sqlSession.close();
        }
    }

    public void createStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public int updateStudent(Student student) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int noOfRowsUpdated = studentMapper.updateStudent(student);
            sqlSession.commit();
            return noOfRowsUpdated;
        } finally {
            sqlSession.close();
        }
    }

    public int deleteStudent(int studId) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int noOfRowsDeleted = studentMapper.deleteStudent(studId);
            sqlSession.commit();
            return noOfRowsDeleted;
        } finally {
            sqlSession.close();
        }
    }
}
