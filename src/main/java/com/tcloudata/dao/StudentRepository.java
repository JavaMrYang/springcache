package com.tcloudata.dao;

import com.tcloudata.pojo.TbStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<TbStudent,Long> {
    @Override
    List<TbStudent> findAll();

    @Query("select s from TbStudent s where id=?1")
    TbStudent findById(Long id);

    TbStudent findByName(String name);

    @Query(value = "select count(*) from TbStudent ",nativeQuery = true)
    int countStudent();
}
