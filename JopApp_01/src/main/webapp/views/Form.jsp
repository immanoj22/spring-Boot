<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Post Job</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">JobPortal</a>
  </div>
</nav>

<div class="container mt-4">
  <h1 class="h5">Post a Job</h1>
  <c:if test="${not empty errors}">
    <div class="alert alert-danger">
      <ul class="mb-0">
        <c:forEach var="err" items="${errors}">
          <li><c:out value="${err}"/></li>
        </c:forEach>
      </ul>
    </div>
  </c:if>

  <!-- Form fields match JobApplicationEntity exactly -->
  <form method="post" action="${pageContext.request.contextPath}/addNewJob">
    <div class="mb-3">
      <label class="form-label">Application Number</label>
      <input class="form-control" name="jobApplicationNumer" type="number" value="${job.jobApplicationNumer}" />
    </div>

    <div class="mb-3">
      <label class="form-label">Specification</label>
      <input class="form-control" name="jobSpecification" value="${job.jobSpecification}" required />
    </div>

    <div class="mb-3">
      <label class="form-label">Description</label>
      <textarea class="form-control" name="jobDiscription" rows="6">${job.jobDiscription}</textarea>
    </div>

    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label">Open From</label>
        <input class="form-control" name="jobOpenFrom" type="date" value="${job.jobOpenFrom}" />
      </div>
      <div class="col-md-6 mb-3">
        <label class="form-label">Close At</label>
        <input class="form-control" name="jobCloseAt" type="date" value="${job.jobCloseAt}" />
      </div>
    </div>

    <div class="mb-3">
      <label class="form-label">Skills (comma separated)</label>
      <input class="form-control" name="jobSkills" value="${job.jobSkills != null ? fn:join(job.jobSkills, ', ') : ''}" />
    </div>

    <div class="mb-3">
      <label class="form-label">Experience (years)</label>
      <input class="form-control" name="expirence" type="number" min="0" value="${job.expirence}" />
    </div>

    <button type="submit" class="btn btn-primary">Save</button>
    <a href="${pageContext.request.contextPath}/getAllJobs" class="btn btn-link">Cancel</a>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
