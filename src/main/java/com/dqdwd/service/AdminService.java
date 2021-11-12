package com.dqdwd.service;

import com.dqdwd.pojo.Admin;

public interface AdminService {
    public Admin login(String name,String pwd);
    public void addAdmin(Admin admin);
    public boolean existAdmin(String name);
}
