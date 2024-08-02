<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<%
        String menuName = (String) request.getAttribute("menuName");
        int amount = (int) request.getAttribute("amount");
        int orderPrice = (int) request.getAttribute("orderPrice");
    %>
    <h3>주문하신 음식 : <%= menuName %></h3>
    <h3>주문하신 수량 : <%= amount %></h3>
    <h2>결제하실 최종 금액 : <%= orderPrice %></h2>--%>

    <h3>주문하신 음식 : ${ menuName }</h3>
    <h3>주문하신 수량 : ${ amount }</h3>
    <h2>결제하실 최종 금액 : ${ orderPrice }</h2>
</body>
</html>
