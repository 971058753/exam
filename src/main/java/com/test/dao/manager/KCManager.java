package com.test.dao.manager;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.dao.mapper.KCMapper;
import com.test.dao.model.KCDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class KCManager {
    @Resource
    private KCMapper kcMapper;

    public Boolean existWLID(Integer wlId) {
        LambdaQueryWrapper<KCDO> q = new LambdaQueryWrapper<>();
        q.eq(KCDO::getWLID,wlId);
        return kcMapper.selectOne(q) != null;
    }
}

