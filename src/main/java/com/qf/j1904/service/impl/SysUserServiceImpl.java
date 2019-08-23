package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.SysUserMapper;
import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import com.qf.j1904.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser findByloginName(String loginName) {
        return sysUserMapper.findByName(loginName);
    }
    @Override
    public List<SysPermission> findAllPermission(String loginName) {
        return sysUserMapper.findAllPermission(loginName);
    }
}
