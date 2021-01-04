package com.dandelion.database.pojo;

/**
 * @author dandelion
 * @version 1.0
 * @date 2020/12/28 22:11
 */
public class testDao {
    //自增id
    private Integer id;
    //名字
    private String name;
    //地址
    private String address;
    //年龄
    private int age;
    //性别
    private String sex;

    public testDao(){

    }

    public testDao(Integer id, String name, String address, int age, String sex) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "testDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

