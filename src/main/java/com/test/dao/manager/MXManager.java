package com.test.dao.manager;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.dao.mapper.MXMapper;
import com.test.dao.model.DJMXDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MXManager {
    @Resource
    private MXMapper mxMapper;

    public Boolean existWLID(Integer wlId) {
        LambdaQueryWrapper<DJMXDO> q = new LambdaQueryWrapper<>();
        q.eq(DJMXDO::getWLID,wlId);
        return mxMapper.selectOne(q) != null;
    }
}
