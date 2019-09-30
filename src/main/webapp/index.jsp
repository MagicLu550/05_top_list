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
        // 如果想要使一个元素运动起来，一般情况下这个元素须要具有position属性absolute/relative
        $(function(){
            var oul = $('.wraps div ul');
            var oulHtml = oul.html();
            oul.html(oulHtml+oulHtml)
            var timeId = null;

            var ali = $('.wraps div ul li');
            var aliWidth = ali.eq(0).width();
            var aliSize = ali.size();
            var ulWidth = aliWidth*aliSize;
            oul.width(ulWidth);	//1600px

            var speed = 2;

            function slider(){

                if(speed<0){
                    if(oul.css('left')== -ulWidth/2+'px'){
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

            var obj = $('.wraps div');

            obj.mouseover(function(){
                // clearInterval()函数的作用是用来清除定时器
                clearInterval(timeId);
            });

            obj.mouseout(function(){
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

    </header>
    <!-- 正文部分 -->
    <article>
        <button class=".goLeft">左移动</button>
        <button class=".goRight">右移动</button>
        <div class="warps">
            <%
                ViewMapper mapper = (ViewMapper) application.getAttribute("mapper");
                List<Integer> ids = mapper.getTopIds();
                //id
                for(int id : ids){
                    DataTop top = mapper.getTop(id);
                    //栏目
            %>
            <br>
            <p><%= top.getName() %></p>
            <p><%= top.getDescription() %></p>
            <div>
                <ul>

                    <%
                        List<DataImage> images = mapper.getImages(id);
                        for(DataImage image : images){
                    %>
                            <%-- 图片 --%>
                            <li><img alt="no such file" src="<%=image.getPath()%>" id="<%=image.getId()%>" style="width: 90%;"></li>
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