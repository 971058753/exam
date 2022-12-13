package com.test.biz;

import com.test.commom.BusinessException;
import com.test.dao.manager.KCManager;
import com.test.dao.manager.MXManager;
import com.test.dao.manager.WLManager;
import com.test.dao.model.WLDO;
import com.test.to.WLTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author feifan.han
 * @date 2022/12/13 19:14
 */
@Component
public class BizWLService {

    @Resource
    private WLManager wlManager;


    @Resource
    private KCManager kcManager;

    @Resource
    private MXManager mxManager;

    public boolean add(WLTO wlto) {
        WLDO wldo = new WLDO();
        BeanUtils.copyProperties(wlto,wldo);
        return wlManager.add(wldo);
    }


    public boolean delete(Integer wlId) {
        if (kcManager.existWLID(wlId) || mxManager.existWLID(wlId)) {
            throw new BusinessException("物料被使用");
        }
        return wlManager.delete(wlId);
    }
}