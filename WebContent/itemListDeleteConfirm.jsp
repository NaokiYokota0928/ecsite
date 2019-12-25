<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>ItemListDeleteConfirm画面</title>

<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action',url);
		$('form').submit();
	}
</script>

</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>ItemListDeleteConfirm</p>
		</div>

		<h3>すべての商品を削除します。よろしいですか？</h3>
		<div>
			<s:form>
				<tr>
					<td><input type="button" value="ＯＫ"
						onclick="submitAction('ItemListDeleteCompleteAction')" /></td>
					<td><input type="button" value="キャンセル"
						onclick="submitAction('ItemListAction')" /></td>
<!-- 						↑の解説リンク https://qiita.com/sakuraya/items/8bc22745c92aacb5d4c3 -->
<!-- 									   https://www.sejuku.net/blog/44159 -->
				</tr>

			</s:form>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>