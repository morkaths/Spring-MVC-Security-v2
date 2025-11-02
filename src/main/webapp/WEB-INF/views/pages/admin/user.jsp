<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="page-heading">
    <div class="page-title">
        <div class="row">
            <div class="col-12 col-md-6 order-md-1 order-last">
                <h3>User Management</h3>
                <p class="text-subtitle text-muted">Manage system users and their information.</p>
            </div>
            <div class="col-12 col-md-6 order-md-2 order-first">
                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Users</li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
    <section class="section">
        <div class="card">
            <div class="card-header">
                <h5 class="card-title">
                    Users List
                </h5>
                <button type="button" class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#addUserModal">
				    Add User
				</button>
            </div>
            <div class="card-body">
                <table class="table table-striped" id="table1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.username}</td>
                                <td>${user.email}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${user.status == 1}">
                                            <span class="badge bg-success">Active</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge bg-danger">Inactive</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="text-end">
                                    <div class="dropdown">
                                        <button class="btn btn-link text-dark p-0" type="button" id="dropdownMenuButton-${user.id}" data-bs-toggle="dropdown" aria-expanded="false">
                                            <i class="bi bi-three-dots-vertical"></i>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton-${user.id}">
                                            <li><a class="dropdown-item" href="#"><i class="bi bi-eye me-2"></i>View</a></li>
                                            <li><a class="dropdown-item" href="#"><i class="bi bi-pencil me-2"></i>Edit</a></li>
                                            <li><a class="dropdown-item text-danger" href="#"><i class="bi bi-trash me-2"></i>Delete</a></li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</div>

<!-- Add User Modal -->

<!-- Modal -->
<div class="modal fade" id="addUserModal" tabindex="-1" aria-labelledby="addUserModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form:form action="/admin/user/add" method="post" modelAttribute="userForm">
        <div class="modal-header">
          <h5 class="modal-title" id="addUserModalLabel">Add User</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <form:input path="username" cssClass="form-control" id="username" required="required"/>
            <form:errors path="username" cssClass="text-danger"/>
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <form:input path="email" cssClass="form-control" id="email" required="required"/>
            <form:errors path="email" cssClass="text-danger"/>
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <form:password path="password" cssClass="form-control" id="password" required="required"/>
            <form:errors path="password" cssClass="text-danger"/>
          </div>
          <div class="mb-3">
            <label for="status" class="form-label">Status</label>
            <form:select path="status" cssClass="form-select" id="status">
              <form:option value="1" label="Active"/>
              <form:option value="0" label="Inactive"/>
            </form:select>
            <form:errors path="status" cssClass="text-danger"/>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Add User</button>
        </div>
      </form:form>
    </div>
  </div>
</div>

