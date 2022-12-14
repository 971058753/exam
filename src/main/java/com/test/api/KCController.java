package com.test.api;

import com.test.biz.BizKCService;
import com.test.commom.BusinessException;
import com.test.commom.Validator;
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

    @RequestMapping("update")
    public ServiceResult<Boolean> update(@RequestBody KCTO kcto) {
        if (!Validator.isAllId(kcto.getDM_CZLX(), kcto.getWLID(), kcto.getSL()) ||
                !Validator.isAllNotNullOrEmpty(kcto.getBZR(), kcto.getDJ(), kcto.getPH())) {
            throw new BusinessException("参数异常");
        }
        return ServiceResult.buildSuccess(bizKCService.update(kcto));
    }


}