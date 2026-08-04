<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Error</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
  <div class="text-center">
    <h1 class="display-6 text-danger">Something went wrong</h1>
    <p class="lead">An error occurred while processing your request.</p>
    <c:if test="${not empty error}">
      <pre class="text-start bg-light p-3 rounded">${error}</pre>
    </c:if>
    <a href="${pageContext.request.contextPath}/" class="btn btn-primary mt-3">Return Home</a>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
