<%@ page import="java.util.List, com.bb.domain.Feed" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Feed</h2>

<body>
	<table border="1">
	<thead>
		<tr>
		<th>Title </th>
		<th>Description</th>
		<th>URL</th>
		</tr>
		</thead>
		<tbody>
			<c:if test="${not empty data}">
				<c:forEach var="listValue" items="${data}">
					<tr>
						<td>${listValue.description}</td>
						<td>${listValue.title}</td>
						<td>${listValue.url}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		</table>
</body>
</html>