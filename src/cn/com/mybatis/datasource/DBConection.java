package cn.com.mybatis.datasource;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConection {

	private static String resource = "SqlMapConfig.xml";
	private static SqlSessionFactory factory;
	private SqlSession session = null;
	private static DBConection db = null;
	
	private DBConection(){}
		
	public static DBConection getInstance(){
		if(db==null){
			return new DBConection();
		}
		return db;
	}
	
	public static SqlSessionFactory getSqlsessionFactory(){
		if(factory==null){	
			try {
				InputStream input = Resources.getResourceAsStream(resource);
				factory = new SqlSessionFactoryBuilder().build(input);
				return factory;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		return factory;
	}
	
	public SqlSession getSqlSession(){
		try {
			//´´½¨sessionÊµÀý			
			session = factory.openSession();			
		} catch (Exception e) {		
			e.printStackTrace();
		}
		return session;	
	}
}
