package cn.com.mybatis.test;

import java.util.List;

import cn.com.mybatis.po.Batch;

public interface CustomerMapper {
    //������Ҫ��mapper��select��ǩidһ��
	public List<Batch> findBatchAndBatchDetail() throws Exception;
}
