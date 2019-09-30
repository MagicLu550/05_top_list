package net.noyark.top.service.impl;


import net.noyark.top.mapper.ViewMapper;
import net.noyark.top.service.interf.ILayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.ServletContext;


@Service
public class LayoutService implements ILayoutService {


    @Autowired
    private ViewMapper mapper;
    //从数据库找到图片，之后

    //返回路径,之后控制器跳转路径
    @Override
    public String show(ServletContext model) {
        model.setAttribute("mapper",mapper);
        return "index.jsp";
    }

    //进入manager界面 首先登陆
    //登陆后进入面板区，做的简陋些
    //两个按钮 一个进入数据区 一个推出
    //数据区有添加按钮
        // 点击添加按钮 提交初始图片和名称 介绍
    // 每个数据栏有删除按钮
        //点击删除按钮则删除
    // 点击一个数据栏，可以进入新页面 然后添加图片，也可以删除图片
        //图片上传到一个专门文件夹
}
