package com.gaochao.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gaochao.bean.Employee;

public class MyBatisTest {

	private static final Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象 有数据源一些运行环境信息
	 * 2、sql映射文件；配置了每一个sql，以及sql的封装规则等。 
	 * 3、将sql映射文件注册在全局配置文件中
	 * 4、写代码：
	 * 		1）、根据全局配置文件得到SqlSessionFactory；
	 * 		2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
	 * 			一个sqlSession就是代表和数据库的一次会话，用完关闭
	 * 		3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
	 * 
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException{
		// 2、获取sqlSession实例，能直接执行已经映射的sql语句
				// sql的唯一标识：statement Unique identifier matching the statement to use.
				// 执行sql要用的参数：parameter A parameter object to pass to the statement.
				SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
				SqlSession openSession = sqlSessionFactory.openSession();
				try {
					Employee employee = openSession.selectOne(
							"getEmpById", 1);
					logger.info("employee id is {} ", employee.getId());
					//System.out.println(employee);
				} finally {
					openSession.close();
				}
	}
}
