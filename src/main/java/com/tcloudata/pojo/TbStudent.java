package com.tcloudata.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_student")
public class TbStudent {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "age")
  private long age;
  @Column(name = "birth")
  private Date birth;
  @Column(name = "major")
  private String major;
  @Column(name = "hobby")
  private String hobby;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }


  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

}
