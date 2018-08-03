package com.pzhang7.study.web.shiro.test.mapper;

import com.pzhang7.study.web.shiro.test.po.TestPo;

public interface TestPoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TestPo record);

    int insertSelective(TestPo record);

    TestPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TestPo record);

    int updateByPrimaryKey(TestPo record);
}