<%@page contentType="text/html; charset=UTF-8"%>

<html>
    <head>
        <title>ztree树</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admin/js/zTree/css/zTreeStyle/zTreeStyle.css" />

        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/zTree/js/jquery.ztree.all.js"></script>

        <SCRIPT type="text/javascript">
            var setting = {
                check: {
                    enable: true
                },
                view: {
                    dblClickExpand: false,
                    showLine: true,
                    selectedMulti: false
                },
                data: {
                    simpleData: {
                        enable: true,
                        idKey: "id",
                        pIdKey: "pId",
                        rootPId: ""
                    }
                },
                callback: {
                    beforeClick: function (treeId, treeNode) {
                        var zTree = $.fn.zTree.getZTreeObj("tree");
                        if (treeNode.isParent) {
                            zTree.expandNode(treeNode);
                            return false;
                        } else {
                            demoIframe.attr("src", treeNode.file + ".html");
                            return true;
                        }
                    }
                }
            };

            $(document).ready(function () {
                var zNodes = new Array();
                <%--$.ajax({--%>
                <%--    url:"${pageContext.request.contextPath}/sysFunction/queryList",--%>
                <%--    method: "get",--%>
                <%--    async: false,--%>
                <%--    success: function (data) {--%>
                <%--        for (var i = 0; i < data.length; i ++) {--%>
                <%--            var sysFunction = {--%>
                <%--                id:data[i].id,--%>
                <%--                pId:data[i].parentId,--%>
                <%--                name:data[i].name,--%>
                <%--                open:true,--%>
                <%--                file:""--%>
                <%--            };--%>
                <%--            zNodes.push(sysFunction);--%>
                <%--        }--%>
                <%--    }--%>
                <%--});--%>
                <%--$.fn.zTree.init($("#tree"), setting, zNodes);--%>

                $.get("${pageContext.request.contextPath}/sysFunction/queryList", function (data) {
                    for (var i = 0; i < data.length; i ++) {
                        var sysFunction = {
                            id:data[i].id,
                            pId:data[i].parentId,
                            name:data[i].name,
                            open:true,
                            file:data[i].url,
                        };
                        zNodes.push(sysFunction);
                    }
                    $.fn.zTree.init($("#tree"), setting, zNodes);
                });

                 $("[type='button']").bind("click", function () {
                     // var iArray = [{name:"小明",age:12}, {name:"小王",age:12}, {name:"小李",age:12}, {name:"小张",age:12}];
                     // for (var i = 0; i < iArray.length; i ++) {
                     //     alert(iArray[i]);
                     // }
                     // $.map(iArray, function (row) {
                     //     alert(JSON.stringify(row));
                     // });

                     var leafNodes = new Array();

                     var treeObj = $.fn.zTree.getZTreeObj("tree");
                     var nodes = treeObj.getCheckedNodes(true);
                     $.map(nodes, function(node) {
                         if(!node.isParent) {
                             leafNodes.push(node.id);
                         }
                     });
                     // for (var i = 0; i < nodes.length; i ++) {
                     //     if (!nodes[i].isParent) {
                     //         leafNodes.push(nodes[i]);
                     //     }
                     // }
                     alert(JSON.stringify(leafNodes));
                 });
            });
        </SCRIPT>
    </head>

    <body>
        <div id="tree" class="ztree" style="width:260px; overflow:auto;"></div>
        <input type="button" value="显示所有选中的值" />
    </body>
</html>