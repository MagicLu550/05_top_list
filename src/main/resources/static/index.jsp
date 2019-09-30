<%@ page import="net.noyark.top.mapper.ViewMapper" %>
<%@ page import="java.util.List" %>
<%@ page import="net.noyark.top.entity.DataImage" %>
<%@ page import="net.noyark.top.entity.DataTop" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>荣耀榜单</title>
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            
        })
    </script>
</head>
<body>
    <!-- 头部的部分 -->
    <header>

    </header>
    <!-- 正文部分 -->
    <article>
        <%
            ViewMapper mapper = (ViewMapper) application.getAttribute("mapper");
            List<Integer> ids = mapper.getTopIds();
            for(int id : ids){
                DataTop top = mapper.getTop(id);
                //栏目

        %>
                <p><%=top.getName()%></p>
                <p><%=top.getDescription()%></p>
                <div>
        <%
                List<DataImage> images = mapper.getImages(id);
                for(DataImage image : images){
        %>
                    <%-- 图片--%>
                    <img alt="no such file" src="<%=image.getPath()%>" id="<%=image.getId()%>">
        <%
                }
            }
        %>
                </div>
        <!-- 此时这里要循环写图片和内容 -->
    </article>
    <!-- 脚步的部分 -->
    <footer>

    </footer>
</body>
</html>