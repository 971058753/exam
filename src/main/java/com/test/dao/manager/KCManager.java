package com.test.dao.manager;


import com.test.dao.mapper.KCMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class KCManager {
    @Resource
    private KCMapper KCMapper;
}
