package net.noyark.top.mapper;

import net.noyark.top.entity.DataImage;
import net.noyark.top.entity.DataTop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewMapper {

    //根据id获取一个图片
    DataImage getImage(@Param("id") int id);

    //根据栏目id获取一系列图片对象
    List<DataImage> getImages(@Param("id") int tid);

    //获取全部的top id
    List<Integer> getTopIds();

    DataTop getTop(int tid);

}
