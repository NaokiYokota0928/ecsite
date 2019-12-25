<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>UserList画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>ユーザー一覧</p>
		</div>
		<div>
			<s:if test="userList == null">
				<h3>登録されたユーザー情報はありません。</h3>
			</s:if>

			<s:elseif test="message == null">
				<h3>登録されたユーザー情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>id</th>
						<th>ログインID</th>
						<th>パスワード</th>
						<th>ユーザー名</th>
						<th>登録日</th>
						<th>更新日</th>
					</tr>

					<s:iterator value="userList">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="loginId" /></td>
							<td><s:property value="loginPassword" /></td>
							<td><s:property value="userName" /></td>
							<td><s:property value="insert_date" /></td>
							<td><s:property value="update_date" /></td>
						</tr>
					</s:iterator>
				</table>

				<s:form action="UserListDeleteConfirmAction">
<!-- 					<input type="hidden" name="deleteFlg" value="1"> -->
<!-- 						↑UserListDeleteConfirmで実行 -->
					<s:submit value="削除" />
				</s:form>
			</s:elseif>

			<s:if test="message !=null">
				<h3>
					<s:property value="message" />
				</h3>
			</s:if>

			<div>
				<p><span>前画面に戻る場合は</span> <a href='<s:url action="AdminAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>