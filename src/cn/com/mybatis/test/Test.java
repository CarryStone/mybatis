package cn.com.mybatis.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.com.mybatis.datasource.DBConection;
import cn.com.mybatis.po.Batch;
import cn.com.mybatis.po.BatchDetail;
import cn.com.mybatis.po.Customer;
import cn.com.mybatis.po.User;

public class Test {
	public static DBConection db = DBConection.getInstance();
	public static SqlSessionFactory factory = DBConection.getSqlsessionFactory();
	public static SqlSession session = null;
	public static SqlSession session1 = null;


	public static void selectList(){	
		session = db.getSqlSession();
		List<User> list = session.selectList("test.findUserByUserName","小");
		for(User user :list){
		System.out.println(user.getName()+" "+user.getAddress()+" "+user.getCreatedate()+" "+user.getClass());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(user.getCreatedate()));
		}
		session.close();
	}
	
	public static void insertUser(){
		session = db.getSqlSession();
		User user = new User();
		user.setName("王老铁");
		user.setSex('M');
		user.setAge("22");
		user.setAddress("中国广东");
		user.setCreatedate(new Date());
		session.insert("test.insertUser",user);
		session.commit();
		session.close();
	}
	
	public static void updateUser(){
		session = db.getSqlSession();
		User user = new User();
		user.setName("李二杰");
		user.setId(1);
		session.update("updateUser",user);
		session.commit();
		session.close();
	}
	
	public static void deleteUser(){	
		session = db.getSqlSession();
		session.delete("deleteUser","小宇宙");
		session.commit();
		session.close();
	}
	
	//动态查询
	public static void selectMotive(){
		session = db.getSqlSession();
		User vo = new User();
		vo.setSex('F');
		vo.setName("王");
		List<User> list = session.selectList("findUserList",vo);
		for(User user:list){
			System.out.println(user.getName()+" "+user.getSex());
		}	
		session.close();
	}
	
	public static void testBatch() throws Exception{
		//二级缓存，定义不同的Sqlsession对象
		session = db.getSqlSession();
		session1 = db.getSqlSession();
		//Mapper代理
		CustomerMapper cus = session.getMapper(CustomerMapper.class);
		List<Batch> list = cus.findBatchAndBatchDetail();
		for(Batch batch:list){
			Customer customer = batch.getCustomer();
			System.out.println("卡号为"+customer.getAcno()+"的客户"+customer.getUsername()+"购买了批次号为"+
					batch.getNumber()+"的产品，购买时间是："+batch.getCreatetime()+",详情如下：");
			List<BatchDetail> list1 = batch.getBatchdetails();
			for(BatchDetail detail:list1){
				System.out.println("产品名称为"+detail.getFp().getName()+"的理财产品"+detail.getProduct_num()
						+ "份,该产品的特点是："+detail.getFp().getDetail());
			}
		}
		session.close();	
		CustomerMapper cus1 = session1.getMapper(CustomerMapper.class);
		List<Batch> list1 = cus1.findBatchAndBatchDetail();
		for(Batch batch:list1){
			Customer customer = batch.getCustomer();
			System.out.println("卡号为"+customer.getAcno()+"的客户"+customer.getUsername()+"购买了批次号为"+
					batch.getNumber()+"的产品，购买时间是："+batch.getCreatetime()+",详情如下：");
			List<BatchDetail> list2 = batch.getBatchdetails();
			for(BatchDetail detail:list2){
				System.out.println("产品名称为"+detail.getFp().getName()+"的理财产品"+detail.getProduct_num()
						+ "份,该产品的特点是："+detail.getFp().getDetail());
			}
		}
		session1.close();
	}
	
	public static void main(String[] args) throws Exception {
//		selectList();
//		insertUser();
//		updateUser();
//		deleteUser();
//		selectMotive();
		testBatch();
	}

}
