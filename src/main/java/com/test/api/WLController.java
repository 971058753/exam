package com.test.api;

import com.test.aop.annotation.ErrorCatch;
import com.test.biz.BizWLService;
import com.test.dao.manager.WLManager;
import com.test.dao.mapper.WLMapper;
import com.test.to.ServiceResult;
import com.test.to.WLTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 物料
 */
@RestController("/wl")
public class WLController {

    @Resource
    private BizWLService bizWLService;

    @RequestMapping("create")
    @ErrorCatch
    public ServiceResult<Boolean> create(@RequestBody WLTO wlto) {
        return ServiceResult.buildSuccess(bizWLService.add(wlto));
    }

    @RequestMapping("delete")
    @ErrorCatch
    public ServiceResult<Boolean> delete(Integer wlId) {
        return ServiceResult.buildSuccess(bizWLService.delete(wlId));
    }
}