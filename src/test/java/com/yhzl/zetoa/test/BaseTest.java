package com.yhzl.zetoa.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @RunWith 指定运行环境
 * @ContextConfiguration 读取配置文件
 * @Transactional 开启事务，默认回滚测试数据
 * @author chsm
 * @date 2018年5月27日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
public class BaseTest {

}
