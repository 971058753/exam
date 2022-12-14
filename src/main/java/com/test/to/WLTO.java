package com.test.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WLTO {
    @JsonProperty(value="WLDH")
    private String WLDH;
    @JsonProperty(value="WLMC")
    private String WLMC;
    @JsonProperty(value="WLGG")
    private String WLGG;
    @JsonProperty(value="WLDW")
    private String WLDW;
    /**
     * 60 60 压缩归前端处理吧 直接上传oss仍个链接过来
     */
    @JsonProperty(value="TPLJ")
    private String TPLJ;
    @JsonProperty(value="DM_SHZT")
    private Integer DM_SHZT;
}