<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="branchAddForm" class="branchForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>机构编号:</td>
	            <td>
	            	<input id="id" class="easyui-textbox" type="text" name="id" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>机构名称:</td>
	            <td>
	            	<input id="username" class="easyui-textbox" type="text" name="name"
						   data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>机构简称:</td>
	            <td>
	            	<input id="shortname" class="easyui-textbox" type="text" name="shortname" />
	            </td>
	        </tr>
	    </table>
	</form>
	<br><br>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitUserAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearUserAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//提交表单
	function submitUserAddForm(){
		//有效性验证
		if(!$('#branchAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		//ajax的post方式提交表单
		//$("#userAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("branch/insert",$("#branchAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示', data.msg);
				clearUserAddForm();
				$("#branchAddWindow").window('close');
				$("#branchList").datagrid("reload");
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	function clearUserAddForm(){
		$('#userAddForm').form('reset');
	}
</script>
