package com.dandelion.database.service.implementation.mybatis.xmlImpl;


import com.dandelion.database.pojo.testDao;
import com.dandelion.database.service.mybatis.mapper.xmlMapper.XmlDaoMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基于xml的mybatis实现类
 * @author dandelion
 * @version 1.0
 * @date 2020/12/30 21:57
 */
@Service
public class XmlmybatisImpl {

    private Logger logger = LoggerFactory.getLogger(XmlmybatisImpl.class);

    @Autowired
    private XmlDaoMapper testDaoMapper_t;

    /**
     * 简单查询
     * @param ageDif
     * @return
     */
    public List<testDao> selectOneAgeLarger_t(int ageDif) {
        List<testDao> selectOneAgeLargerList = testDaoMapper_t.selectOneAgeLarger(ageDif);
        for(testDao tmpTestDao: selectOneAgeLargerList){
            logger.info("查询结果为----->：" + tmpTestDao.toString());
        }
        return selectOneAgeLargerList;
    }

    /**
     * 更新数据
     * @param name
     * @return
     */
    public int updateAddressByName_t(String name) {
        if (StringUtils.isBlank(name)){
            logger.error("名字字段为空：" + name);
            return 0;
        }
        int searchResult = testDaoMapper_t.updateAddressByName(name);
        if (searchResult == 1){
            logger.info("更新地址完成，结果为：" + String.valueOf(searchResult));
            return 1;
        }
        return 0;
    }

    /**
     * 插入数据
     * @param insertDao
     */
    public void insertSomeOne_t(testDao insertDao) {
        if (StringUtils.isNotEmpty(insertDao.toString())){
            testDaoMapper_t.insertSomeOne(insertDao);
        }
    }

    /**
     * 使用sql分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<testDao> displayTestDaoByPageAccordingSql(int pageIndex,int pageSize) {
        List<testDao> resultSub = testDaoMapper_t.displayTestDaoByPage(pageIndex,pageSize);
        for(testDao tmpTestDao: resultSub){
            logger.info("查询结果为----->：" + tmpTestDao.toString());
        }
        return resultSub;
    }


    //基于开源pageHelper的分页技术：https://pagehelper.github.io/docs/
    //TODO

}
