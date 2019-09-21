package com.xueyou.scorpio.mybatis;

import com.xueyou.scorpio.mybatis.masterdao.StudentDao;
import com.xueyou.scorpio.mybatis.pojo.Student;
import com.xueyou.scorpio.mybatis.slavedao.StudentNewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MybatisSimpleCheckController {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudentNewDao studentNewDao;

    @RequestMapping(value = "/mybatistest", method = RequestMethod.GET)
    public String mybatisTest() {
        return studentDao.getById(1).toString();
    }


    @RequestMapping(value = "/mybatistest2", method = RequestMethod.GET)
    public String mybatisTest2() {
        return studentNewDao.getById(1).toString();
    }

}
