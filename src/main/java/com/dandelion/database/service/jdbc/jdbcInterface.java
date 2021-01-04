package com.dandelion.database.service.jdbc;

import com.alibaba.fastjson.JSONArray;

/**
 * @author dandelion
 * @version 1.0
 * @date 2020/12/29 22:10
 */
public interface jdbcInterface {

    public JSONArray selectAllUser();
    public void selectOneAndUpdate(String name);
    public int deleteTest(int ageDif);
    public int insertOne(String name,int age,String address,String sex);

}
