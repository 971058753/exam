package com.test.dao.manager;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.commom.BusinessException;
import com.test.dao.mapper.KCMapper;
import com.test.dao.mapper.WLMapper;
import com.test.dao.model.KCDO;
import com.test.dao.model.WLDO;
import com.test.to.WLTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class WLManager {
    @Resource
    private WLMapper wlMapper;

    public boolean add(WLDO wldo) {
        return wlMapper.insert(wldo) > 0;
    }

    public boolean delete(Integer wlId) {
        return wlMapper.deleteById(wlId) > 0;
    }

    public WLDO getByWLID(Integer wlId) {
        LambdaQueryWrapper<WLDO> q = new LambdaQueryWrapper<>();
        q.eq(WLDO::getWLID,wlId);
        return wlMapper.selectOne(q);
    }
}
