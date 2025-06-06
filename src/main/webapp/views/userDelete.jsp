<%@page import="jakarta.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報削除</title>
</head>
<body>
<form action="userdeleteservlet" method="post" onsubmit="return confirmDelete();">
<input type="hidden" name="member_id" value="${sessionScope.user.member_id }">
<input type="submit" value="削除">
</form>

<script type="text/javascript">
function confirmDelete(){
	return confirm("削除してもよろしいですか？");
}
</script>

</body>
</html>