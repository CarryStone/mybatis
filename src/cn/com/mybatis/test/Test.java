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
		List<User> list = session.selectList("test.findUserByUserName","С");
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
		user.setName("������");
		user.setSex('M');
		user.setAge("22");
		user.setAddress("�й��㶫");
		user.setCreatedate(new Date());
		session.insert("test.insertUser",user);
		session.commit();
		session.close();
	}
	
	public static void updateUser(){
		session = db.getSqlSession();
		User user = new User();
		user.setName("�����");
		user.setId(1);
		session.update("updateUser",user);
		session.commit();
		session.close();
	}
	
	public static void deleteUser(){	
		session = db.getSqlSession();
		session.delete("deleteUser","С����");
		session.commit();
		session.close();
	}
	
	//��̬��ѯ
	public static void selectMotive(){
		session = db.getSqlSession();
		User vo = new User();
		vo.setSex('F');
		vo.setName("��");
		List<User> list = session.selectList("findUserList",vo);
		for(User user:list){
			System.out.println(user.getName()+" "+user.getSex());
		}	
		session.close();
	}
	
	public static void testBatch() throws Exception{
		//�������棬���岻ͬ��Sqlsession����
		session = db.getSqlSession();
		session1 = db.getSqlSession();
		//Mapper����
		CustomerMapper cus = session.getMapper(CustomerMapper.class);
		List<Batch> list = cus.findBatchAndBatchDetail();
		for(Batch batch:list){
			Customer customer = batch.getCustomer();
			System.out.println("����Ϊ"+customer.getAcno()+"�Ŀͻ�"+customer.getUsername()+"���������κ�Ϊ"+
					batch.getNumber()+"�Ĳ�Ʒ������ʱ���ǣ�"+batch.getCreatetime()+",�������£�");
			List<BatchDetail> list1 = batch.getBatchdetails();
			for(BatchDetail detail:list1){
				System.out.println("��Ʒ����Ϊ"+detail.getFp().getName()+"����Ʋ�Ʒ"+detail.getProduct_num()
						+ "��,�ò�Ʒ���ص��ǣ�"+detail.getFp().getDetail());
			}
		}
		session.close();	
		CustomerMapper cus1 = session1.getMapper(CustomerMapper.class);
		List<Batch> list1 = cus1.findBatchAndBatchDetail();
		for(Batch batch:list1){
			Customer customer = batch.getCustomer();
			System.out.println("����Ϊ"+customer.getAcno()+"�Ŀͻ�"+customer.getUsername()+"���������κ�Ϊ"+
					batch.getNumber()+"�Ĳ�Ʒ������ʱ���ǣ�"+batch.getCreatetime()+",�������£�");
			List<BatchDetail> list2 = batch.getBatchdetails();
			for(BatchDetail detail:list2){
				System.out.println("��Ʒ����Ϊ"+detail.getFp().getName()+"����Ʋ�Ʒ"+detail.getProduct_num()
						+ "��,�ò�Ʒ���ص��ǣ�"+detail.getFp().getDetail());
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
