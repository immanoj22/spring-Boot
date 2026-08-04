<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Job Details</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">JobPortal</a>
  </div>
</nav>

<div class="container mt-4">
  <c:if test="${not empty job}">
    <div class="card">
      <div class="card-body">
        <h2 class="card-title"><c:out value="${job.jobSpecification}"/></h2>
        <h6 class="text-muted">Open: <c:out value="${job.jobOpenFrom}"/> — Close: <c:out value="${job.jobCloseAt}"/></h6>
        <p class="mt-3"><c:out value="${job.jobDiscription}"/></p>
        <p class="text-muted small">Experience required: <c:out value="${job.expirence}"/> yrs</p>
        <div class="mt-3">
          <a href="mailto:jobs@example.com?subject=Application for ${job.jobSpecification}" class="btn btn-outline-primary">Apply via Email</a>
          <a href="${pageContext.request.contextPath}/getAllJobs" class="btn btn-link">Back to list</a>
        </div>
      </div>
    </div>
  </c:if>
  <c:if test="${empty job}">
    <div class="alert alert-danger">Job not found.</div>
  </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
