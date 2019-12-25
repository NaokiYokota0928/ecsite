<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>ItemListDeleteComplete画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>ItemListDeleteComplete</p>
		</div>
		<div>
			<s:property value="message"/>
			<div>
				<p><a href='<s:url action="AdminAction"/>'> 管理者TOPへ</a></p>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>