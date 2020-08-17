package com.example.demo.dao;

import com.example.demo.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Zhai
 * 2020/8/17 0:02
 */

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    /**
     * 查询用户列表
     * @param isDeleted isDeleted
     * @param pageable page信息
     * @return Page<SysUser>
     */
    Page<SysUser> findAllByIsDeleted(Integer isDeleted, Pageable pageable);
}
