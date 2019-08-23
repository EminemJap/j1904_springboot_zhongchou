package com.qf.j1904.mapper;

import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {
    public SysUser findByName(String loginName);
    public List<SysPermission> findAllPermission(String loginName);
}
