<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>学生管理 - 表单页面</title>
    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-3.6.0.js"></script>

    <script type="text/javascript">
        $(function() {
            $(".btn").click(function() {
                var formData = {
                    name:$("[name='name']").val(),
                    age:$("[name='age']").val()
                };
                $.post("${pageContext.request.contextPath}/student/insert", formData, function (data, status, a) {
                    if (status == "success") {
                        alert("保存成功！");
                        window.location.href = "${pageContext.request.contextPath}/admin/jsp/student/list.jsp";
                    } else {
                        alert("保存失败！");
                    }
                });
            });
        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">表单</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form id="myForm">
        <ul class="forminfo">
            <li><label>名称</label><input name="name" type="text" class="dfinput" /><i>名称不可以为空！</i></li>
            <li><label>年龄</label><input name="age" type="text" class="dfinput" /><i>年龄不可以为空！</i></li>
            <li><label>&nbsp;</label><input type="button" class="btn" value="确认保存" /></li>
        </ul>
    </form>
</div>
</body>
</html>
