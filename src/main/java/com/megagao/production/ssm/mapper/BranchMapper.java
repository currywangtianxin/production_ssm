package com.megagao.production.ssm.mapper;

import java.util.List;

import com.megagao.production.ssm.domain.Branch;

public interface BranchMapper {
	public List<Branch> find();

	public int deleteBatch(String[] ids);

	public int update(Branch branch);

	public int add(Branch branch);

	public int deleteByPrimaryKey(String branchId);
}
