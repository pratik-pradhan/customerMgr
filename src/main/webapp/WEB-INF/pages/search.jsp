<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Manager</title>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
    <style>
        .error {
            color: #ee0d25;
        }
    </style>

</head>
<body>

<a href="home" class="btn btn-link">Back</a>

<h2>Customer Manager</h2>
<form:form method="post" action="search" commandName="customer"  class="form-horizontal">
    <fieldset>
      
        <div class="form-group">
            <form:label class="col-lg-2 control-label" path="firstname">
                <spring:message code="label.firstname"/>
            </form:label>
            <div class="col-sm-3">
                <form:input path="firstname" placeholder="Firstname" cssClass="form-control"/>
            </div>
            <form:errors path="firstname" cssClass="error"/>
        </div>
    </fieldset>
    <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">
         <button type="submit" class="btn btn-primary"><spring:message code="label.searchcustomer"/></button>
        </div>
    </div>
    
   
    <c:if test="${!empty customerList}">
         <legend>Customer Details</legend>
    <table class="table table-hover">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Telephone</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.lastname}, ${customer.firstname} </td>
                <td>${customer.email}</td>
                <td>${customer.telephone}</td>
                <td><a href="delete/${customer.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</form:form>

</body>
</html>
