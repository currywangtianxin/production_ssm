package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.Branch;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface BranchService {

	public List<Branch> find();
	
	public EUDataGridResult getList(int page,int rows);

	public CustomResult delete(String id);
	
	public CustomResult update(Branch branch);
	
	public CustomResult add(Branch branch);

	public CustomResult deleteBatch(String[] ids);
	

	
}
