package com.test.dao.manager;


import com.test.dao.mapper.ZDMapper;
import com.test.dao.model.DJZDDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ZDManager {
    @Resource
    private ZDMapper zdMapper;

    /**
     * 添加主档
     */
    public boolean addZD(DJZDDO djzddo) {
        return zdMapper.insert(djzddo) > 0;
    }
}
