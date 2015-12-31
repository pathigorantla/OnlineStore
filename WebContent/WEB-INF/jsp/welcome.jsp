
<div>
	<table id="categoryList" border="1" width="100%">
		<tr>
		<th> Category Id </th>
		<th> Category Name </th>
		<c:forEach var="category" items="${message}">
			<tr>
				<td><c:out value="${category.id }"></c:out></td>
				<td><c:out value="${category.name }"></c:out></td>
			</tr>
		</c:forEach>
	
	</table>
</div>

<div>
	<c:url var="logoutAction" value="/logout"></c:url>
     
    <form action="${logoutAction}" method="post">
        <input type="submit" value="Logout" />
    </form>
</div>
 