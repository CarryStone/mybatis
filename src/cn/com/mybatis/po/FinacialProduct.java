package cn.com.mybatis.po;

import java.io.Serializable;
import java.util.Date;

public class FinacialProduct implements Serializable{
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   private int product_id;
   private String name;
   private float price;
   private String detail;
   private String pic;
   private Date investtime;
   
   
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public Date getInvesttime() {
	return investtime;
}
public void setInvesttime(Date investtime) {
	this.investtime = investtime;
}
   
   
   
}
