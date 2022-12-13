package com.test.biz;

import com.test.commom.BusinessException;
import com.test.dao.manager.KCManager;
import com.test.dao.manager.MXManager;
import com.test.dao.manager.WLManager;
import com.test.dao.manager.ZDManager;
import com.test.to.KCTO;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author feifan.han
 * @date 2022/12/13 19:14
 */
@Component
public class BizKCService {

    @Resource
    private WLManager wlManager;
    @Resource
    private ZDManager zdManager;
    @Resource
    private KCManager kcManager;
    @Resource
    private MXManager mxManager;


    /**
     * 单机syn
     * 集群setnx
     */
    @Transactional
    @Synchronized
    public boolean update(KCTO kcto) {
        if (!zdManager.addZD(null)) {
            throw new BusinessException();
        }

        wlManager.getByWLID(kcto.getWLID());

        if (!mxManager.addMX(null)) {
            throw new BusinessException();
        }
        if (!kcManager.updateKC(null)) {
            throw new BusinessException();
        }
        return true;
    }
}