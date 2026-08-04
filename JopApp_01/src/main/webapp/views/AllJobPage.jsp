<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>All Jobs</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">JobPortal</a>
    <div class="collapse navbar-collapse" id="navMain">
      <ul class="navbar-nav me-auto">
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">Home</a></li>
        <li class="nav-item"><a class="nav-link active" href="#">All Jobs</a></li>
      </ul>
      <form class="d-flex" method="get" action="${pageContext.request.contextPath}/jobs/search">
        <input class="form-control me-2" type="search" name="q" placeholder="Search" value="${param.q}">
        <button class="btn btn-outline-light" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

<div class="container mt-4">
  <h1 class="h4 mb-3">All Jobs</h1>
  <c:if test="${not empty jobs}">
    <div class="list-group">
      <c:forEach var="job" items="${jobs}">
        <a href="${pageContext.request.contextPath}/getJob?applicationNo=${job.jobApplicationNumer}" class="list-group-item list-group-item-action d-flex justify-content-between align-items-start">
          <div>
            <div class="fw-bold"><c:out value="${job.jobSpecification}"/></div>
            <small class="text-muted"><c:out value="${job.jobDiscription}"/></small>
          </div>
          <div class="text-end">
            <small class="text-muted">Open <c:out value="${job.jobOpenFrom}"/></small>
          </div>
        </a>
      </c:forEach>
    </div>
  </c:if>
  <c:if test="${empty jobs}">
    <div class="alert alert-warning">No jobs available. <a href="${pageContext.request.contextPath}/job/new">Post the first job</a>.</div>
  </c:if>

  <div class="mt-4">
    <a href="${pageContext.request.contextPath}/job/new" class="btn btn-primary">Post a Job</a>
    <a href="${pageContext.request.contextPath}/" class="btn btn-link">Back to Home</a>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
