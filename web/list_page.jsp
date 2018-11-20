<%--
  Created by IntelliJ IDEA.
  User: WangJian
  Date: 2018/11/19
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页学生信息界面</title>
</head>
<script type="text/javascript">
    function doDelete(sid){
        // 如果弹出的对话框，用户点击确定，马上请求Servlet
        // 如何知道用户点击的是确定，如何在js的方法中请求Servlet
        var flag = confirm("是否确定删除?");
        if(flag){
            // 表明点击了确定，访问servlet，在当前的标签页上打开超链接
            window.location.href="/DeleteStudentServlet?sid=" + sid;
        }else{

        }
    }
</script>
<body>
    <form action="SearchStudentServlet" method="post">
        <table border="1" width="700">
            <tr>
                <td colspan="8">
                    按姓名查询:<input type="text" name="sname">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    按性别查询:<select name="gender">
                    <option value="">--请选择--</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" value="查询">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="add.jsp">添加</a>
                </td>
            </tr>
            <tr align="center">
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>电话</td>
                <td>生日</td>
                <td>爱好</td>
                <td>简介</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${pageBean.list}" var="stu">
                <tr align="center">
                    <td>${stu.sid}</td>
                    <td>${stu.sname}</td>
                    <td>${stu.gender}</td>
                    <td>${stu.phone}</td>
                    <td>${stu.birthday}</td>
                    <td>${stu.hobby}</td>
                    <td>${stu.info}</td>
                    <td><a href="EditStudentServlet?sid=${stu.sid}">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8">
                    第${pageBean.currentPage}页/${pageBean.totalPage}页
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    每页显示${pageBean.pageSize}
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    总的记录数为${pageBean.totalSize}
                    <c:if test="${pageBean.currentPage!=1}">
                        <a href="StudentListPageServlet?currentPage=1">首页</a>|
                        <a href="StudentListPageServlet?currentPage=${pageBean.currentPage-1}">上一页</a>
                    </c:if>
                    <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                        <c:if test="${pageBean.currentPage == i}">
                            ${i} &nbsp;&nbsp;
                        </c:if>
                        <c:if test="${pageBean.currentPage != i}">
                            <a href="StudentListPageServlet?currentPage=${i}">${i}&nbsp;&nbsp;</a>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                        <a href="StudentListPageServlet?currentPage=${pageBean.currentPage+1}">下一页</a>|
                        <a href="StudentListPageServlet?currentPage=${pageBean.totalPage}">尾页</a>
                    </c:if>
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
