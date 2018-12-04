package com.tcloudata.service.impl;

import com.tcloudata.dao.StudentRepository;
import com.tcloudata.pojo.TbStudent;
import com.tcloudata.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "student")
public class StudentServiceImpl implements StudentService {
    private static final Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<TbStudent> findAll() {
        return studentRepository.findAll();
    }

    //将缓存保存进andCache，并当参数title的长度小于32时才保存进缓存，默认使用参数值及类型作为缓存的key
    @Cacheable(value="andCache",condition="#title.length >5")
    @Override
    public TbStudent findByName(String name) {
        return studentRepository.findByName(name);
    }

    //将缓存保存进andCache，并使用参数中的bid加上一个字符串(这里使用方法名称)作为缓存的key
    @Cacheable(value="andCache",key="#bid+'findById'")
    @Override
    public TbStudent findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void saveStudent(TbStudent student) {

    }

    //清除掉指定key中的缓存
    @CacheEvict(value="andCache",key="#book.id + 'findById'")
    @Override
    public void modifyStudent(TbStudent student) {
        logger.info("清除指定缓存"+student.getId()+"findById");
        studentRepository.save(student);
    }

    //清除掉全部缓存
    @CacheEvict(value="andCache",allEntries=true,beforeInvocation=true)
    public void ReservedBook() {
        logger.info("清除全部的缓存");
    }

}
