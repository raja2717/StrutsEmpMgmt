<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<option value="0">--select district--</option>

<c:forEach items="${DistList}" var="district">
    <option value="${district.distCode}"<c:if test="${district.distCode == User.distCode}">selected</c:if>>
        ${district.distName}
    </option>
</c:forEach>