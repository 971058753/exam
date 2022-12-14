package com.test.to;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class KCTO {
    /**
     * 物料ID
     */
    @JsonProperty(value="WLID")
    private Integer WLID;
    /**
     * 数量
     */
    @JsonProperty(value="SL")
    private Integer SL;
    /**
     * 坯号
     */
    @JsonProperty(value="PH")
    private String PH;
    /**
     * 单价
     */
    @JsonProperty(value="DJ")
    private String DJ;
    /**
     * 操作类型
     * 201 入
     * 202 出
     */
    @JsonProperty(value="DM_CZLX")
    private Integer DM_CZLX;
    /**
     * 编制人
     */
    @JsonProperty(value="BZR")
    private String BZR;

    public BigDecimal getDJ() {
        return new BigDecimal(DJ);
    }
}