package online.beiwang.manager;


import online.beiwang.models.userModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yuying on 2016/12/19.
 */
public class userManager {
    public static userModel GetUser(String mail){
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
            userModel user = (userModel) session.selectOne("online.baiwang.mybatis.UserMapper.selectUser", mail);
            return  user;
        } finally {
            session.close();
        }
    }

    public static Boolean Exist(String mail){
        return GetUser(mail)==null;
    }

    public static String Login(String mail,String password){
        userModel user=GetUser(mail);
        if(user==null)
            return "该帐号不存在";
        if(user.getPassword().equals(password)==false)
            return  "密码不正确";

        return  "";
    }
}
