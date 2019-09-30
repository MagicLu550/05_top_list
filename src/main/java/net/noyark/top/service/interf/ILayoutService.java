package net.noyark.top.service.interf;



import javax.servlet.ServletContext;


//把图片显示出去的内容
public interface ILayoutService {

    //返回jsp路径
    String show(ServletContext context);

}
