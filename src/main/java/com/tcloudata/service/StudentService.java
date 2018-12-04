package com.tcloudata.service;

import com.tcloudata.pojo.TbStudent;

import java.util.List;

public interface StudentService {
    List<TbStudent> findAll();

    TbStudent findByName(String name);

    TbStudent findById(Long id);

    void saveStudent(TbStudent student);

    void modifyStudent(TbStudent student);
}
