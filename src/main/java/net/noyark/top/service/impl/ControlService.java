package net.noyark.top.service.impl;


import net.noyark.top.Util;
import net.noyark.top.entity.DataImage;
import net.noyark.top.entity.DataTop;
import net.noyark.top.entity.DataUser;
import net.noyark.top.ex.PasswordErrorException;
import net.noyark.top.ex.UserExistsException;
import net.noyark.top.ex.UserNotFoundException;
import net.noyark.top.mapper.UploadMapper;
import net.noyark.top.service.interf.IControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlService implements IControlService {

    @Autowired
    private UploadMapper mapper;

    @Override
    public boolean login(DataUser user) {
        String salt = mapper.getSaltById(user.getId());
        noUser(user);
        DataUser found = mapper.searchUser(user.getName(),Util.md5Password(user.getPasswordMd5(),salt));
        if(found == null){
            throw new PasswordErrorException("用户名和密码错误");
        }else{
            return true;
        }
    }

    private boolean existsUser(DataUser user){
        if(mapper.searchUserByName(user.getName()) != null){
            throw new UserExistsException("用户已经存在");
        }
        return false;
    }

    private boolean noUser(DataUser user){
        if(mapper.searchUserByName(user.getName()) == null){
            throw new UserNotFoundException("用户不存在");
        }
        return false;
    }

    @Override
    public boolean register(DataUser user) {
        existsUser(user);
        mapper.registerUser(user.getName(),Util.md5Password(user.getPasswordMd5(),user.getName()),user.getName());
        return true;
    }

    @Override
    public boolean modify(DataUser user) {
        noUser(user);
        mapper.modifyUser(user.getName(),user.getPasswordMd5());
        return true;
    }

    @Override
    public boolean insertImage(DataImage data) {
        mapper.insertImage(data.getPath(),data.getTid(),data.getName(),data.getDescription());
        return true;
    }

    @Override
    public boolean deleteImage(DataImage data) {
        mapper.deleteImage(data.getId());
        return true;
    }

    @Override
    public boolean insertTop(DataTop top) {
        mapper.addTop(top.getName(),top.getDescription());
        return true;
    }

    @Override
    public boolean deleteTop(DataTop top) {
        mapper.deleteTop(top.getId());
        return true;
    }
}
