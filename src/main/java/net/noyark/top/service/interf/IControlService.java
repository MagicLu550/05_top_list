package net.noyark.top.service.interf;

import com.sun.scenario.effect.ImageData;
import net.noyark.top.entity.DataImage;
import net.noyark.top.entity.DataTop;
import net.noyark.top.entity.DataUser;


/**
 * 登陆和修改密码以及添加用户
 * 添加图片 删除图片 添加栏目 删除栏目
 */
public interface IControlService {

    //登陆
    boolean login(DataUser user);

    //注册
    boolean register(DataUser user);

    //修改
    boolean modify(DataUser user);

    //添加图片
    boolean insertImage(DataImage data);

    //删除图片
    boolean deleteImage(DataImage data);

    //添加栏目
    boolean insertTop(DataTop top);

    //删除栏目
    boolean deleteTop(DataTop top);

}
