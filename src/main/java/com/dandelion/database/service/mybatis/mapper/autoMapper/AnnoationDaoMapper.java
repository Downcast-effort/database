package com.dandelion.database.service.mybatis.mapper.autoMapper;

import com.dandelion.database.pojo.testDao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 基于注解的mybatis操作
 * @author dandelion
 * @version 1.0
 * @date 2021/1/2 23:52
 */

@Repository
public interface AnnoationDaoMapper {


    /**
     * 实现查询，查询年纪大于25岁的人
     */
    @Select("SELECT * FROM  test WHERE age>#{ageDif}")
    List<testDao> selectOneAgeLarger(@Param("ageDif") Integer ageDif);


    /**
     * 实现更新，更新名字为张某某的地址为甘肃省定西市
     */
    @Update("UPDATE test SET address='江苏省宿迁市' WHERE name=#{name}")
    int updateAddressByName(String name);


    /**
     * 插入数据，插入多条，至少十条
     */
    @Insert("INSERT INTO test(id,name,address,age,sex) VALUES (#{id},#{name},#{address},#{age},#{sex})")
    void insertSomeOne(testDao tmpDap);


    /**
     * 分页查询四种方式，使用sql分页
     */
    @Select("SELECT * FROM test LIMIT #{pageIndex},#{pageSize}")
    List<testDao> displayTestDaoByPage(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

}
