package com.dqdwd.service.impl;

import com.dqdwd.mapper.AdminMapper;
import com.dqdwd.pojo.Admin;
import com.dqdwd.pojo.AdminExample;
import com.dqdwd.service.AdminService;
import com.dqdwd.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(String name, String pwd) {
        AdminExample example=new AdminExample();
        //添加用户名a_name条件
        example.createCriteria().andANameEqualTo(name);
        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins.size()>0){
            Admin admin = admins.get(0);
          //  String mipwd= MD5Util.getMD5(pwd);
            if(pwd.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public boolean existAdmin(String name) {
        AdminExample example=new AdminExample();
         example.createCriteria().andANameEqualTo(name);
        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins.size()==0){
            return false;
        }else{
            return true;
        }
    }
}
