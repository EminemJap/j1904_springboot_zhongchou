package com.qf.j1904;


import com.qf.j1904.pojo.SysPermission;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class J1904SpringbootZhongchouApplicationTests {
//    @Resource
//    private SysPermissionMapper sysPermissionMapper;
//    @Test
//    public void contextLoads() {
//        List<SysPermission> allPermission = sysPermissionMapper.findAllPermission();
//        allPermission.forEach(System.out::println);
//    }
    @Test
    public void TestMd5(){
        Md5Hash md5Hash=new Md5Hash("1234","abc",1024);
        System.out.println(md5Hash);
    }

}
