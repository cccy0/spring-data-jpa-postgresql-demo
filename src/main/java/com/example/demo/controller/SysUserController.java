package com.example.demo.controller;

import com.example.demo.domain.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<SysUser>> list(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(sysUserService.list(PageRequest.of(pageNum < 0 ? 0 : pageNum - 1, pageSize)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SysUser> create(@RequestBody SysUser user) {
        return ResponseEntity.ok(sysUserService.create(user));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<SysUser> update(@RequestBody SysUser resources) {
        SysUser user = sysUserService.get(resources.getId());
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(sysUserService.update(user, resources));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestBody SysUser resources) {
        SysUser user = sysUserService.get(resources.getId());
        if (user != null) {
            sysUserService.delete(user);
        }
        return ResponseEntity.ok().build();
    }
}
