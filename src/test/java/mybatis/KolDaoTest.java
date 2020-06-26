package mybatis;

import com.jesse.learn.mybatis.demo.KolDO;
import com.jesse.learn.mybatis.demo.KolDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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


    public static void main(String[] args) {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.put("d", "dd");
        map.put("e", "ee");
        map.put("f", "ff");
        map.put("g", "gg");
        map.put("h", "hh");
        map.put("i", "ii");
        map.put("j", "jj");

        map.put("k", "11");
        map.put("l", "12");
        map.put("m", "13");
        map.put("n", "14");
        map.put("o", "15");
        map.put("p", "16");
        map.put("q", "17");
        map.put("r", "18");
        map.put("s", "19");
        map.put("t", "20");
        map.put("u", "21");
        map.put("v", "22");
        map.put("w", "23");
        map.put("x", "24");
        map.put("y", "25");

        for (String value : map.values()) {
            System.out.print(value + " ");
        }

    }







//    public static void main(String[] args) throws IOException {
//
//        Map<String, String> map = new HashMap<>();
//
//        String path = KolDaoTest.class.getClassLoader().getResource("config/target-server.conf").getPath();
//
//        // 创建一个file对象
//        File file1 = new File("target/classes/com/jesse/learn/reflect/aaa.xml");
//
//        // 创建一个file对象
//        File file = new File("target/classes/config/bbb.xml");
//
//        // 创建输入流,此时读取的是文件的字节流，in.read()读取的是字节
//        InputStream inputStream = new FileInputStream(file);
//
//        //InputStreamReader 做的操作是将字节流转换成字符流
//        InputStreamReader rd = new InputStreamReader(inputStream);
//        BufferedReader bf = new BufferedReader(rd);
//
//        //用缓冲区的readLine(行的读取，返回值为String)读取文件
//        String str = null;
//        while((str=bf.readLine())!=null) {
//            System.out.println(str);
//        }
//
//        // 关闭rd流
//        rd.close();
//    }
































}
