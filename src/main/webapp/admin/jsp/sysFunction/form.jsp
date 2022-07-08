<%@page contentType="text/html; charset=UTF-8"%>

<html>
    <head>
        <title>ztree树</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/admin/js/zTree/css/zTreeStyle/zTreeStyle.css" />

        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/zTree/js/jquery.ztree.all.js"></script>

        <SCRIPT type="text/javascript">
            var setting = {
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
                $.get("${pageContext.request.contextPath}/sysFunction/queryList", function (data) {
                    var zNodes = new Array();
                    for (var i = 0; i < data.length; i ++) {
                        var sysFunction = {
                            id:data[i].id,
                            pId:data[i].parentId,
                            name:data[i].name,
                            open:true,
                            file:""
                        };
                        zNodes.push(sysFunction);
                    }
                    $.fn.zTree.init($("#tree"), setting, zNodes);
                });
            });
        </SCRIPT>
    </head>

    <body>
        <div id="tree" class="ztree" style="width:260px; overflow:auto;"></div>
    </body>
</html>