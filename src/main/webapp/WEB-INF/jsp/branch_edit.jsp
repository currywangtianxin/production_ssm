<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="branchEditForm" class="branchEditForm" method="post">
	    <table cellpadding="5">
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
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitWorkEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitWorkEditForm(){
		if(!$('#branchEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("branch/update",$("#branchEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改机构成功!','info',function(){
					$("#branchEditWindow").window('close');
					$("#branchList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
</script>
