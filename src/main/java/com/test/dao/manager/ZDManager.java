package com.test.dao.manager;


import com.test.dao.mapper.ZDMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ZDManager {
    @Resource
    private ZDMapper zdMapper;
}
