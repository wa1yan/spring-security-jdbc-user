<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="list" required="true" type="java.util.List"%>
<%@ taglib prefix="date-time" tagdir="/WEB-INF/tags" %>
<table class="table table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Login ID</th>
			<th>User Name</th>
			<th>Access Type</th>
			<th>Access At</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.loginId}</td>
				<td>${dto.userName}</td>
				<td>${dto.type}</td>
				<td>
					<date-time:dateTime value="${dto.accessTime}"></date-time:dateTime>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
