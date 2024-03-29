package com.qf.j1904.service;

import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;

import java.util.List;

public interface SysUserService {
    public SysUser findByloginName(String loginName);
    public List<SysPermission> findAllPermission(String loginName);
}
