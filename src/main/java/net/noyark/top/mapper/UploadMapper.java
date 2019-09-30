package net.noyark.top.mapper;

import net.noyark.top.entity.DataUser;
import org.apache.ibatis.annotations.Param;

/**
 * 主要有图片的增加，图片的删除
 *
 */

public interface UploadMapper {

    //图片增加
    Integer insertImage(@Param("path") String path, @Param("tid") int tid,@Param("name") String name, @Param("description") String description);

    //图片减少,改为false
    Integer deleteImage(@Param("id") int id);

    //删除指定的top，其实没有删除 只是将top改为false
    Integer deleteTop(@Param("id") int tid);

    //删除用户 改为false
    Integer deleteUser(@Param("id") int uid);

    //添加用户
    Integer registerUser(@Param("username") String username,@Param("password") String password,@Param("salt") String salt);

    //通过用户id找到盐值
    String getSaltById(@Param("id")int id);


    DataUser searchUser(@Param("name") String username, @Param("password") String password);

    DataUser searchUserByName(@Param("name")String username);

    Integer modifyUser(@Param("name")String username,@Param("password") String password);

    Integer addTop(@Param("name") String name,@Param("description") String description);


}
