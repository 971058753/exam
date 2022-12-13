package com.test.dao.manager;


import com.test.commom.BusinessException;
import com.test.dao.mapper.KCMapper;
import com.test.dao.mapper.WLMapper;
import com.test.dao.model.WLDO;
import com.test.to.WLTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class WLManager {
    @Resource
    private WLMapper wlMapper;

    @Resource
    private KCManager kcManager;

    @Resource
    private MXManager mxManager;

    public boolean add(WLTO wlto) {
        WLDO wldo = new WLDO();
        BeanUtils.copyProperties(wlto,wldo);
        return wlMapper.insert(wldo) > 0;
    }

    public boolean delete(Integer wlId) {
        if (kcManager.existWLID(wlId) || mxManager.existWLID(wlId)) {
            throw new BusinessException("物料被使用");
        }
        return wlMapper.deleteById(wlId) > 0;
    }
}
