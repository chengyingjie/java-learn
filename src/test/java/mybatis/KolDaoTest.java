package mybatis;

import com.jesse.learn.mybatis.demo.KolDO;
import com.jesse.learn.mybatis.demo.KolDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class KolDaoTest {

    @Test
    public void findUserById() {
        // 参考：https://www.cnblogs.com/dongying/p/4031382.html
        SqlSession sqlSession = getSessionFactory().openSession();
        KolDao kolDao = sqlSession.getMapper(KolDao.class);
        KolDO kolDO = kolDao.getKolById(1L);
        Assert.assertNotNull("没找到数据", kolDO.getName());

        Map<String, String> map = new HashMap<>();
        map.put("aaa", "bbb");
    }

    // Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {

        SqlSessionFactory sessionFactory = null;
        String resource = "mybatis-config.xml";

        try {
            // Resources: MyBatis提供的加载资源文件的工具类
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sessionFactory;
    }
}
