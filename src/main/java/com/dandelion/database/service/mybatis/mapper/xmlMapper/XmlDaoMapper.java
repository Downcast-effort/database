package com.dandelion.database.service.mybatis.mapper.xmlMapper;

import com.dandelion.database.pojo.testDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dandelion
 * @version 1.0
 * @date 2020/12/30 22:44
 */

@Repository
public interface XmlDaoMapper {

    /**
     * 实现查询，查询年纪大于25岁的人
     */
    List<testDao> selectOneAgeLarger(@Param("ageDif") Integer ageDif);


    /**
     * 实现更新，更新名字为张某某的地址为甘肃省定西市
     */
    int updateAddressByName(String name);


    /**
     * 插入数据，插入多条，至少十条
     */
    void insertSomeOne(testDao tmpDap);


    /**
     * 分页查询四种方式，使用sql分页
     */
    List<testDao> displayTestDaoByPage(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
}
