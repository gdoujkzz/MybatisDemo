package com.gdou.mes;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class UserMapperTest {

    private SqlSessionFactory factory;

    @Before
    public void SetUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void selectTest() throws Exception {
        SqlSession session = factory.openSession();
        try {
            //查询所有数据
            System.out.println("--------------查询所有数据开始-------------------");
            List<User> list = session.selectList("mapper/TestUserMapper.selectUser");
            for (User user : list) {
                System.out.println(user);
            }
            System.out.println("--------------查询所有数据结束-------------------");
            //查询单条数据
            System.out.println("---------------查询单条数据开始-------------------");
            User user = session.selectOne("mapper/TestUserMapper.selectUserById", 1);
            System.out.println(user);
            System.out.println("---------------查询单条数据结束-------------------");
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            session.close();
        }
    }
}
