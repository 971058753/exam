package com.test.to;

import lombok.Data;

@Data
public class WLTO {

    private String WLDH;
    private String WLMC;
    private String WLGG;
    private String WLDW;
    /**
     * 60 60 压缩归前端处理吧 直接上传oss仍个链接过来
     */
    private String TPLJ;

    private Integer DM_SHZT;
}