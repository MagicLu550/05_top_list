package net.noyark.top.controller;


import net.noyark.top.service.interf.ILayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LayoutController {

    @Autowired
    private ILayoutService service;


    //展示图片
    @RequestMapping("/show")
    public String show(HttpServletRequest request){
        return service.show(request.getServletContext());
    }



}
