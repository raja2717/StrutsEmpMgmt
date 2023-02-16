<%--
    Document   : statelist
    Created on : 13-Feb-2023, 12:46:44 pm
    Author     : Lenovo
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<option value="0">--select province--</option>

<c:forEach items="${StateList}" var="province">
    <option value="${province.provinceCode}"<c:if test="${province.provinceCode == User.provinceCode}">selected</c:if>>
        ${province.provinceName}
    </option>
</c:forEach>