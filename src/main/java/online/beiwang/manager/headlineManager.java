package online.beiwang.manager;

import online.beiwang.models.headlineModel;
import online.beiwang.models.userModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by yuying on 2016/12/20.
 */
public class headlineManager {
    public static List<headlineModel> GetTop10() {
        String resource = "/mybatis/config.xml";//mybatis/config.xml
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<headlineModel> list = session.selectList("online.baiwang.mybatis.HeadlineMapper.TopN",10);
            return  list;
        } finally {
            session.close();
        }
    }
}
