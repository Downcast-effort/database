package com.dandelion.database.service.implementation.jdbc;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dandelion.database.pojo.testDao;
import com.dandelion.database.service.jdbc.jdbcInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1、查询表中所有记录以json的格式返回；
 * 2、查询表中名字为张某某的user,并将其地址改为江苏省南京市
 * 3、删除表中年纪小于24岁的user;
 * 4、增加一条数据，名字：dandelion,年纪：24，性别：男，地址：江苏省南京市
 */


/**
 * @author dandelion
 * @version 1.0
 * @date 2020/12/28 22:15
 */


@Service
public class JdbcImpl implements jdbcInterface {
    private Logger log = LoggerFactory.getLogger(JdbcImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 上述需求1
     * @return
     */
    @Override
    public JSONArray selectAllUser(){
        String sqlStr = "select * from test";
        JSONArray resultJsonArray = new JSONArray();

        try{
            RowMapper<testDao> rowMapper = new BeanPropertyRowMapper(testDao.class);
            List<testDao> queryResult = jdbcTemplate.query(sqlStr, rowMapper);
            for (testDao tt: queryResult) {
                JSONObject tmpJSONObject = dealToJSONObject(tt);
                if (!resultJsonArray.contains(tmpJSONObject)){
                    resultJsonArray.add(tmpJSONObject);
                }
            }
        }catch (Exception e){
            log.error("查询发生异常" + e.getMessage());
        }
        log.info("查询结果为：" + resultJsonArray.toJSONString());
        return resultJsonArray;
    }

    /**
     * 上述需求2
     * @param name
     */
    @Override
    public void selectOneAndUpdate(String name){
        try{
            RowMapper<testDao> rowMapper = new BeanPropertyRowMapper(testDao.class);
            testDao queryResult = jdbcTemplate.queryForObject("select * from test where name=?", rowMapper,name);
            int result = jdbcTemplate.update("update test set address='江苏省南京市' where name=?" +queryResult.getName());
            if (result == 1){
                log.info("查询更新成功！！！");
            }
        }catch (Exception e){
            log.error("查询发生异常" + e.getMessage());
        }
    }

    /**
     *上述需求3
     * @param ageDif
     * @return
     */
    @Override
    public int deleteTest(int ageDif){
        try{
            return jdbcTemplate.update("delete from test where age <=?",24);
        }catch (Exception e){
            log.error("查询发生异常" + e.getMessage());
        }
        return 0;
    }

    /**
     * 上述需求4
     * @param name
     * @param age
     * @param address
     * @param sex
     * @return
     */
    @Override
    public int insertOne(String name,int age,String address,String sex){
        try{
            return jdbcTemplate.update("insert into test(name,age,sex,address) values(?,?,?,?)",name,age,sex,address);
        }catch (Exception e){
            log.error("查询发生异常" + e.getMessage());
        }
        return 0;
    }

    /**
     * 将dao层对象转换成jsonobject
     * @param tt
     * @return
     */
    public JSONObject dealToJSONObject(testDao tt){
        JSONObject middleJSONObject = new JSONObject();
        middleJSONObject.put("id",tt.getId());
        middleJSONObject.put("name",tt.getName());
        middleJSONObject.put("address",tt.getAddress());
        middleJSONObject.put("age",tt.getAge());
        middleJSONObject.put("sex",tt.getSex());
        return middleJSONObject;
    }




}
