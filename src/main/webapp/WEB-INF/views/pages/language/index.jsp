<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-heading">
    <div class="page-title">
        <div class="row">
            <div class="col-12 col-md-6 order-md-1 order-last">
                <h3>Language Management</h3>
                <p class="text-subtitle text-muted">Manage system languages and translations.</p>
            </div>
            <div class="col-12 col-md-6 order-md-2 order-first">
                <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Languages</li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
    <section class="section">
        <div class="card">
            <div class="card-header">
                <h5 class="card-title">
                    Languages List
                </h5>
            </div>
            <div class="card-body">
                <table class="table table-striped" id="table1">
                    <thead>
                        <tr>
                            <th>Language ID</th>
                            <th>Language Name</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="language" items="${languages}">
                            <tr>
                                <td>${language.languageID}</td>
                                <td>${language.language}</td>
                                <td class="text-end">
                                    <div class="dropdown">
                                        <button class="btn btn-link text-dark p-0" type="button" id="dropdownMenuButton-${language.languageID}" data-bs-toggle="dropdown" aria-expanded="false">
                                            <i class="bi bi-three-dots-vertical"></i>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton-${language.languageID}">
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
<c:if test="${showModal}">
    <script>
        $(document).ready(function() {
            $('#addLanguageModal').modal('show');
        });
    </script>
</c:if>
<!-- Modal Add Language -->
<div class="modal fade" id="addLanguageModal" tabindex="-1" aria-labelledby="addLanguageModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form:form action="/admin/language/add" method="post" modelAttribute="languageForm">
        <div class="modal-header">
          <h5 class="modal-title" id="addLanguageModalLabel">Add Language</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label for="languageID" class="form-label">Language ID</label>
            <form:input path="languageID" cssClass="form-control" id="languageID" required="required"/>
            <form:errors path="languageID" cssClass="text-danger"/>
          </div>
          <div class="mb-3">
            <label for="language" class="form-label">Language Name</label>
            <form:input path="language" cssClass="form-control" id="language" required="required"/>
            <form:errors path="language" cssClass="text-danger"/>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Add Language</button>
        </div>
      </form:form>
    </div>
  </div>
</div>
