<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Job Portal - Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-..." crossorigin="anonymous">
    <style>
        body { padding-top: 70px; }
        .job-card { transition: box-shadow .15s; }
        .job-card:hover { box-shadow: 0 4px 18px rgba(0,0,0,0.08); }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">JobPortal</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navMain" aria-controls="navMain" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navMain">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/getAllJobs">All Jobs</a></li>
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ApplicationForm">Post Job</a></li>
      </ul>
<%--      <form class="d-flex" method="get" action="${pageContext.request.contextPath}/jobs/search">--%>
<%--        <input class="form-control me-2" type="search" name="q" placeholder="Search jobs, company, location" aria-label="Search" value="${param.q}">--%>
<%--        <button class="btn btn-outline-light" type="submit">Search</button>--%>
<%--      </form>--%>
    </div>
  </div>
</nav>

<div class="container">
  <c:if test="${not empty message}">
    <div class="alert alert-info" role="alert">
      <c:out value="${message}"/>
    </div>
  </c:if>

  <div class="row mb-4">
    <div class="col-12">
      <h1 class="h3">Latest Jobs</h1>
      <p class="text-muted">Browse recent postings. Click a job to view details.</p>
    </div>
  </div>

  <c:choose>
    <c:when test="${not empty jobs}">
      <div class="row row-cols-1 row-cols-md-2 g-3">
        <c:forEach var="job" items="${jobs}" varStatus="status">
          <div class="col">
            <div class="card job-card">
              <div class="card-body">
                <div class="d-flex justify-content-between align-items-start">
                  <div>
                    <h5 class="card-title mb-1"><a href="${pageContext.request.contextPath}/getJob?applicationNo=${job.jobApplicationNumer}" class="text-decoration-none"> <c:out value="${job.jobSpecification}"/></a></h5>
                    <p class="mb-1 text-muted small">Open From: <c:out value="${job.jobOpenFrom}"/> — Exp: <c:out value="${job.expirence}"/> yrs</p>
                    <p class="mb-0"><c:out value="${job.jobDiscription}"/></p>
                  </div>
                  <div class="text-end">
                    <p class="mb-1 small text-muted">Open
                      <c:out value="${job.jobOpenFrom}"/></p>
                    <a href="${pageContext.request.contextPath}/getJob?applicationNo=${job.jobApplicationNumer}" class="btn btn-sm btn-primary">View</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </c:when>
    <c:otherwise>
      <div class="card">
        <div class="card-body text-center">
          <h5 class="card-title">No jobs found</h5>
          <p class="card-text text-muted">Try adjusting your search or <a href="${pageContext.request.contextPath}/job/new">post a job</a>.</p>
        </div>
      </div>
    </c:otherwise>
  </c:choose>

  <footer class="mt-5 text-muted small">
    <hr/>
    <p>JobPortal &copy; <c:out value="${pageContext.servletContext.serverInfo}"/> • Built with JSP & JSTL</p>
  </footer>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-..." crossorigin="anonymous"></script>
</body>
</html>
