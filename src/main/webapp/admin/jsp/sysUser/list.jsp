<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
    <link href="/admin/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="/admin/js/jquery.js"></script>

    <script type="text/javascript">
        function toAddPage() {
            location.href = "/admin/jsp/sysUser/form.jsp";
        }

        function toUpdatePage(id) {
            location.href = "/sysUser/toUpdatePage/" + id;
        }

        function doDelete(id) {
            if (confirm("您确认删除吗？")) {
                location.href = "/sysUser/delete/" + id;
            }
        }

        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="/admin/index.jsp">首页</a></li>
        <li><a href="#">系统设置</a></li>
        <li><a href="#">用户管理</a></li>
    </ul>
    <ul class="toolbar1">
        <li onclick="toAddPage();" style="line-height:28px; height:28px;margin-top: 5px;margin-right: 8px;cursor:pointer;">
            <span><img src="/admin/images/t01.png" width="18" height="18" /></span>添加</li>
    </ul>
</div>

<div class="rightinfo">

    <!--
   <div class="tools">
       <ul class="toolbar">
           <li onclick="toAddPage();"><span><img src="/admin/images/t01.png" /></span>添加</li>
           <li class="click"><span><img src="/admin/images/t02.png" /></span>修改</li>
           <li><span><img src="/admin/images/t03.png" /></span>删除</li>
           <li><span><img src="/admin/images/t04.png" /></span>统计</li>
       </ul>

       <ul class="toolbar1">
           <li onclick="toAddPage();"><span><img src="/admin/images/t01.png" /></span>添加</li>
       </ul>
    </div>
    -->

    <table class="tablelist">
        <thead>
        <tr>
            <th>序号</th>
            <th>登录名称</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${pageInfo.list}" var="sysUser" varStatus="i">
            <tr>
                <td>${i.count + (pageInfo.pageNum - 1) * pageInfo.pageSize}</td>
                <td>${sysUser.loginName}</td>
                <td>${sysUser.password}</td>
                <td>
                    <a href="javascript:toUpdatePage(${sysUser.id});" class="tablelink">修改</a>
                    <a href="javascript:doDelete(${sysUser.id});" class="tablelink"> 删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="pagin">
        <div class="message">共<i class="blue">${pageInfo.total}</i>条记录，当前显示第&nbsp;<i class="blue">${pageInfo.pageNum}&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                <li class="paginItem"><a href="/sysUser/list/${num}">${num}</a></li>
            </c:forEach>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>


    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="/admin/images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>




</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
