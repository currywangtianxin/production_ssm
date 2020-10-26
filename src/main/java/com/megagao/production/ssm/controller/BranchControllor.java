package com.megagao.production.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.megagao.production.ssm.domain.Branch;
import com.megagao.production.ssm.domain.authority.SysUser;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.service.BranchService;

@Controller
public class BranchControllor {
	@Autowired
	BranchService barBranchService;

	@RequestMapping("branch/find")
	public String find() throws Exception {
		return "branch_list";
	}

	// 添加
	@RequestMapping("branch/add")
	public String add() throws Exception{
		return "branch_add";
	}
	@ResponseBody
	@RequestMapping("branch/insert")
	public CustomResult addbranch(Branch branch) throws Exception{
		CustomResult result = barBranchService.add(branch);
		return result;
	}
	//更新
	@RequestMapping("branch/edit")
	public String edit() throws Exception{
		return "branch_edit";
	}
	@ResponseBody
	@RequestMapping("branch/update")
	public CustomResult update(Branch branch) throws Exception{
		CustomResult result = barBranchService.update(branch);;
		return result;
	}
	@RequestMapping("branch/delete")
	@ResponseBody
	private CustomResult delete(String branchId) throws Exception {
		CustomResult result = barBranchService.delete(branchId);
		return result;
	}

	@RequestMapping("branch/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = barBranchService.deleteBatch(ids);
		return result;
	}

	@ResponseBody
	@RequestMapping("branch/demo")
	public List<Branch> demo() throws Exception {
		List<Branch> list = barBranchService.find();

		return list;

	}

	@RequestMapping("branch/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows)
			throws Exception {
		EUDataGridResult result = barBranchService.getList(page, rows);
		System.out.println("输出前分页的值为result" + result);
		return result;
	}

}
