<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<br />
	<h2>List of Employees</h2>
	<br />
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Employee Name</th>
				<th>Gender</th>
				<th>Date of birth</th>
				<th>Department Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listOfEmployee}" var="employee">
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.employeeName}</td>
					<td>${employee.gender == 1 ? 'Male' : 'Female'}</td>
					<td>${employee.dateOfBirth}</td>
					<c:forEach items="${listOfDepartment}" var="department">
						<c:if test="${employee.departmentId == department.departmentId}">
							<td>${department.departmentName}</td>
						</c:if>
					</c:forEach>
					
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>