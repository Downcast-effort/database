package com.dandelion.database.main;

import com.dandelion.database.service.implementation.jdbc.JdbcImpl;
import com.dandelion.database.service.implementation.mybatis.annoationImpl.AnnoationMybatisImpl;
import com.dandelion.database.service.implementation.mybatis.xmlImpl.XmlmybatisImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 方法入口
 * @author dandelion
 * @version 1.0
 * @date 2020/12/29 22:00
 */
@Component
public class startClass implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(startClass.class);

    @Autowired
    private JdbcImpl jdbcDemo_t;

    @Autowired
    private XmlmybatisImpl mybatis_t;

    @Autowired
    private AnnoationMybatisImpl annoationMybatis;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        logger.info("项目启动中---------");

        String [] arg = args.getSourceArgs();
        if (arg.length < 2){
            logger.error("项目启动参数错误：" + arg);
            System.exit(0);
        }
        String dataSourceDealType = arg[0];
        String dataSourceDealWay = arg[1];
        if (StringUtils.isEmpty(dataSourceDealType) || StringUtils.isEmpty(dataSourceDealWay)){
            logger.error("项目启动参数存在空值：" + arg);
            System.exit(0);
        }
        switch (dataSourceDealType){
            case "jdbc":
                if ("selectAll".equals(dataSourceDealWay)){
                    jdbcDemo_t.selectAllUser();
                }
                break;
            case "mybatis-xml":
                if ("ageLarger".equals(dataSourceDealWay)){
                    mybatis_t.selectOneAgeLarger_t(20);
                }
                if ("display".equals(dataSourceDealWay)){
                    mybatis_t.displayTestDaoByPageAccordingSql(1,10);
                }
                break;
            case "mybatis-anno":
                if ("ageLarger".equals(dataSourceDealWay)){
                    annoationMybatis.selectOneAgeLarger_t(20);
                }
                if ("display".equals(dataSourceDealWay)){
                    annoationMybatis.displayTestDaoByPageAccordingSql(1,10);
                }
                break;
            default:
                break;
        }
        System.exit(0);
    }
}
