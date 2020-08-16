package com.example.demo.service;

import com.example.demo.dao.SysUserRepository;
import com.example.demo.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @author Zhai
 * 2020/8/17 0:06
 */
@Service
public class SysUserService {
    private SysUserRepository sysUserRepository;

    @Autowired
    public void setSysUserRepository(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    public Page<SysUser> list(Pageable pageable) {
        return sysUserRepository.findAllByIsDeleted(0, pageable);
    }

    public SysUser create(SysUser user) {
        return sysUserRepository.save(user);
    }

    @PostConstruct
    private void init() {
        SysUser user = new SysUser();
        user.setIsDeleted(0);
        if (sysUserRepository.count(Example.of(user)) == 0) {
            SysUser sysUser = new SysUser();
            sysUser.setUsername("test01");
            sysUser.setPassword("123");
            HashMap<String, Object> otherInfo = new HashMap<>(2);
            otherInfo.put("address", "北京市");
            otherInfo.put("email", "gamma@gmal.com");
            sysUser.setOtherInfo(otherInfo);
            create(sysUser);
        }
    }
}
