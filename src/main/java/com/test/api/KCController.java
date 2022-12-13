package com.test.api;

import com.test.biz.BizKCService;
import com.test.dao.manager.WLManager;
import com.test.to.KCTO;
import com.test.to.ServiceResult;
import com.test.to.WLTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 库存
 */
@RestController("/kc")
public class KCController {

    @Resource
    private BizKCService bizKCService;

    @RequestMapping("add")
    public ServiceResult<Boolean> update(@RequestBody KCTO kcto) {
        return ServiceResult.buildSuccess(bizKCService.update(kcto));
    }


}