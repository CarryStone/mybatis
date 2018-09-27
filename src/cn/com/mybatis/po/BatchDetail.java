package cn.com.mybatis.po;

import java.io.Serializable;

public class BatchDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private int batch_id;
    private int product_id;
    private int product_num;
    private FinacialProduct fp; 
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	public FinacialProduct getFp() {
		return fp;
	}
	public void setFp(FinacialProduct fp) {
		this.fp = fp;
	}
    
    
}
