package com.qf.j1904.pojo;

import lombok.Data;

@Data
public class SysPermission {
    private long  permission_id;  //权限id
    private String per_name;//权限名
    private String menu_name;//菜单名
    private String menu_type;//菜单分类
    private String menu_url;//菜单接口url
    private String menu_code;//菜单编号
    private String pId;//父编号//原来是parent_code 改为pid
    private String per_desc;//权限描述
    private String if_vilid;//是否有效
    private String setChecked="false";
}
