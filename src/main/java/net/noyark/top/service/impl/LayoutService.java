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


}
