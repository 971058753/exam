package com.test.dao.manager;


import com.test.dao.mapper.WLMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class WLManager {
    @Resource
    private WLMapper wlMapper;
}
