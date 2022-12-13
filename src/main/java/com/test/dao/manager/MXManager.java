package com.test.dao.manager;


import com.test.dao.mapper.MXMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MXManager {
    @Resource
    private MXMapper mxMapper;
}
