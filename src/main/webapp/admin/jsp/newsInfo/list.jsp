<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新闻管理</title>
    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>

    <script type="text/javascript">
        $(function () {
            $.get("${pageContext.request.contextPath}/newsInfo/list", function (data) {
                data.forEach(function (newsInfo, index) {
                    var str = "";
                    str += "<tr>";
                    str += "<td>"+(index+1)+"</td>";
                    str += "<td>"+newsInfo.name+"</td>";
                    str += "<td>"+newsInfo.typeName+"</td>";
                    str += "<td>"+newsInfo.author+"</td>";
                    str += "<td>"+newsInfo.releaseTime+"</td>";
                    str += "<td>"+newsInfo.createTime+"</td>";
                    str += "<td>";
                    str += "<a href='${pageContext.request.contextPath}/admin/jsp/newsInfo/form.jsp?id="+newsInfo.id+"'>修改</a>";
                    str += "&nbsp;&nbsp;&nbsp;&nbsp;";
                    str += "<a href='javascript:doDelete("+newsInfo.id+")'>删除</a>";
                    str += "</td>";
                    str += "</tr>";

                    $("tbody").append(str);
                });
            }, "json");
        });

        function toAddPage() {
            location.href = "${pageContext.request.contextPath}/admin/jsp/newsInfo/form.jsp";
        }

        function doDelete(id) {
            if (confirm("您确认删除吗？")) {
                $.ajax({
                    url:"${pageContext.request.contextPath}/student/delete/"+id,
                    type:"get",
                    success:function (data,status,xhr) {
                        if (status == "success") {
                            alert("删除成功！");
                            location.href = "${pageContext.request.contextPath}/admin/jsp/newsInfo/list.jsp";
                        } else {
                            alert("删除失败！");
                        }
                    }
                });

                <%--$.get("${pageContext.request.contextPath}/student/delete/"+id, function(data, status) {--%>
                <%--    if (status == "success") {--%>
                <%--        alert("删除成功！");--%>
                <%--        location.href = "${pageContext.request.contextPath}/admin/jsp/student/list.jsp";--%>
                <%--    } else {--%>
                <%--        alert("删除失败！");--%>
                <%--    }--%>
                <%--});--%>
            }
        }
    </script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/admin/index.jsp">首页</a></li>
        <li><a href="#">业务管理</a></li>
        <li><a href="#">新闻管理</a></li>
    </ul>
    <ul class="toolbar1">
        <li onclick="toAddPage();" style="line-height:28px; height:28px;margin-top: 5px;margin-right: 8px;cursor:pointer;">
            <span><img src="${pageContext.request.contextPath}/admin/images/t01.png" width="18" height="18" /></span>添加</li>
    </ul>
</div>

<div class="rightinfo">
    <table class="tablelist">
        <thead>
        <tr>
            <th>序号</th>
            <th>新闻标题</th>
            <th>新闻类型</th>
            <th>新闻作者</th>
            <th>发布时间</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
