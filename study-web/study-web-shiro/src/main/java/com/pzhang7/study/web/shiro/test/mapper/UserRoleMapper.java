package com.pzhang7.study.web.shiro.test.mapper;

import com.pzhang7.study.web.shiro.test.po.UserRole;

import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByUserID(Long userId);
}