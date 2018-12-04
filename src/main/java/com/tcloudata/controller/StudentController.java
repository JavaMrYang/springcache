package com.tcloudata.controller;

import com.tcloudata.pojo.TbStudent;
import com.tcloudata.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping("/{id}")
    public @ResponseBody
    TbStudent index(@PathVariable("id") Long id){
        TbStudent b = studentService.findById(id);
        log.info(b.getId()+"------>"+b.getName());
        return b;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public  @ResponseBody
    List<TbStudent> list(){
        List<TbStudent> b = studentService.findAll();
        return  b;

    }
    @RequestMapping(value = "/add")
    public String  insertBook(){
        TbStudent b = new TbStudent();
        b.setId(4);
        b.setName("dfsf");
        b.setAge(25);
        studentService.saveStudent(b);
        return "success";

    }
    /**
     * 更新
     * @return
     */
    @RequestMapping(value = "/update")
    public String update(){
       TbStudent stu=new TbStudent();
       stu.setId(1);
       stu.setAge(23);
       stu.setName("哈迪斯");
       studentService.saveStudent(stu);
       return "success";
    }

}
