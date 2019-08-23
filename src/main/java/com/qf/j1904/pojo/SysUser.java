package com.qf.j1904.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class SysUser {
    private Integer userid;
    private String loginname;
    private String password;
    private Byte state;
    private Date createtime;
    private String realname;
}
