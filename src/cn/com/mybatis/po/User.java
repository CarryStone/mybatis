package cn.com.mybatis.po;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable{

	/**
	 *  2018-05-27  @author lirenjie
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private char sex;
	private String age;
	private String address;
	private Date createdate;
	
	public User() {}

	public User(int id, String name, char sex, String age, String address, Date createdate) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.createdate = createdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	
	
	
}
