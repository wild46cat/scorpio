package com.xueyou.scorpio.mybatis.slavedao;


import com.xueyou.scorpio.mybatis.pojo.Student;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface StudentNewDao {
    List<Student> getAll();

    Student getById(int id);

    List<Student> getByNameLike(String name);

    Student getByIdAndName(Student student);

    Student getByIdAndNameWithParamMap(HashMap<String, Object> params);

    List<Student> getByCreateTime(Date date);

    int insertStudent(Student student);

    int deleteById(Student student);
}
