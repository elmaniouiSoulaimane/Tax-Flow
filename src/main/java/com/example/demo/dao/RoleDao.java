package com.example.demo.dao;

import com.example.demo.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
    int deleteByRoleName(String roleName);
}
