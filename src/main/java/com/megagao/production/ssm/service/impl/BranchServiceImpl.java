package com.megagao.production.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.megagao.production.ssm.domain.Branch;
import com.megagao.production.ssm.domain.authority.SysUser;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.mapper.BranchMapper;
import com.megagao.production.ssm.service.BranchService;
@Service
public class BranchServiceImpl implements BranchService {
	@Autowired
	BranchMapper branchMapper;
	
	@Override
	public List<Branch> find() {
		System.out.println("service层branch方法"+branchMapper.find());
		return branchMapper.find();
	}

	@Override
	public EUDataGridResult getList(int page, int rows) {
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<Branch> list =branchMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Branch> pageInfo = new PageInfo<Branch>(list);
		result.setTotal(pageInfo.getTotal());
		System.out.println("service层,分页对象的值"+result);
		return result;
	}

	@Override
	public CustomResult update(Branch branch) {

		int i = branchMapper.update(branch);
		if (i > 0) {
			return CustomResult.ok();
		} else {
			return null;
		}
	}

	@Override
	public CustomResult add(Branch branch) {
		int i = branchMapper.add(branch);;
		if (i > 0) {
			return CustomResult.ok();
		} else {
			return null;
		}
	}

	@Override
	public CustomResult delete(String branchId) {
		int i = branchMapper.deleteByPrimaryKey(branchId);
		if (i > 0) {
			return CustomResult.ok();
		} else {
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = branchMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}


}
