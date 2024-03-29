<%@ page import="net.noyark.top.mapper.ViewMapper" %>
<%@ page import="java.util.List" %>
<%@ page import="net.noyark.top.entity.DataImage" %>
<%@ page import="net.noyark.top.entity.DataTop" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>荣耀榜单</title>
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="bootstrap.min.js"></script>
    <script type="text/javascript">
        // 如果想要使一个元素运动起来，一般情况下这个元素须要具有position属性absolute/relative
        $(function(){
            var oul = $('.wrap ul');
            var oulHtml = oul.html();
            oul.html(oulHtml+oulHtml)
            var timeId = null;

            var ali = $('.wrap ul li');
            var aliWidth = ali.eq(0).width();
            var aliSize = ali.size();
            var ulWidth = aliWidth*aliSize;
            oul.width(ulWidth);	//1600px

            var speed = 2;

            function slider(){

                if(speed<0){
                    if(oul.css('left')==-ulWidth/2+'px'){
                        oul.css('left',0);
                    }
                    oul.css('left','+=-2px');
                }


                if(speed>0){
                    if(oul.css('left')=='0px'){
                        oul.css('left',-ulWidth/2+'px');
                    }
                    oul.css('left','+='+speed+'px');
                }

            }

            // setInterval()函数的作用是：每隔一段时间，执行该函数里的代码
            timeId = setInterval(slider,30);

            $('.wrap').mouseover(function(){
                // clearInterval()函数的作用是用来清除定时器
                clearInterval(timeId);
            });

            $('.wrap').mouseout(function(){
                timeId = setInterval(slider,30);
            });

            $('.goLeft').click(function(){
                speed=-2;
            });

            $('.goRight').click(function(){
                speed=2;
            });

        });
    </script>
    <style type="text/css">
        @import "index.css";
    </style>

</head>
<body>
    <!-- 头部的部分 -->
    <header>
        <p id="title">荣誉榜</p>
    </header>
    <!-- 正文部分 -->
    <article>

        <div class="warps">
            <a href="javascript:" class="goLeft">向左走</a> <a href="javascript:" class="goRight">向右走</a>
            <div class="wrap">
                <ul>
                    <li>
                        <p>a</p>
                        <img src="test/1.jpg" alt="" style="width:90%;">
                    </li>
                    <li>
                        <p>b</p>
                        <img src="test/2.jpeg" alt="" style="width:90%;">

                    </li>
                    <li>
                        <p>c</p>
                        <img src="test/3.jpg" alt="" style="width:90%;">
                    </li>
                </ul>
            </div>
            <p>hello</p>
            <div class="wrap">
                <ul>
                    <li>
                        <img src="test/1.jpg" alt="" style="width:90%;">
                        <p>a</p>
                    </li>
                    <li><img src="test/2.jpeg" alt="" style="width:90%;">
                        <p>b</p>
                    </li>
                    <li>
                        <img src="test/3.jpg" alt="" style="width:90%;">
                        <p>c</p>
                    </li>
                </ul>
            </div>

            <%
                ViewMapper mapper = (ViewMapper) application.getAttribute("mapper");
                List<Integer> ids = mapper.getTopIds();
                //id
                for(int id : ids){
                    DataTop top = mapper.getTop(id);
                    if(top.getDeleted()==1)continue;
                    //栏目
            %>
            <br>
            <p><%= top.getName() %></p>
            <p><%= top.getDescription() %></p>
            <div id="<%=id %>" class="wrap">
                <ul>
                        <%
                        List<DataImage> images = mapper.getImages(id);
                        for(DataImage image : images){
                            if(image.getDeleted()==1)continue;
                        %>
                        <%-- 图片 --%>
                            <li>
                                <p><%=image.getName()%></p>
                                <p><%=image.getDescription()%></p>
                                <img alt="no such file" src="<%=image.getPath()%>" id="<%=image.getId()%>" style="width: 90%;">
                            </li>
                        <%
                        }
                    %>
                </ul>
            </div>
            <%
                }
            %>

            <!-- 此时这里要循环写图片和内容 -->
        </div>

    </article>
    <!-- 脚步的部分 -->
    <footer>

    </footer>
</body>
</html>