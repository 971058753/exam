package com.test.biz;

import com.test.commom.BusinessException;
import com.test.dao.manager.KCManager;
import com.test.dao.manager.MXManager;
import com.test.dao.manager.WLManager;
import com.test.dao.manager.ZDManager;
import com.test.dao.model.DJMXDO;
import com.test.dao.model.DJZDDO;
import com.test.dao.model.KCDO;
import com.test.dao.model.WLDO;
import com.test.to.KCTO;
import lombok.Synchronized;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

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
        WLDO wldo = wlManager.getByWLID(kcto.getWLID());
        if (wldo == null) {
            throw new BusinessException("物料信息不存在");
        }

        //主档
        DJZDDO djzddo = new DJZDDO();
        djzddo.setBZR(kcto.getBZR());
        djzddo.setBZRQ(new Date());
        djzddo.setDM_CZLX(kcto.getDM_CZLX());
        djzddo.setDJBH(getDJBH());
        if (!zdManager.addZD(djzddo)) {
            throw new BusinessException();
        }
        DJMXDO djmxdo = new DJMXDO();
        djmxdo.setWLID(wldo.getWLID());
        djmxdo.setDJID(djzddo.getDJID());
        djmxdo.setPH(kcto.getPH());
        djmxdo.setSL(kcto.getSL());
        djmxdo.setDJ(kcto.getDJ());
        djmxdo.setJE(kcto.getDJ().multiply(BigDecimal.valueOf(kcto.getSL())).setScale(2, RoundingMode.HALF_UP));

        //库存
        KCDO kcdo = kcManager.getByWLID(kcto.getWLID());
        if (kcdo == null) {
            if (kcto.getDM_CZLX() == 202) {
                throw new BusinessException("库存不存在 无发出库");
            }
            kcdo = new KCDO();
            kcdo.setWLID(kcto.getWLID());
            kcdo.setPH(kcto.getPH());
            kcdo.setSL(kcto.getSL());
            kcdo.setJE(kcto.getDJ().multiply(BigDecimal.valueOf(kcto.getSL())).setScale(2, RoundingMode.HALF_UP));
            if (!kcManager.add(kcdo)) {
                throw new BusinessException("入库失败");
            }

        } else {
            if (kcto.getDM_CZLX() == 201) {
                //入库
                kcdo.setSL(kcdo.getSL() + kcto.getSL());
                kcdo.setJE(kcdo.getJE().add(kcto.getDJ().multiply(BigDecimal.valueOf(kcto.getSL()))).setScale(2, RoundingMode.HALF_UP));
            }else {
                //出库
                kcdo.setSL(kcdo.getSL() - kcto.getSL());
                if (kcdo.getSL() < 0) {
                    throw new BusinessException("出库失败 库存不足");
                }
                kcdo.setJE(kcdo.getJE().subtract(kcto.getDJ().multiply(BigDecimal.valueOf(kcto.getSL()))).setScale(2,
                        RoundingMode.HALF_UP));
            }
            if (!kcManager.updateKC(kcdo)) {
                throw new BusinessException();
            }
        }
        djmxdo.setKCID(kcdo.getKCID());
        if (!mxManager.addMX(null)) {
            throw new BusinessException();
        }
        return true;
    }

    public String getDJBH() {
        return "20220001";
    }
}