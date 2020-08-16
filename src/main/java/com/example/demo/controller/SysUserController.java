package com.example.demo.controller;

import com.example.demo.domain.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhai
 * 2020/8/17 0:19
 */

@RestController
@RequestMapping(path = "/api/users")
public class SysUserController {
    private SysUserService sysUserService;

    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<Page<SysUser>> list(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(sysUserService.list(PageRequest.of(pageNum - 1, pageSize)));
    }
}
