<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>角色管理</title>
    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>

    <script type="text/javascript">
        $(function () {
            $.get("${pageContext.request.contextPath}/student/list", function (data) {
                data.forEach(function (student, index) {
                    var str = "";
                    str += "<tr>";
                    str += "<td>"+(index+1)+"</td>";
                    str += "<td>"+student.name+"</td>";
                    str += "<td>"+student.age+"</td>";
                    str += "<td>"+student.createTime+"</td>";
                    str += "<td>修改 删除</td>";
                    str += "</tr>";

                    $("tbody").append(str);
                });
            }, "json");
        });

        function toAddPage() {
            location.href = "${pageContext.request.contextPath}/admin/jsp/student/form.jsp";
        }

        function toUpdatePage(id) {
            location.href = "${pageContext.request.contextPath}/sysRole/toUpdatePage/" + id;
        }

        function doDelete(id) {
            if (confirm("您确认删除吗？")) {
                location.href = "${pageContext.request.contextPath}/sysRole/delete/" + id;
            }
        }
    </script>
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/admin/index.jsp">首页</a></li>
        <li><a href="#">系统设置</a></li>
        <li><a href="#">角色管理</a></li>
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
            <th>学生姓名</th>
            <th>年龄</th>
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
