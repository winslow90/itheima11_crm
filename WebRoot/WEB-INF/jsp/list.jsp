<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="images/tleft.gif"/></td>
    <td width="39%" align="left">[部门管理]</td>
   
    <td width="57%"align="right">
       <a href="departmentAction_addUI.action"><img src="images/button/tianjia.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="images/tright.gif"/></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="images/result.gif"/></td>
  </tr>
</table>
<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="6%" align="center">部门名称</td>
	<td width="6%" align="center">部门说明</td>
    <td width="7%" align="center">编辑</td>
  </tr>
 
  <!-- 
  		value查找要迭代的集合
   -->
  <s:iterator value="#departments">
	  <tr class="tabtd2">
	    <td align="center"><s:property value="name"/></td>
	    <td align="center"><s:property value="description"/></td>
	    	<!-- 
	    	<s:a action="departmentAction_updateUI.action?did=%{did}"></s:a>
	    	 -->
	  	<td width="7%" align="center"><a href="departmentAction_updateUI.action?did=${did}"><img src="images/button/modify.gif" class="img"></a></td>
	  </tr>
  </s:iterator>
  
  <!-- 
  	 Map<String,Department>
   -->
  <s:iterator value="#map">
  	 <s:property value="key"/>
  	 <s:property value="value.name"/>
  </s:iterator>
  <!-- 
  	List<Map<String,Department>>
   -->
  <s:iterator value="#list"> <!-- list  -->
  	 <s:iterator>  <!-- map -->
  	 	<!-- 
  	 		entry
  	 	 -->
  	 	<s:property value="key"/>
  	 	<s:property value="value.name"/>
  	 </s:iterator>
  </s:iterator>
  <!-- 
  	 Map<String,List<Department>>
   -->
   <s:iterator value="#map">
   		<s:property value="key"/>
   		<s:iterator value="value">
   			<s:property value="name"/>
   		</s:iterator>
   </s:iterator>
   <!-- 
   		List<Map<String,List<Department>>>
    -->
   <s:iterator value="#listMapList"> <!-- list -->
   	   <s:iterator><!-- map -->
   	   		<!-- 
   	   			entry
   	   		 -->
   	   		<s:property value="key"/>
   	   		<s:iterator value="value"><!-- list -->
   	   			<s:property value="getName()"/>
   	   		</s:iterator>
   	   </s:iterator>
   </s:iterator>
</table>
</body>
</html>
