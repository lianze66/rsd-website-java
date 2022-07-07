<%@page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>新闻管理 - 表单页面</title>

    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-3.6.0.js"></script>

    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/admin/js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/admin/js/ueditor/_examples/editor_api.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/admin/js/ueditor/lang/zh-cn/zh-cn.js"></script>

    <script type="text/javascript">
        $(function() {
            $.get("${pageContext.request.contextPath}/newsInfo/newsTypeList", function (data) {
                data.forEach(function (newsType) {
                    $("[name='typeId']").append("<option value='"+newsType.id+"'>"+newsType.name+"</option>");
                })
            });

            var param = window.location.search;
            if (param != "") {
                var id = param.substring(param.indexOf("=") + 1);
                $.get("${pageContext.request.contextPath}/newsInfo/detail/"+id, function (data) {
                    $("[name='id']").val(data.id);
                    $("[name='name']").val(data.name);
                    $("[name='typeId']").val(data.typeId);
                    $("[name='releaseTime']").val(data.releaseTime);
                    UE.getEditor('content').setContent(data.content);
                });
            }

            $(".btn").click(function() {
                var formData = {
                    id:$("[name='id']").val(),
                    name:$("[name='name']").val(),
                    typeId:$("[name='typeId']").val(),
                    releaseTime:$("[name='releaseTime']").val(),
                    content:UE.getEditor('content').getContent()
                };

                var method = formData.id==""?"insert":"update";

                $.post("${pageContext.request.contextPath}/newsInfo/"+method, formData, function (data, status) {
                    if (status == "success") {
                        alert("保存成功！");
                        window.location.href = "${pageContext.request.contextPath}/admin/jsp/newsInfo/list.jsp";
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
                <input type="hidden" name="id" />
                <ul class="forminfo">
                    <li>
                        <label>新闻标题</label>
                        <input name="name" type="text" class="dfinput" />
                        <i>新闻标题不可以为空！</i>
                    </li>

                    <li>
                        <label>新闻类型</label>
                        <select name="typeId" class="dfinput"></select>
                        <i>新闻类型不可以为空！</i>
                    </li>

                    <li>
                        <label>显示时间</label>
                        <input name="releaseTime" type="date" class="dfinput" />
                        <i>显示时间不可以为空！</i>
                    </li>

                    <li>
                        <label>新闻内容</label>
                        <script id="content" type="text/plain" style="width:800px;height:60px;"></script>
                        <i>新闻内容不可以为空！</i>
                    </li>

                    <li>
                        <label>&nbsp;</label>
                        <input type="button" class="btn" value="确认保存" />
                    </li>
                </ul>
            </form>
        </div>

        <script type="text/javascript">
            UE.getEditor('content');
        </script>
    </body>
</html>
