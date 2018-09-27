package cn.com.mybatis.test;

import java.util.List;

import cn.com.mybatis.po.Batch;

public interface CustomerMapper {
    //方法名要和mapper下select标签id一致
	public List<Batch> findBatchAndBatchDetail() throws Exception;
}
