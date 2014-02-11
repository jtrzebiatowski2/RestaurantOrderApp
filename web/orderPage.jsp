<%-- 
    Document   : orderPage
    Created on : Feb 11, 2014, 10:31:44 AM
    Author     : J-Tron
--%>
<%@page import="java.util.List"%>
<%@page import="model.MenuItem"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Order System</title>
        <style>
            body{
                margin-left:auto;
                margin-right:auto;
                margin-top: auto;
                margin-bottom:auto;
                background-image: url('wood-background.jpg');
            }
            .center{
                margin-left:auto;
                margin-right:auto;
                text-align: center;
            }
            .inline{
                margin-left:auto;
                margin-right:auto;
                display: inline-block;
                text-align: center;
                background-color: #ffff66;
                
            }
            .infoDivs{
                margin-top:auto;
                margin-bottom: auto;
                margin-left:auto;
                margin-right:auto;
                width:600px;
                height:600px;
                border-style: groove;
                border-color: saddlebrown;
                border-width:10px;
                background-color: #ffff66;
                
            }
             .rockwell {
                font-family: Rockwell, Georgia, Serif;
            }
            
        </style>
    </head>
    <body>
        <div class='center'><img src='JustinsChopHouseBanner.png' alt='titleBanner'></div>
        <div class="infoDivs">
            
            <form method="POST" action='/order' class='center'>
                <h2 class='rockwell'>Menu Items</h2>
                <select name='menuOptions'>
                     <c:forEach var="item" items="${menuItems}">
                        ${"<option value='"}${item.getItemID()}${"'>"}${item.getName()}${'</option>'}
                    </c:forEach>
                    <%
                        //List<MenuItem> menuItems = (List<MenuItem>)request.getAttribute("menuItems");
                        //for(MenuItem item : menuItems) {
                        //    out.println("<option value='" + item.getItemID() + "'>" + item.getName() + "</option>");
                        //}
                    %>
                    <p>
                        Description: + 
                    </p>
                </select>
            </form>
        </div>
        <h1></h1>
    </body>
</html>
