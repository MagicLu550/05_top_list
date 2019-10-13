package net.noyark.top.controller;

import net.noyark.top.service.interf.IControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制后台的控制器
//-- 添加top,删除top
//-- 在top中添加图片和删除图片
//-- 点击top进入image表
@Controller
public class ControlController {

    @Autowired
    private IControlService service;
    //进入manager界面 首先登陆
    //登陆后进入面板区，做的简陋些
    //两个按钮 一个进入数据区 一个推出
    //数据区有添加按钮
    // 点击添加按钮 提交初始图片和名称 介绍
    // 每个数据栏有删除按钮
    //点击删除按钮则删除
    // 点击一个数据栏，可以进入新页面 然后添加图片，也可以删除图片
    //图片上传到一个专门文件夹

    @RequestMapping("/manager")
    public String showIndex(){
        return "login.jsp";
    }

    //后台登陆 + 后台一系列设置
    //还有存储图片的文件夹

}
