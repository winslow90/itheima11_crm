<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="images/tleft.gif"/></td>
    <td width="44%" align="left">[添加部门]</td>
   
    <td width="52%"align="right">
       <a href="#"><img src="images/button/save.gif" /></a>
       <a href="#"><img src="images/button/tuihui.gif" /></a>
    </td>
    <td width="3%" align="right"><img src="images/tright.gif"/></td>
  </tr>
</table>
<s:form action="departmentAction_add.action">
<table width="88%" border="0" class="emp_table" style="width:80%;">
  <tr>
    <td>部门名称</td>
    <td><s:textfield name="name"/></td>
  </tr>
  <tr>
    <td>部门描述</td>
    <td><s:textarea name="description"/></td>
  </tr>
  
  <tr>
    <td colspan="4"><s:submit value="添加"/></td>
  </tr>
</table>
</s:form>
</body>
</html>
